package org.poo.geomago;

import java.util.ArrayList;
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
		
		this.turn = 1;
		this.currentPlayer = 1;
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
	}
	/**
	 * Does the initialization of pieces on a corner of the map for some player
	 * @param jugadorTest
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
	private void updatePiezaGUI() {
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
	
	
}
