package org.poo.geomago;

import java.util.Random;

import org.poo.geomago.celda.Celda;
import org.poo.geomago.celda.CeldaState;

/**
 * Game Board, action takes place here.
 */
public class GameBoard {
	private int widthCells;
	private int heightCells;
	private int nPlayers;
	private int turn;
	private int currentPlayer;
	private Celda[][] tableroState;
	private TableroView tableroView;

	/**
	 * Creates a Board with horizontal cells, vertical cells, players number.
	 * Inits the turn counter and player turn.
	 * Creates a board with number of cells according to parameters and sets them on/off
	 * randomly.
	 * @param widthCells 	number of horizontal cells
	 * @param heightCells	number of vertical cells
	 * @param nPlayers		number of players
	 */
	public GameBoard(int widthCells, int heightCells, int nPlayers) {
		this.widthCells = widthCells;
		this.heightCells = heightCells;
		this.nPlayers = nPlayers;
		
		this.turn = 1;
		this.currentPlayer = 1;
		this.tableroState = new Celda[widthCells][heightCells];
		
		Random rnd = new Random();
		
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				this.tableroState[i][j] = new Celda(i, j, (rnd.nextBoolean()) ? CeldaState.NORMAL : CeldaState.DISABLED);
			}			
		}
		
		tableroView = new TableroView(this);
	}

	/**
	 * 
	 * @return number of horizontal cells
	 */
	public int getWidthCells() {
		return widthCells;
	}

	/**
	 * 
	 * @return number of vertical cells
	 */
	public int getHeightCells() {
		return heightCells;
	}

	/**
	 * 
	 * @return number of players
	 */
	public int getnPlayers() {
		return nPlayers;
	}

	/**
	 * 
	 * @return current turn
	 */
	public int getTurn() {
		return turn;
	}

	/**
	 * 
	 * @return current player turn
	 */
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	/**
	 * Get tablero view instance
	 * @return tableroView
	 */
	public TableroView getTableroView() {
		return tableroView;
	}
	
	/**
	 * @see Celda
	 * @return Celda[][] Status of each board cells
	 */
	public Celda[][] getTableroState() {
		return tableroState;
	}
	
	
}