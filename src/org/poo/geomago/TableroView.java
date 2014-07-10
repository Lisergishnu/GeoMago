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
	private GameLogic parent;

	/**
	 * Instantiates the Game Board Viewer and sets gameBoard as controller for
	 * this class. Also initializes the CeldaContainer array and sets the Layout as GridLayout.
	 * @param gameBoard controller GameBoard
	 * @see	CeldaContainer
	 */
	public TableroView(GameLogic gameBoard) {
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
		celdaContainer = new CeldaContainer(parent);
		celdaContainer.setPreferredSize(new Dimension((int) (parent.getWidthCells()*CeldaView.CELDA_WIDTH), (int)(parent.getHeightCells()*CeldaView.CELDA_HEIGHT)));
	}
	
	
}
