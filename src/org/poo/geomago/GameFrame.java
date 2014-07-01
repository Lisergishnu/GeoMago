package org.poo.geomago;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//Esta es la ventana principal del juego
public class GameFrame extends JFrame {

	private TableroView tablero;
	private GameModel gameModel;
	
	public GameFrame() {
		super("GeoMago");
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGameModel();
		initWindow();
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	private void initGameModel() {
		gameModel = new GameModel(30,30,2);		
	}

	private void initWindow() {
		tablero = new TableroView(gameModel);
		setLayout(new GridLayout());
		getContentPane().add(tablero);
	
		GameFrameMenuListener gListener = new GameFrameMenuListener(gameModel);
		setJMenuBar(createGameFrameMenuBar(gListener));
	}
	
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
