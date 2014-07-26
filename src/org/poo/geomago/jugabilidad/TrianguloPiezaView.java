package org.poo.geomago.jugabilidad;

import org.poo.geomago.celda.CeldaView;
import org.poo.geomago.etc.TriangleShape;

public class TrianguloPiezaView extends PiezaView {
	
	/**
	 * Paints the triangle
	 * @param pieza
	 */

	public TrianguloPiezaView(TrianguloPieza pieza) {
		this.pieza = pieza;	
		shape = new TriangleShape(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.05, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.05, 
				CeldaView.CELDA_WIDTH*.9, 
				CeldaView.CELDA_HEIGHT*.9);
		
		piezaColor = pieza.playerOwner.getPlayerColor();
	}
	
}
