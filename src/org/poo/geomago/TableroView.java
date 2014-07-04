package org.poo.geomago;

import java.awt.*;

import javax.swing.*;

import org.poo.geomago.celda.CeldaContainer;
import org.poo.geomago.celda.CeldaView;

/**
 * Viewer Class for the Game Board
 */
public class TableroView extends JPanel {
	private CeldaContainer celdaContainer;
	private GameBoard parent;

	/**
	 * Instantiates the Game Board Viewer and sets gameBoard as controller for
	 * this class. Also initializes the CeldaContainer array and sets the Layout as GridLayout.
	 * @param gameBoard controller GameBoard
	 * @see	CeldaContainer
	 */
	public TableroView(GameBoard gameBoard) {
		parent = gameBoard;
		createGrid();
		celdaContainer.setLayout(new GridLayout(gameBoard.getWidthCells(), gameBoard.getHeightCells() ));	
		add(celdaContainer);
	}
	
	/**
	 * Creates a new CeldaContainer with the number of cells
	 * of gameBoard
	 */
	private void createGrid() {
		celdaContainer = new CeldaContainer();
		for (int i = 0; i < parent.getWidthCells(); i++) {
			for (int j = 0; j < parent.getHeightCells(); j++) {
				celdaContainer.addCelda(parent.getTableroState()[i][j].getView());
			}
		}
		celdaContainer.setPreferredSize(new Dimension((int) (parent.getWidthCells()*CeldaView.CELDA_WIDTH), (int)(parent.getHeightCells()*CeldaView.CELDA_HEIGHT)));
	}
}
