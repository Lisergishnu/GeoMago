package org.poo.geomago.jugabilidad;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;

import org.poo.geomago.celda.CeldaView;
import org.poo.geomago.etc.TriangleShape;

public class TrianguloPiezaView {
	private TrianguloPieza pieza;
	private TriangleShape shape;
	private Color piezaColor;

	public TrianguloPiezaView(TrianguloPieza pieza) {
		this.pieza = pieza;	
		shape = new TriangleShape(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.05, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.05, 
				CeldaView.CELDA_WIDTH*.9, 
				CeldaView.CELDA_HEIGHT*.9);
		
		piezaColor = pieza.playerOwner.getPlayerColor();
	}
	
	protected void paintComponent(Graphics2D g) {
		g.setColor(piezaColor);
		shape.fill(g);
		
		g.setColor(piezaColor.darker().darker().darker());
		g.drawString(pieza.nMovimientos+"/"+pieza.nMaxMovimientos, 
				(int)(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.175), 
				(int)(pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.675));
	}
	
}
