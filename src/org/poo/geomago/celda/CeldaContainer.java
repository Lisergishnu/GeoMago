package org.poo.geomago.celda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CeldaContainer extends JPanel {
	private ArrayList<CeldaView> list;
	
	/**
	 * Celda container JPanel, has a list of CellViews
	 */
	public CeldaContainer() {
		list = new ArrayList<CeldaView>();
	}
	
	/**
	 * Adds a cellView to the Container
	 * @param c new cellView
	 */
	public void addCelda(CeldaView c) {
		list.add(c);
	}
	
	/**
	 * Sets the CeldaContainer JPanel NewSize
	 * @param w panel width
	 * @param h panel height
	 */
	public void setNewSize(int w,int h){
		setSize(w,h);
	}
	
	/**
	 * Paints all CeldaViews in CeldaContainer
	 */
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (CeldaView celdaView : list) {
			celdaView.paintComponent(g2);
		}
	}
}
