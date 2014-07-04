package org.poo.geomago;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.*;

/**
 * Main Frame of the Game 
 */
public class GameFrame extends JFrame {
	private GameBoard gameBoard;
	private TableroView tablero;
	private JPanel northPanel, southPanel, eastPanel, westPanel;
	private JScrollPane centerPanel;
	private int hSeparation, vSeparation;
	
	{
		hSeparation = 2;
		vSeparation = hSeparation;
	}
	
	/**
	 * Main GameFrame
	 * @param title frame title
	 * @param w	board width
	 * @param h board height
	 * @param p number of players
	 */
	public GameFrame(String title, int w, int h, int p){
		super(title);
		initGameBoard(w, h, p);
		createGUIPanels();
		initWindow();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
	}
	
	/**
	 * Default Constructor
	 */
	public GameFrame() {
		this("Geomago Main Frame", 30, 30, 2);
	}

	/**
	 * Instantiates the gameBoard with
	 * @param w width
	 * @param h height
	 * @param p player number
	 * 
	 * Assigns the tableroView to the gameBoardView and sets its layout
	 * to GridLayout
	 */
	private void initGameBoard(int w, int h, int p) {
		gameBoard = new GameBoard(w,h,p);	
		tablero = gameBoard.getTableroView();
	}

	/**
	 * Inits GameFrame With BorderLayout as Layout, and assigns the JPanels
	 */
	private void initWindow() {
		this.setLayout(new BorderLayout());
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(eastPanel, BorderLayout.EAST);
		this.add(westPanel, BorderLayout.WEST);
	
		GameFrameMenuListener gListener = new GameFrameMenuListener(gameBoard, this);
		setJMenuBar(createGameFrameMenuBar(gListener));
	}
	
	
	/**
	 * Creates guiPanels with 4 JPanels (northPanel, southPanel, eastPanel, westPanel),
	 * but does not assign them.
	 */
	private void createGUIPanels(){
		northPanel = new JPanel();
		southPanel = new JPanel();
		eastPanel = new JPanel();
		westPanel = new JPanel();
		centerPanel = new JScrollPane(tablero);
	}
	
	/**
	 * Create a new gameBoard
	 * @param w
	 * @param h
	 * @param p
	 */
	public void newBoard(int w, int h, int p){
		initGameBoard(w, h, p);
	}
	
	/**
	 * Creates menu bar for main game Frame
	 * @param gListener
	 * @return JMenuBar
	 */
	private JMenuBar createGameFrameMenuBar(GameFrameMenuListener gListener) {
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
