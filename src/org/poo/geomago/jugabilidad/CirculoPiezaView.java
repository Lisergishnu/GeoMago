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
		shape = new Ellipse2D.Double(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.05, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.05, 
				CeldaView.CELDA_WIDTH*.9, 
				CeldaView.CELDA_HEIGHT*.9);

		piezaColor = pieza.playerOwner.getPlayerColor();
	}

	protected void paintComponent(Graphics2D g) {
		shape.setFrame(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.05, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.05, 
				CeldaView.CELDA_WIDTH*.9, 
				CeldaView.CELDA_HEIGHT*.9);;

		g.setColor(piezaColor);
		g.fill(shape);
		
		g.setColor(piezaColor.darker().darker().darker());
		g.drawString(pieza.nMovimientos+"/"+pieza.nMaxMovimientos, 
				(int)(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.175), 
				(int)(pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.675));
	}

}
