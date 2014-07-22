package org.poo.geomago;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import org.poo.geomago.celda.Celda;
import org.poo.geomago.celda.CeldaState;
import org.poo.geomago.jugabilidad.CirculoPieza;
import org.poo.geomago.jugabilidad.Jugador;
import org.poo.geomago.jugabilidad.Pieza;
import org.poo.geomago.jugabilidad.TrianguloPieza;

/**
 * Game Board, action takes place here.
 */
public class GameLogic {
	private int widthCells;
	private int heightCells;
	private int nPlayers;
	private int turn;
	private int currentPlayer;
	private Celda[][] tableroState;
	private TableroView tableroView;
	private ArrayList<Pieza> piezasParaJugador;
	private ArrayList<Jugador> playersList;
	private Pieza focusedPieza;
	private GameFrame gameFrame;
	private Pieza currentPiezaDragged;
	private boolean isGameRunning;
	private Jugador playerInFocus;

	/**
	 * Creates a Board with horizontal cells, vertical cells, players number.
	 * Inits the turn counter and player turn.
	 * Creates a board with number of cells according to parameters and sets them on/off
	 * randomly.
	 * @param gameFrame  Initialized game frame. 
	 * @param widthCells 	number of horizontal cells
	 * @param heightCells	number of vertical cells
	 * @param nPlayers		number of players
	 */
	public GameLogic(GameFrame gameFrame, int widthCells, int heightCells, int nPlayers) {
		this.gameFrame = gameFrame;
		this.widthCells = widthCells;
		this.heightCells = heightCells;
		this.nPlayers = nPlayers;
		this.isGameRunning = false;
		this.tableroState = new Celda[widthCells][heightCells];
		
		Random rnd = new Random();
		
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				//TODO: La generacion debe ser inteligente, para que no hayan tantos espacios bloqueados ni
				//		caminos sin salida
				this.tableroState[i][j] = new Celda(this, i, j, (rnd.nextBoolean()) ? CeldaState.NORMAL : CeldaState.DISABLED);
			}			
		}
		
		//TODO: Crear jugadores y sus respectivas piezas
		//Considerar que cada jugador va a tener unas 10 piezas
		//5 circulos, 3 triangulos, 2 pentagonos
		
		Jugador jugadorTest = new Jugador("Test",this);
		Jugador jugadorTest2 = new Jugador("Test2",this);
		preparePlayer(jugadorTest);		
		preparePlayer(jugadorTest2);
		
		playersList = new ArrayList<Jugador>();
		playersList.add(jugadorTest);
		playersList.add(jugadorTest2);
		
		tableroView = new TableroView(this);
		
		startGameLoop();
	}
	
	private void startGameLoop() {
		isGameRunning = true;
		//Traer al primer jugador
		turn = 0;
		currentPlayer = -1;
		switchPlayer();
	}
	/**
	 * Computes whos the next player and gives focus to him/her. Also computes increments the current
	 * turn counter if necesary and enables GUI elements if the player is human.
	 */
	public void switchPlayer() {
		currentPlayer = (currentPlayer < nPlayers - 1) ? currentPlayer + 1 : 0;
		if (currentPlayer == 0) {
			turn += 1;
		}
		playerInFocus = playersList.get(currentPlayer);
		if (playerInFocus.isHuman()) {
			gameFrame.setEnabledNextTurnButton(true);
		} else {
			gameFrame.setEnabledNextTurnButton(false);
		}
		//renovar movimientos del turno
		for (Pieza pieza : playerInFocus.getPiezas()) {
			pieza.gainMovement();
		}
		//TODO: Hacer que en la GUI se vea cual es el jugador actual
	}

	/**
	 * Does the initialization of pieces on a corner of the map for some player
	 * @param jugadorTest Initialized Jugador
	 */
	private void preparePlayer(Jugador j) {
		int id = j.getID();
		piezasParaJugador = new ArrayList<Pieza>();
		//TODO: Agregar los 2 pentagonos
		//Agregar los 3 triangulos
		//Agregar los 4 circulos
		switch (id) {
		case 1:
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[2][0]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[1][1]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[0][2]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[3][0]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[2][1]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[1][2]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[0][3]));
			break;
		case 2:
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[widthCells - 3][0]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[widthCells - 2][1]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[widthCells - 1][2]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[widthCells - 4][0]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[widthCells - 3][1]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[widthCells - 2][2]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[widthCells - 1][3]));
			break;
		//TODO: Agregar los otros dos jugadores
		default:
			break;
		}
		//Por consitencia hacer que todas las celdas de las piezas sean disponibles
		for (Pieza pieza : piezasParaJugador) {
			pieza.getParentCell().setState(CeldaState.NORMAL);
		}
		j.setPiezas(piezasParaJugador);		
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

	public ArrayList<Jugador> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(ArrayList<Jugador> playersList) {
		this.playersList = playersList;
	}

	public void focusPieza(Pieza currentPieza) {
		focusedPieza = currentPieza; 
		updatePiezaGUI();
	
	}

	/*
	 * Updates the GUI caption
	 */
	public void updatePiezaGUI() {
		if (focusedPieza != null)
			gameFrame.setPiezaMovements(focusedPieza.getMovements(), focusedPieza.getMaxMovments());
		else
			gameFrame.setPiezaMovements(0,0);
	}

	/**
	 * Called when a mouse drag initiates
	 * @param movX Cell X position where drag started
	 * @param movY Cell Y position where drag started
	 * @param xOnScreen Tablero X position where drag started
	 * @param yOnScreen Tablero Y position where drag started
	 */
	public void mouseDrag(int movX, int movY, int xOnScreen, int yOnScreen) {
		if (currentPiezaDragged == null) {
			if (tableroState[movX][movY].getCurrentPieza() != null) 
				if (tableroState[movX][movY].getCurrentPieza().getPlayerOwner() == playerInFocus)
					currentPiezaDragged = tableroState[movX][movY].getCurrentPieza();
		} else {
			currentPiezaDragged.mouseDrag(xOnScreen, yOnScreen);
		}
	}
	/**
	 * Called when mouse releases.
	 * @param movX Cell X position where drag started
	 * @param movY Cell Y position where drag started
	 */
	public void mouseRelease(int movX, int movY) {
		if (currentPiezaDragged != null) {
			currentPiezaDragged.mouseRelease(tableroState[movX][movY]);
			currentPiezaDragged = null;
		}
	}
	/**
	 * Cleans up the current board. Must be called when switching boards.
	 */
	public void cleanUp() {
		for (Jugador j : playersList) {
			j.endGame();
		}
	}
	/**
	 * @return Whether there is a currently game running or not
	 */
	public boolean isGameRunning() {
		return isGameRunning;
	}
	
	public GameFrame getGameFrame() {
		return gameFrame;
	}
}
