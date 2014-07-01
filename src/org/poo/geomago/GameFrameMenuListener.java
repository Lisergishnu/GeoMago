package org.poo.geomago;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

public class GameFrameMenuListener implements ActionListener {

	
	private GameModel gameModel;

	public GameFrameMenuListener(GameModel gameModel) {
		this.gameModel = gameModel;
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
