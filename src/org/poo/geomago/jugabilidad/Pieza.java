package org.poo.geomago.jugabilidad;

import java.awt.Graphics2D;

import org.poo.geomago.celda.Celda;

public abstract class Pieza {
	protected Jugador playerOwner; //ID
	protected int nMovimientos; 
	protected final int nMaxMovimientos;
	protected Celda actualPos;
	
	public Pieza(Jugador jugador, Celda initialPos, int maxMovimientos) {
		actualPos = initialPos;
		nMaxMovimientos = maxMovimientos;
		nMovimientos = nMaxMovimientos;
		playerOwner = jugador;
	}
	
	public boolean move(Celda destino) {
		//TODO: Calcular si la jugada es viable
		//TODO: Si es valida, liberar actual, y setear celda nueva
		//TODO: Si se movio bien, reducir en uno el movimiento
		return true;
	}
	
	public void remove() {
		actualPos.setCurrentPieza(null);
		System.out.println("Pieza.remove()");
	}
	
	public void gainMovement() {
		nMovimientos = (nMovimientos < nMaxMovimientos) ? nMovimientos + 1 : nMaxMovimientos;
	}
	
	public int getX() {
		return actualPos.getX();
	}
	
	public int getY() {
		return actualPos.getY();
	}
	
	public abstract void draw(Graphics2D g);
}
