/**
 * 
 */
package org.poo.geomago.jugabilidad;

import java.util.ArrayList;

import org.poo.geomago.GameLogic;
import org.poo.geomago.celda.Celda;

/**
 * Extends Jugador making a simple cognitivist AI.
 * @author mbenzit
 *
 */
public class AIJugador extends Jugador {

	private int mDifficulty;
	private void processTurn() {
		System.out.println("Procesando turno AI...");
		for (Pieza p : mPiezaList) {
			//Check if the last movement didnt end the game
			if (!logic.isGameRunning()) {
				return;
			}
			//Check its posibilities 
			int x = p.getX();
			int y = p.getY();
			//Concentrate the focus only on the availible range for the piece
			ArrayList<Celda> l = new ArrayList<Celda>();
			Celda[][] tab = logic.getTableroState();
			for (int i = (x-p.getMovements()+1 < 0) ? 0 : x-p.getMovements()+1;
				i < ((x+p.getMovements()+1 < logic.getWidthCells()) ? x+p.getMovements()+1 : logic.getWidthCells());
				i++) {
					for (int j = (y-p.getMovements() < 0) ? 0 : y-p.getMovements();
						j < ((y+p.getMovements()+1 < logic.getHeightCells()) ? y+p.getMovements()+1 : logic.getHeightCells());
						j++) {
							if (p.canMove(tab[i][j])) {
								l.add(tab[i][j]);
							}
					}
			}
			/*
			 * Choose the better one.
			 * Current Priority:
			 * 1.- Capture a piece whichever it is
			 * 2.- Move close to the center 
			 * 
			 * Also changes the target of movement depending on the turn to avoid deadlocks
			 */
			Celda target = null;
			int turn = logic.getTurn();
			int cX = logic.getWidthCells()/2;
			int cY = logic.getHeightCells()/2;
			switch (turn % 3) {
			case 0:
				cX = logic.getWidthCells()/2;
				cY = logic.getHeightCells()/2;				
				break;
			case 1:
				cX = 0;
				cY = 0;
				break;
			case 2:
				cX = logic.getWidthCells()-1;
				cY = 0;
				break;
			default:
				break;
			}
			Celda center = tab[cX][cY];
			for (Celda c : l) {
				Pieza pT = c.getCurrentPieza();
				if (target == null && c.isWalkable()) {
					target = c;
				}
				if (pT != null && pT.playerOwner != this) {
					//CAPTURE!
					target = c;
					break;
				}
				if (c.getDistance(center) < target.getDistance(center)) {
					target = c;
				}
			}
			if (target != null) {
				p.move(target);
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			logic.redraw();
		}
	}

	public AIJugador(GameLogic logic) {
		super("AI Player ", logic);
		mName += Integer.toString(mID);
		//Dificulty expresses as the number of iterations per piece.
		mDifficulty = 2;
	}
	
	@Override
	public void executeTurn() {
		logic.getGameFrame().getNextTurnButton().setEnabled(false);
		processTurn();
		//Emulate the end of Turn
		logic.getGameFrame().getNextTurnButton().setEnabled(true);
		logic.getGameFrame().getNextTurnButton().doClick();
	}
	
	@Override
	public boolean isHuman() {
		return false;
	}
	
}
