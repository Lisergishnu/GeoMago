package org.poo.geomago;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.poo.geomago.celda.CeldaContainer;
import org.poo.geomago.celda.CeldaView;

public class TableroView extends JPanel {
	
	private JScrollPane scrollPane;
	private CeldaContainer celdaContainer;
	private GameBoard parent;

	public TableroView(GameBoard gameBoard) {
		parent = gameBoard;
		setLayout(new BorderLayout());
		createGrid();
		scrollPane = new JScrollPane(celdaContainer);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void createGrid() {
		celdaContainer = new CeldaContainer();
		for (int i = 0; i < parent.getWidthCells(); i++) {
			for (int j = 0; j < parent.getHeightCells(); j++) {
				celdaContainer.addCelda(parent.getTableroState()[i][j].getView());
			}
		}
		celdaContainer.setPreferredSize(new Dimension((int) (40*CeldaView.CELDA_WIDTH), (int)(40*CeldaView.CELDA_HEIGHT)));
	}

}
