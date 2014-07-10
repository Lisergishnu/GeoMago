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

	/**
	 * Creates a Board with horizontal cells, vertical cells, players number.
	 * Inits the turn counter and player turn.
	 * Creates a board with number of cells according to parameters and sets them on/off
	 * randomly.
	 * @param widthCells 	number of horizontal cells
	 * @param heightCells	number of vertical cells
	 * @param nPlayers		number of players
	 */
	public GameLogic(int widthCells, int heightCells, int nPlayers, String[] pNames) {
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
		
		if(pNames == null){
			String[] defPlayer = new String[3];
			defPlayer[0] = "Player1";
			defPlayer[1] = "Player2";
			defPlayer[2] = "Player3";
			newPlayers(defPlayer);
		}
		else{
			//System.out.println(pNames.length);
			//newPlayers(pNames);
			String[] defPlayer = new String[3];
			defPlayer[0] = "Player1";
			defPlayer[1] = "Player2";
			defPlayer[2] = "Player3";
			newPlayers(defPlayer);
		}
	}

	/**
	 * Crea a todos los jugadores y sus respectivas piezas
	 * @param names lista de nombres
	 */
	private void newPlayers(String names[]){
		playersList = new ArrayList<Jugador>();
		for(int i = 0; i < names.length; i++){
			
			Jugador jugadorTest = new Jugador(names[i],this);
			piezasParaJugador = new ArrayList<Pieza>();
			System.out.println("New player: " + names[i]);
			CirculoPieza circ = new CirculoPieza(jugadorTest, tableroState[i][0]);
			TrianguloPieza triang = new TrianguloPieza(jugadorTest, tableroState[i][1]);
			piezasParaJugador.add(circ);
			piezasParaJugador.add(triang);
			jugadorTest.setPiezas(piezasParaJugador);

			playersList.add(jugadorTest);
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

	public ArrayList<Jugador> getPlayersList() {
		return playersList;
	}

	public void setPlayersList(ArrayList<Jugador> playersList) {
		this.playersList = playersList;
	}
	
	
}
