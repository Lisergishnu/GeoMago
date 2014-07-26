package org.poo.geomago;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Upper Game Menu Action Listener
 */
public class GameFrameMenuListener implements ActionListener {

	private GameFrame gameFrame;

	/**
	 * Constructor
	 * @param gameBoard	
	 */
	public GameFrameMenuListener(GameFrame gameFrame) {
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem)(e.getSource());
		String mText = menuItem.getText();
		GameLogic gameBoard = gameFrame.getCurrentGame();
		if(mText.equals("New Game...")) {
			if(gameBoard != null) {
				int i = okcancel(gameFrame, "There is a game in progress, Want to end it?");
				if (i != 0)
					return;
			}
			NewGameDialog n = new NewGameDialog("New Game", 300, 200, 10, gameFrame);
			n.setVisible(true);
		}
		if(mText.equals("Quit GeoMago")) {
			int i = okcancel(gameFrame, "Quit GeoMago?");
			if(i == 0)
				System.exit(0);
		}
		if(mText.equals("About...")) {
			AboutDialog about = new AboutDialog("About", 300, 200, 10, gameFrame);
			about.setVisible(true);
		}
	}


	private int okcancel(Component parent, String theMessage) {
		int result = JOptionPane.showConfirmDialog(parent, theMessage,
			"Confirm", JOptionPane.OK_CANCEL_OPTION);
		return result;
	}
}
