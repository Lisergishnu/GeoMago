package org.poo.geomago;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * Ventana principal del juego
 * @author Yuyin
 */
public class GameFrame extends JFrame {

	private TableroView tablero;
	private GameBoard gameBoard;
	private int hSeparation;
	private int vSeparation;
	
	{
		hSeparation = 2;
		vSeparation = hSeparation;
	}
	
	/**
	 * Constructores
	 */
	public GameFrame() {
		this("Geomago Main Frame");
	}
	
	public GameFrame(String title){
		super(title);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGameBoard();
		initWindow();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * Inits Game Board
	 */
	private void initGameBoard() {
		gameBoard = new GameBoard(30,30,2);		
	}

	/**
	 * Inits Panel and adds the gameBoard View to it.
	 */
	private void initWindow() {
		tablero = gameBoard.getTableroView();
		setLayout(new GridLayout(gameBoard.getWidthCells(), gameBoard.getHeightCells(), hSeparation, vSeparation));
		getContentPane().add(tablero);
	
		GameFrameMenuListener gListener = new GameFrameMenuListener(gameBoard);
		setJMenuBar(createGameFrameMenuBar(gListener));
	}
	
	/**
	 * Menu bar
	 * @param gListener
	 * @return JMenuBar
	 */
	private JMenuBar createGameFrameMenuBar(GameFrameMenuListener gListener) {
		//Create Menu
		JMenuBar menuBar = new JMenuBar();
	
		JMenu menu = new JMenu ("Game");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("New Game...");
		menuItem.addActionListener(gListener);
		menu.add(menuItem);
	
		menuItem = new JMenuItem("Quit GeoMago");
		menuItem.addActionListener(gListener);
		menu.add(menuItem);
		
		return menuBar;
	}
}
