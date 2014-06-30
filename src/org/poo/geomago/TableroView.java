package org.poo.geomago;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TableroView extends JPanel {
	
	private JScrollPane scrollPane;
	private CeldaContainer celdaContainer;

	public TableroView() {
		setLayout(new BorderLayout());
		createGrid();
		scrollPane = new JScrollPane(celdaContainer);
		add(scrollPane, BorderLayout.CENTER);
	}
	
	private void createGrid() {
		celdaContainer = new CeldaContainer();
		for (int i = 0; i < 40; i++) {
			for (int j = 0; j < 40; j++) {
				celdaContainer.addCelda(new CeldaView(i,j));
			}
		}
		celdaContainer.setPreferredSize(new Dimension((int) (40*CeldaView.CELDA_WIDTH), (int)(40*CeldaView.CELDA_HEIGHT)));
	}

}
