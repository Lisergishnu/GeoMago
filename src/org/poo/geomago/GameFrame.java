package org.poo.geomago;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.*;

import org.poo.geomago.jugabilidad.Jugador;

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
	private JPanel currentPiezaPanel;
	private JButton endTurnButton;
	private JPanel remainingPiezasPanel;
	private Hashtable<Integer,JLabel> playersPieceList;
	
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
		createGUIPanels();
		initWindow();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(true);
		//initGameBoard(w, h, p);
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
		if (gameBoard != null) {
			gameBoard.cleanUp();
		}
		gameBoard = new GameLogic(this, w,h,p);	
		tablero = gameBoard.getTableroView();
		remainingPiezasPanel.setEnabled(true);
		currentPiezaPanel.setEnabled(true);
		focusedPiezaMovements.setEnabled(true);
		remainingPiezasPanel.removeAll();
		//Add players captions
		ArrayList<Jugador> pL = gameBoard.getPlayersList();
		playersPieceList = new Hashtable<Integer,JLabel>();
		for (Jugador jugador : pL) {
			remainingPiezasPanel.add(new JLabel(jugador.getName()));
			JLabel l = new JLabel(Integer.toString(jugador.getPieceCount()));
			playersPieceList.put(jugador.getID(), l);
			remainingPiezasPanel.add(l);
		}
	}
	
	/**
	 * Updates the text label with the count of remaining pieces in the board for the player specified.
	 * @param playerIndex ID of player whose label will be refreshed
	 */
	public void refreshPieceRecount(int playerIndex) {
		ArrayList<Jugador> pL = gameBoard.getPlayersList();
		playersPieceList.get(playerIndex).setText(Integer.toString(pL.get(playerIndex-1).getPieceCount()));
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
	
		GameFrameMenuListener gListener = new GameFrameMenuListener(this);
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
		eastPanel.setPreferredSize(new Dimension(200,0));
		centerPanel = new JScrollPane(tablero);
		centerPanel.setPreferredSize(new Dimension(800,600));
	}
	
	private JPanel createGameSidePanel() {
		JPanel p = new JPanel(); 
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		remainingPiezasPanel = new JPanel();
		remainingPiezasPanel.setLayout(new GridLayout(2, 2));
		remainingPiezasPanel.setBorder(BorderFactory.createTitledBorder("Piezas restantes"));
		remainingPiezasPanel.setEnabled(false);
		p.add(remainingPiezasPanel);
		p.add(Box.createVerticalGlue());
		currentPiezaPanel = new JPanel();
		currentPiezaPanel.setLayout(new GridLayout(1, 2));
		currentPiezaPanel.setBorder(BorderFactory.createTitledBorder("Pieza actual"));
		currentPiezaPanel.setEnabled(false);
		currentPiezaPanel.add(new JLabel("Movimientos "));
		focusedPiezaMovements = new JLabel("- / -");
		focusedPiezaMovements.setEnabled(false);
		currentPiezaPanel.add(focusedPiezaMovements);
		p.add(currentPiezaPanel);
		p.add(Box.createVerticalGlue());
		endTurnButton = new JButton("Terminar Turno");
		endTurnButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				gameBoard.switchPlayer();
			}
		});
		endTurnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		endTurnButton.setEnabled(false);
		p.add(endTurnButton);
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
		
		menu = new JMenu ("Help");
		menuItem = new JMenuItem("About...");
		menuItem.addActionListener(gListener);
		menu.add(menuItem);
		menuBar.add(menu);
		
		return menuBar;
	}

	public GameLogic getCurrentGame() {
		return gameBoard;
	}

	public void setEnabledNextTurnButton(boolean enabled) {
		endTurnButton.setEnabled(enabled);
	}
}
