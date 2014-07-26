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
		if(mText.equals("Nueva partida...")) {
			if(gameBoard != null) {
				int i = okcancel(gameFrame, "Hay un juego en progreso. ¿Desea terminarlo y hacer uno nuevo?");
				if (i != 0)
					return;
			}
			NewGameDialog n = new NewGameDialog("Nueva partida", 300, 250, 10, gameFrame);
			n.setVisible(true);
		}
		if(mText.equals("Salir de GeoMago")) {
			if (gameBoard != null) {
				int i = okcancel(gameFrame, "¿Seguro que quiere salir?");
				if(i == 0)
					System.exit(0);
			}
		}
		if(mText.equals("Acerca...")) {
			AboutDialog about = new AboutDialog("About", 300, 200, 10, gameFrame);
			about.setVisible(true);
		}
	}


	private int okcancel(Component parent, String theMessage) {
		int result = JOptionPane.showConfirmDialog(parent, theMessage,
				"Confirmar", JOptionPane.OK_CANCEL_OPTION);
		return result;
	}
}
