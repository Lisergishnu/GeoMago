package org.poo.geomago.jugabilidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.*;

import org.poo.geomago.celda.CeldaView;

public class CirculoPiezaView {

	private CirculoPieza pieza;
	private Ellipse2D.Double shape;
	private Color piezaColor;

	public CirculoPiezaView(CirculoPieza pieza) {
		this.pieza = pieza;	
		shape = new Ellipse2D.Double(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.1, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.1, 
				CeldaView.CELDA_WIDTH*.8, 
				CeldaView.CELDA_HEIGHT*.8);

		piezaColor = pieza.playerOwner.getPlayerColor();
	}

	protected void paintComponent(Graphics2D g) {
		shape.setFrame(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.1, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.1, 
				CeldaView.CELDA_WIDTH*.8, 
				CeldaView.CELDA_HEIGHT*.8);;

		g.setColor(piezaColor);
		g.fill(shape);
	}

}
