package org.poo.geomago;

import java.awt.*;

import javax.swing.*;

import org.poo.geomago.celda.CeldaContainer;
import org.poo.geomago.celda.CeldaView;

public class TableroView extends CeldaContainer {
	private CeldaContainer celdaContainer;
	private GameBoard parent;

	/**
	 * View of the Game Board
	 * @param gameBoard
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
