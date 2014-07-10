package org.poo.geomago;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Upper Game Menu Action Listener
 */
public class GameFrameMenuListener implements ActionListener {

	private GameLogic gameBoard;
	private GameFrame gameFrame;

	/**
	 * Constructor
	 * @param gameBoard	
	 */
	public GameFrameMenuListener(GameLogic gameBoard, GameFrame gameFrame) {
		this.gameBoard = gameBoard;
		this.gameFrame = gameFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem)(e.getSource());
		String mText = menuItem.getText();
		
		if(mText.equals("New Game...")) {
			NewGameDialog n = new NewGameDialog("New Game", 160, 230, 10, gameFrame);
			n.setVisible(true);
		}
		if(mText.equals("Quit GeoMago")) {
			int i = okcancel(menuItem, "Quit GeoMago :c?");
			if(i == 0)
				System.exit(0);
		}
	}


	private int okcancel(JMenuItem parent, String theMessage) {
		int result = JOptionPane.showConfirmDialog(parent, theMessage,
			"Confirm", JOptionPane.OK_CANCEL_OPTION);
		return result;
	}
}
