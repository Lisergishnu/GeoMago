package org.poo.geomago.jugabilidad;

import java.awt.geom.*;

import org.poo.geomago.celda.CeldaView;

public class CirculoPiezaView extends PiezaView {

	public CirculoPiezaView(CirculoPieza pieza) {
		this.pieza = pieza;	
		shape = new Ellipse2D.Double(pieza.getX()*CeldaView.CELDA_WIDTH + CeldaView.CELDA_WIDTH*.05, 
				pieza.getY()*CeldaView.CELDA_HEIGHT + CeldaView.CELDA_HEIGHT*.05, 
				CeldaView.CELDA_WIDTH*.9, 
				CeldaView.CELDA_HEIGHT*.9);

		piezaColor = pieza.playerOwner.getPlayerColor();
	}


}
