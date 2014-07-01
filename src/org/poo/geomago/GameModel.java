package org.poo.geomago;

import java.util.Random;

import org.poo.geomago.celda.Celda;
import org.poo.geomago.celda.CeldaState;

public class GameModel {
	private int widthCells;
	private int heightCells;
	private int nPlayers;
	private int turn;
	private int currentPlayer;
	private Celda[][] tableroState;
	private TableroView tableroView;

	public GameModel(int widthCells, int heightCells, int nPlayers) {
		this.widthCells = widthCells;
		this.heightCells = heightCells;
		this.nPlayers = nPlayers;
		
		this.turn = 1;
		this.currentPlayer = 1;
		this.tableroState = new Celda[widthCells][heightCells];
		
		Random rnd = new Random();
		for (int i = 0; i < tableroState.length; i++) {
			Celda[] celdas = tableroState[i];
			for (int j = 0; j < celdas.length; j++) {
				celdas[j] = new Celda(i, j, (rnd.nextBoolean()) ? CeldaState.NORMAL : CeldaState.DISABLED);
			}			
		}
		
		tableroView = new TableroView(this);
	}

	public int getWidthCells() {
		return widthCells;
	}

	public int getHeightCells() {
		return heightCells;
	}

	public int getnPlayers() {
		return nPlayers;
	}

	public int getTurn() {
		return turn;
	}

	public int getCurrentPlayer() {
		return currentPlayer;
	}

	public Celda[][] getTableroState() {
		return tableroState;
	}
	
	
}
