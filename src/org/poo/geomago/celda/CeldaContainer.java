package org.poo.geomago.celda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Celda container JPanel, has a list of CellViews
 */
public class CeldaContainer extends JPanel {
	private ArrayList<CeldaView> list;
	
	/**
	 * Default constructor, creates a list of Celdas.
	 */
	public CeldaContainer() {
		list = new ArrayList<CeldaView>();
	}
	
	/**
	 * Adds a CeldaView to the Container
	 * @param c new cellView
	 * @see CeldaView
	 */
	public void addCelda(CeldaView c) {
		list.add(c);
	}
	
	/**
	 * Paints all CeldaViews in CeldaContainer
	 * @see CeldaView
	 */
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (CeldaView celdaView : list) {
			celdaView.paintComponent(g2);
		}
	}
}
