/**
 * 
 */
package org.poo.geomago.jugabilidad;

import java.awt.Color;
import java.util.ArrayList;

import org.poo.geomago.GameLogic;

/**
 * @author mbenzit
 *
 */
public class Jugador {
	private static int ID = 0;
	
	protected ArrayList<Pieza> mPiezaList;
	protected String mName;
	protected  boolean isPlayerActive;
	protected  int mID;
	protected  GameLogic logic;
	protected Color mColor;
	
	public Jugador(String name, GameLogic logic) {
		this.logic = logic;
		ID++; //TODO: Cada vez que se resetea el juego hay que resetear ID también.
		mID = ID;
		mName = name;
		if (mName.isEmpty()) {
			mName = "Jugador" + mID;
		}
		
		switch(mID) {
		case 1:
			mColor = Color.red;
			break;
		case 2:
			mColor = Color.blue;
			break;
		case 3:
			mColor = Color.yellow;
			break;
		case 4:
			mColor = Color.green;
			break;
		default:
			mColor = Color.gray;
			break;
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
			logic.getGameFrame().refreshPieceRecount(this);
			if (getPiezas().size() == 0) {
				//Game over man, game over
				logic.removePlayerFromGame(this);
			}
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
	
	public Color getPlayerColor() {
		return mColor;
	}

	/**
	 * Called when the board is being removed. (Game ended)
	 */
	public void endGame() {
		ID--; //Resets ID to 0 since this is called the same amount of time ID has incremented
	}

	public String getName() {
		return mName;
	}

	public int getPieceCount() {
		return mPiezaList.size();
	}
	/**
	 * Must be overriden in AI players 
	 * @return Whether the player is human or not
	 */
	public boolean isHuman() {
		return true;
	}

	public GameLogic getGameLogic() {
		return logic;
	}
}
