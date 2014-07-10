package org.poo.geomago.celda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.poo.geomago.GameLogic;
import org.poo.geomago.jugabilidad.Jugador;
import org.poo.geomago.jugabilidad.Pieza;

/**
 * Celda container JPanel, has a list of CellViews
 * Also draws Piezas
 */
public class CeldaContainer extends JPanel {
	private ArrayList<CeldaView> list;
	private GameLogic gameLogic;
	
	/**
	 * Default constructor, creates a list of Celdas.
	 * @param parent Initialized GameLogic
	 */
	public CeldaContainer(GameLogic parent) {
		gameLogic = parent;
		list = new ArrayList<CeldaView>();
		for (int i = 0; i < parent.getWidthCells(); i++) {
			for (int j = 0; j < parent.getHeightCells(); j++) {
				list.add(parent.getTableroState()[i][j].getView());
			}
		}
		
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
		for (Jugador player : gameLogic.getPlayersList()) {
			for (Pieza p : player.getPiezas()) {
				p.draw(g2);
			}
		}
	}
}
