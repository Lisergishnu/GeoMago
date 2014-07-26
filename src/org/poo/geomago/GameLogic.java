package org.poo.geomago;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;

import org.poo.geomago.celda.Celda;
import org.poo.geomago.celda.CeldaState;
import org.poo.geomago.jugabilidad.AIJugador;
import org.poo.geomago.jugabilidad.CirculoPieza;
import org.poo.geomago.jugabilidad.Jugador;
import org.poo.geomago.jugabilidad.Pieza;
import org.poo.geomago.jugabilidad.TrianguloPieza;
import org.poo.geomago.jugabilidad.PentagonoPieza;

/**
 * Game Board, action takes place here.
 */
public class GameLogic implements Runnable{
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
	 * @param pNames	ArrayList with the names of the players. Its size is the numbers of human players
	 */

	public GameLogic(GameFrame gameFrame, int widthCells, int heightCells, int nPlayers, ArrayList<String> pNames) {
		this.gameFrame = gameFrame;
		this.widthCells = widthCells;
		this.heightCells = heightCells;
		this.nPlayers = nPlayers;
		this.isGameRunning = false;
		this.tableroState = new Celda[widthCells][heightCells];

		Random rnd = new Random();

		boolean blocked;
		for (int i = 0; i < widthCells; i++) {
			for (int j = 0; j < heightCells; j++) {
				//TODO: La generacion debe ser inteligente, para que no hayan tantos espacios bloqueados ni
				//		caminos sin salida
				if(rnd.nextDouble()<0.31)
					blocked = false;
				else
					blocked = true;
				this.tableroState[i][j] = new Celda(this, i, j, (blocked) ? CeldaState.NORMAL : CeldaState.DISABLED);
			}			
		}


		//Crear jugadores y sus respectivas piezas
		//Se asume que el numero de nombres en pNames es el numero de jugadores humanos y que siempre <= nPlayers
		//Considerar que cada jugador va a tener unas 10 piezas
		//5 circulos, 3 triangulos, 2 pentagonos
		playersList = new ArrayList<Jugador>();

		for (String string : pNames) {
			Jugador j = new Jugador(string, this);
			preparePlayer(j);
			playersList.add(j);
		}
		while (playersList.size() != nPlayers) {
			//Completar con AI
			Jugador j = new AIJugador(this);
			preparePlayer(j);
			playersList.add(j);
		}
		tableroView = new TableroView(this);

	}

	public void startGameLoop() {
		isGameRunning = true;
		//Traer al primer jugador
		turn = 0;
		currentPlayer = -1;
		gameFrame.setEnabledNextTurnButton(true);
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
			gameFrame.setTurnNumber(turn);
		}
		playerInFocus = playersList.get(currentPlayer);
		gameFrame.setCurrentPlayerName(playerInFocus);
		//renovar movimientos del turno
		for (Pieza pieza : playerInFocus.getPiezas()) {
			pieza.gainMovement();
		}

		playerInFocus.executeTurn();
		//TODO: Hacer que en la GUI se vea cual es el jugador actual
	}

	/**
	 * Does the initialization of pieces on a corner of the map for some player
	 * @param jugadorTest Initialized Jugador
	 */
	private void preparePlayer(Jugador j) {
		int id = j.getID();
		piezasParaJugador = new ArrayList<Pieza>();
		//Agregar los 2 pentagonos
		//Agregar los 3 triangulos
		//Agregar los 4 circulos
		switch (id) {
		case 1:
			piezasParaJugador.add(new PentagonoPieza(j, tableroState[1][0]));
			piezasParaJugador.add(new PentagonoPieza(j, tableroState[0][1]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[2][0]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[1][1]));
			piezasParaJugador.add(new TrianguloPieza(j, tableroState[0][2]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[3][0]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[2][1]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[1][2]));
			piezasParaJugador.add(new CirculoPieza(j, tableroState[0][3]));
			break;
		case 2:
			piezasParaJugador.add(new PentagonoPieza(j, tableroState[widthCells - 2][0]));
			piezasParaJugador.add(new PentagonoPieza(j, tableroState[widthCells - 1][1]));
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
	/**
	 * Called when the current player want to end his turn. Preferably this must be called from another thread.
	 * @see EndTurnAction
	 */
	public void endTurn() {
		playerInFocus.endTurn();
		if (isGameRunning) {
			switchPlayer();
		} else {
			System.out.println("Juego Terminado. Ganador: " + playersList.get(0).getName());
			gameFrame.setEnabledNextTurnButton(false);
			gameFrame.showGameOverDialog(playersList.get(0).getName());
		}
	}

	public void redraw() {
		gameFrame.repaint();	
	}

	@Override
	public void run() {
		startGameLoop();
	}

	public void removePlayerFromGame(Jugador jugador) {
		gameFrame.setPlayerNameAsRemoved(jugador.getID());
		jugador.endGame();
		playersList.remove(jugador);
		nPlayers -= 1;
		if (nPlayers == 1) {
			isGameRunning = false;
		}
	}
}
