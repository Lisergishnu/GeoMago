package org.poo.geomago.celda;

import org.poo.geomago.jugabilidad.Pieza;

/**
 * Basic Game Board unit, forms the game grid.
 */

public class Celda {
	private int x;
	private int y;
	private CeldaState mState;
	private CeldaView view;
	private Pieza currentPieza;
	
	/**
	 * Creates a Celda in coordinates x,y with State initialState
	 * @param x coordinate
	 * @param y coordinate
	 * @param initialState initial State
	 * @see CeldaState
	 */
	public Celda(int x, int y, CeldaState initialState) {
		this.x = x;
		this.y = y;
		mState = initialState;
		view = new CeldaView(this);
		setCurrentPieza(null);
	}

	/**
	 * @return coordinate x of this Celda
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets coordinate x of this Celda
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return coordinate y of this Celda
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets coordinate y of this Celda
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * @return currentState of this Celda
	 * @see CeldaState
	 */
	public CeldaState getmState() {
		return mState;
	}

	/**
	 * Sets currentState of this Celda
	 * @see CeldaState
	 */
	public void setmState(CeldaState mState) {
		this.mState = mState;
	}
	
	/**
	 * @return CeldaView of this Celda
	 * @see CeldaView
	 */
	public CeldaView getView() {
		return view;
	}

	/**
	 * Sets CeldaView of this Celda
	 * @see CeldaView
	 */
	public void setView(CeldaView view) {
		this.view = view;
	}

	public Pieza getCurrentPieza() {
		return currentPieza;
	}

	public void setCurrentPieza(Pieza currentPieza) {
		this.currentPieza = currentPieza;
	}

}
