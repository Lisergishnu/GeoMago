package org.poo.geomago;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

/**
 * Upper Game Menu Action Listener
 */
public class GameFrameMenuListener implements ActionListener {

	private GameBoard gameBoard;

	/**
	 * Constructor
	 * @param gameBoard	
	 */
	public GameFrameMenuListener(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JMenuItem menuItem = (JMenuItem)(e.getSource());
		String text = menuItem.getText();
		
		if(text.equals("New Game...")) {
			//TODO: ...
			NewGameDialog n = new NewGameDialog();
			n.setVisible(true);
		}
		if(text.equals("Quit GeoMago")) {
			System.exit(0);
		}
		
	}

}
