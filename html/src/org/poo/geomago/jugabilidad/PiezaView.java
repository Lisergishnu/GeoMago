package org.poo.geomago.jugabilidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.RectangularShape;

import org.poo.geomago.celda.CeldaView;

public class PiezaView {

	protected Pieza pieza;
	protected Color piezaColor;
	protected RectangularShape shape;
	
	protected void paintComponent(Graphics2D g) {
		if (pieza.isBeingDragged) {
		shape.setFrame(pieza.getX() - CeldaView.CELDA_WIDTH/2, 
				pieza.getY() - CeldaView.CELDA_HEIGHT/2 , 
				CeldaView.CELDA_WIDTH*.9, 
				CeldaView.CELDA_HEIGHT*.9);
		} else {
			shape.setFrame(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.05, 
					pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.05, 
					CeldaView.CELDA_WIDTH*.9, 
					CeldaView.CELDA_HEIGHT*.9);
		}
		g.setColor(piezaColor);
		g.fill(shape);
		
	}

	
}
