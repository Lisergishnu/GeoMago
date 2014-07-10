/**
 * 
 */
package org.poo.geomago.jugabilidad;

import java.util.ArrayList;

import org.poo.geomago.GameLogic;

/**
 * @author mbenzit
 *
 */
public class Jugador {
	private static int ID = 0;
	
	private ArrayList<Pieza> mPiezaList;
	private String mName;
	private boolean isPlayerActive;
	private int mID;
	private GameLogic logic;
	
	
	public Jugador(String name, GameLogic logic) {
		this.logic = logic;
		ID++;
		mID = ID;
		mName = name;
		if (mName.isEmpty()) {
			mName = "Jugador" + mID;
		}
	}
	
	public void executeTurn() {
		isPlayerActive = true;
		//TODO: Si quedan piezas, permitir moverlas
	}
	
	public void endTurn() {
		isPlayerActive = false;
		//logic.notifyEndTurn();
		}
	
	public void removePieza(Pieza p) {
		if (p != null && getPiezas().contains(p)) {
			p.remove();
			getPiezas().remove(p);
		} else {
			System.err.println("Tried to remove piece not from the player");
		}		
	}

	public int getID() {
		return mID;
	}

	public ArrayList<Pieza> getPiezas() {
		return mPiezaList;
	}

	public void setPiezas(ArrayList<Pieza> mPiezaList) {
		this.mPiezaList = mPiezaList;
	}
}
