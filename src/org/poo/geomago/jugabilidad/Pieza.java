package org.poo.geomago.jugabilidad;

import java.awt.Graphics2D;
import org.poo.geomago.celda.Celda;

public abstract class Pieza {
	protected Jugador playerOwner;
	protected int nMovimientos;
	protected final int nMaxMovimientos;
	protected Celda actualPos;
	protected int x, y;
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
		if (!canMove(destino)) {
			x = actualPos.getX();
			y = actualPos.getY();
			return false;
		}
		// Si es valida, liberar actual, y setear celda nueva. Ademas eliminar
		// piezas
		// del enemigo que pueden estar en el lugar y reducir numero de
		// movimientos
		actualPos.setCurrentPieza(null);
		if (destino.getCurrentPieza() != null) {
			destino.getCurrentPieza().getPlayerOwner()
					.removePieza(destino.getCurrentPieza());
		}

		int dx = Math.abs(destino.getX() - actualPos.getX());
		int dy = Math.abs(destino.getY() - actualPos.getY());
		int dist = (int) Math
				.floor(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
		actualPos = destino;
		actualPos.setCurrentPieza(this);
		x = actualPos.getX();
		y = actualPos.getY();
		nMovimientos = nMovimientos - dist; // no deberia pasarse a negativo
		return true;
	}
	/**
	 * Calculates if the piece can move to a targeted cell.
	 * @param destino Celda where you want to move the piece to
	 * @return true if the piece is able to move
	 */
	public final boolean canMove(Celda destino) {
		// Calcular si la jugada es viable
		if (!destino.isWalkable()
				|| (destino.getCurrentPieza() != null && destino
						.getCurrentPieza().getPlayerOwner() == playerOwner)) {
			return false;
		}
		// Si se puede mover, probar si el numero de movimientos alcanza
		// Un paso en diagonal descuenta solo un movimiento (no dos)
		int dx = Math.abs(destino.getX() - actualPos.getX());
		int dy = Math.abs(destino.getY() - actualPos.getY());
		int dist = (int) Math
				.floor(Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
		if (dist > nMovimientos) {
			return false;
		}
		return true;
	}

	public void remove() {
		actualPos.setCurrentPieza(null);
		System.out.println("Pieza.remove()");
	}

	public void gainMovement() {
		nMovimientos = (nMovimientos < nMaxMovimientos) ? nMovimientos + 1
				: nMaxMovimientos;
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
	 * 
	 * @param x
	 *            X in tablero coordinates
	 * @param y
	 *            Y in tablero coordinates
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
	 * 
	 * @param destino
	 *            Cell where the mouse was released
	 */
	public void mouseRelease(Celda destino) {
		if (move(destino)) {
			System.out.println("Se puede mover");
		} else {
			System.out.println("No se puede mover");
		}
		isBeingDragged = false;
	}

	public Jugador getPlayerOwner() {
		return playerOwner;
	}

	public Celda getParentCell() {
		return actualPos;
	}

}
