package org.poo.geomago;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

//Esta es la ventana principal del juego
public class GameFrame extends JFrame {
	
	private TableroView tablero;

	public GameFrame() {
		super("GeoMago");
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		init();
		setVisible(true);
	}

	private void init() {
		tablero = new TableroView();
		setLayout(new GridLayout());
		getContentPane().add(tablero);		
	}
}
