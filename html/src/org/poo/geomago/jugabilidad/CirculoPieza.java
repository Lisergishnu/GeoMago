package org.poo.geomago.jugabilidad;

import java.awt.Graphics2D;

import org.poo.geomago.celda.Celda;

public class CirculoPieza extends Pieza {
	
	private CirculoPiezaView view;

	public CirculoPieza(Jugador jugador, Celda initialPos) {
		super(jugador, initialPos, 1);
		view = new CirculoPiezaView(this);
	}

	@Override
	public void draw(Graphics2D g) {
		view.paintComponent(g);
	}
}
