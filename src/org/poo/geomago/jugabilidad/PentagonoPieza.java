package org.poo.geomago.jugabilidad;

import java.awt.Graphics2D;

import org.poo.geomago.celda.Celda;

public class PentagonoPieza extends Pieza {
	
	private PentagonoPiezaView view;

	public PentagonoPieza(Jugador jugador, Celda initialPos) {
		super(jugador, initialPos, 5);
		
		view = new PentagonoPiezaView(this);
	}

	@Override
	public void draw(Graphics2D g) {
		view.paintComponent(g);		
	}

	/*@Override
	public void mouseDrag(int xOnScreen, int yOnScreen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseRelease(Celda destino) {
		// TODO Auto-generated method stub
		
	}*/

	

}
