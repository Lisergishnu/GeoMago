package org.poo.geomago;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class NewGameDialog extends JDialog {
	
	public NewGameDialog() {
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		getContentPane().add(getTableroSizePanel());
		getContentPane().add(getPlayersPane());
		getContentPane().add(getReturnPanel());
		setTitle("Nuevo Juego");
		setSize(300,200);
		setLocationRelativeTo(null);
	}
		
	private JPanel getPlayersPane() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		return p;
	}

	private JPanel getReturnPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		p.add(Box.createHorizontalGlue());
		p.add(Box.createHorizontalGlue());
		p.add(new JButton("OK"));
		p.add(new JButton("Cancel"));
		return p;
	}

	private JPanel getTableroSizePanel() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2,100,100));
		p.setBorder(BorderFactory.createTitledBorder("Tamaño del Tablero"));
		JLabel l = new JLabel("Horizontal:");
		l.setAlignmentX(Component.RIGHT_ALIGNMENT);
		p.add(l);
		JSpinner s = new JSpinner(new SpinnerNumberModel(20, 15, 30, 1));
		s.setPreferredSize(getMinimumSize());
		p.add(s);
		l = new JLabel("Vertical:");
		l.setAlignmentX(Component.RIGHT_ALIGNMENT);
		p.add(l);
		s = new JSpinner(new SpinnerNumberModel(20, 15, 30, 1));
		p.add(s);
		return p;
	}
}
