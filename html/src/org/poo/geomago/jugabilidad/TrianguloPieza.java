package org.poo.geomago.jugabilidad;

import java.awt.Graphics2D;

import org.poo.geomago.celda.Celda;

public class TrianguloPieza extends Pieza {

	private TrianguloPiezaView view;

	public TrianguloPieza(Jugador jugador, Celda initialPos) {
		super(jugador, initialPos, 3);
		
		view = new TrianguloPiezaView(this);
	}

	@Override
	public void draw(Graphics2D g) {
		view.paintComponent(g);
	}

}
