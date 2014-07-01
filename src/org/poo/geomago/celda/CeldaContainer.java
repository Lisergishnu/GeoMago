package org.poo.geomago.celda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class CeldaContainer extends JPanel {
	private ArrayList<CeldaView> list;
	
	public CeldaContainer() {
		list = new ArrayList<CeldaView>();
		setSize(0,0);
	}
	
	public void addCelda(CeldaView c) {
		list.add(c);
	}
	
	protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (CeldaView celdaView : list) {
			celdaView.paintComponent(g2);
		}
	}
}
