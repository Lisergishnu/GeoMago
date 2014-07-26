package org.poo.geomago.celda;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

import org.poo.geomago.GameLogic;
import org.poo.geomago.jugabilidad.Jugador;
import org.poo.geomago.jugabilidad.Pieza;

/**
 * Celda container JPanel, has a list of CellViews
 * Also draws Piezas
 */
public class CeldaContainer extends JPanel implements MouseMotionListener, MouseInputListener {
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
		this.addMouseMotionListener(this);
		this.addMouseListener(this);
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
	@Override
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		int clickX = (int) (arg0.getX() / CeldaView.CELDA_WIDTH);
		int clickY = (int) (arg0.getY() / CeldaView.CELDA_HEIGHT);
		System.out.println("Mouse Click: (" + clickX+ "," + clickY + ")");	
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void mouseReleased(MouseEvent e) {
		// End Drag if exists
		int movX = (int) (e.getX() / CeldaView.CELDA_WIDTH);
		int movY = (int) (e.getY() / CeldaView.CELDA_HEIGHT);
		gameLogic.mouseRelease(movX, movY);
		repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int movX = (int) (e.getX() / CeldaView.CELDA_WIDTH);
		int movY = (int) (e.getY() / CeldaView.CELDA_HEIGHT);
		gameLogic.mouseDrag(movX,movY,e.getX(),e.getY());
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int movX = (int) (e.getX() / CeldaView.CELDA_WIDTH);
		int movY = (int) (e.getY() / CeldaView.CELDA_HEIGHT);
		gameLogic.getTableroState()[movX][movY].mouseOver();
	}
	
	
}
