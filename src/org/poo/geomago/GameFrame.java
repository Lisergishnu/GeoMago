package org.poo.geomago;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.*;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

/**
 * Main Frame of the Game 
 */
public class GameFrame extends JFrame {
	private GameLogic gameBoard;
	private TableroView tablero;
	private JPanel northPanel, southPanel, eastPanel, westPanel;
	private JScrollPane centerPanel;
	private int hSeparation, vSeparation;
	private JLabel focusedPiezaMovements;
	
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
		this("Geomago Main Frame", 15, 15, 2);
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
		gameBoard = new GameLogic(this, w,h,p);	
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
		westPanel = new JPanel();
		eastPanel = createGameSidePanel();
		centerPanel = new JScrollPane(tablero);
	}
	
	private JPanel createGameSidePanel() {
		JPanel p = new JPanel(); 
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		JPanel sub = new JPanel();
		sub.setLayout(new GridLayout(2, 2));
		sub.setBorder(BorderFactory.createTitledBorder("Piezas restantes"));
		JLabel l = new JLabel("Jugador 1:");
		sub.add(l);
		l = new JLabel("#");
		sub.add(l);
		l = new JLabel("Jugador 2:");
		sub.add(l);
		l = new JLabel("#");
		sub.add(l);
		p.add(sub);
		p.add(Box.createVerticalGlue());
		sub = new JPanel();
		sub = new JPanel();
		sub.setLayout(new GridLayout(1, 2));
		sub.setBorder(BorderFactory.createTitledBorder("Pieza actual"));
		sub.add(new JLabel("Movimientos "));
		focusedPiezaMovements = new JLabel("- / -");
		sub.add(focusedPiezaMovements);
		p.add(sub);
		p.add(Box.createVerticalGlue());
		JButton bb = new JButton("Terminar Turno");
		bb.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(bb);
		return p;
	}

	public void setPiezaMovements(int current, int max) {
		if (current == max && current == 0)
			focusedPiezaMovements.setText("- / -");
		else
			focusedPiezaMovements.setText(current + " / " + max);
	}
	
	/**
	 * Create a new gameBoard
	 * @param w
	 * @param h
	 * @param p
	 */
	public void newBoard(int w, int h, int p){
		initGameBoard(w, h, p);
		centerPanel.setViewportView(tablero); //at this point, tablero has changed
		centerPanel.revalidate();
		repaint();
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
