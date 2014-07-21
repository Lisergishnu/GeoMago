package org.poo.geomago.jugabilidad;

import java.awt.Graphics2D;

import org.poo.geomago.celda.Celda;
import org.poo.geomago.celda.CeldaView;

public abstract class Pieza {
	protected Jugador playerOwner;
	protected int nMovimientos; 
	protected final int nMaxMovimientos;
	protected Celda actualPos;
	protected int x,y;
	protected boolean isBeingDragged;
	
	public Pieza(Jugador jugador, Celda initialPos, int maxMovimientos) {
		actualPos = initialPos;
		nMaxMovimientos = maxMovimientos;
		nMovimientos = nMaxMovimientos;
		playerOwner = jugador;
		x = actualPos.getX();
		y = actualPos.getY();
		actualPos.setCurrentPieza(this);
	}
	
	public boolean move(Celda destino) {
		//TODO: Calcular si la jugada es viable
		if(!destino.isWalkable()) {
			x = actualPos.getX();
			y = actualPos.getY();
			return false;
		}
		//TODO: Si es valida, liberar actual, y setear celda nueva
		actualPos.setCurrentPieza(null);
		actualPos = destino;
		actualPos.setCurrentPieza(this);
		x = actualPos.getX();
		y = actualPos.getY();
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
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getMovements() {
		return nMovimientos;
	}
	
	public int getMaxMovments() {
		return nMaxMovimientos;
	}
	
	public abstract void draw(Graphics2D g);

	/**
	 * The mouse is currently dragging this pieza.
	 * @param x X in tablero coordinates
	 * @param y Y in tablero coordinates
	 */
	public void mouseDrag(int x, int y) {
		if (!isBeingDragged) {
			isBeingDragged = true;
		}
		this.x = x;
		this.y = y;
	}

	/**
	 * The mouse has released this pieza
	 * @param destino Cell where the mouse was released
	 */
	public void mouseRelease(Celda destino) {
		if(move(destino)) {
			System.out.println("Se puede mover");
		} else {
			System.out.println("No se puede mover");
		}
		isBeingDragged = false;
	}	
}
