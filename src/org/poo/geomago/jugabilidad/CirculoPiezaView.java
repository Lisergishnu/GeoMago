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
		shape = new Ellipse2D.Double(pieza.getX()*CeldaView.CELDA_WIDTH, 
				pieza.getY()*CeldaView.CELDA_HEIGHT, 
				CeldaView.CELDA_WIDTH, 
				CeldaView.CELDA_HEIGHT);

		switch (pieza.playerOwner.getID()) {
		case 1:
			piezaColor = Color.red;
			break;

		default:
			piezaColor = Color.gray;
			break;
		}
	}

	protected void paintComponent(Graphics2D g) {
		shape.setFrame(pieza.getX()*CeldaView.CELDA_WIDTH, 
				pieza.getY()*CeldaView.CELDA_HEIGHT, 
				CeldaView.CELDA_WIDTH, 
				CeldaView.CELDA_HEIGHT);

		g.setColor(piezaColor);
		g.fill(shape);
	}

}
