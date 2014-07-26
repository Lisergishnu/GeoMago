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
}