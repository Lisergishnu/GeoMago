package org.poo.geomago;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

/**
 * New Game Dialog for starting a new game
 */
public class NewPlayersDialog extends JDialog {
	private int b, gw, gh;
	private GameFrame gameFrame;
	private JTextField[] playersNames;
	private ArrayList<String> pNames;

	/**
	 * Creates a NewGameDialog with Title title, width w and height h.
	 * Is BoxLayout, has Player number input, Board Size input, OK Button and Cancel Button.
	 * @param title JDialog title
	 * @param n Player number
	 * @param w JDialog width
	 * @param h JDialog height
	 * @param border Borders for Panels
	 * @see JDialog
	 */
	public NewPlayersDialog(String title, int n, GameFrame gameFrame) {
		super(gameFrame);
		this.gameFrame = gameFrame;
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		b = 10;
		playersNames = new JTextField[n];
		pNames = new ArrayList<String>();
		add(getNamesPanel());
		add(getReturnPanel());
		setModal(true);
		setTitle(title);
		setSize(160, 40*n);
		pack();
	}

	/**
	 * New Board Container BoxLayout
	 * @return JPanel Container
	 * @see BoxLayout
	 */
	private JPanel getNamesPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));

		for(int i = 0; i < playersNames.length; i++){
			playersNames[i] = new JTextField("Player" + (i+1));
			p.add(new JLabel("Player " + (i+1) + " Name:"));
			p.add(playersNames[i]);
			System.out.println("Player " + (i + 1));
		}

		return p;
	}

	private JPanel getReturnPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		p.add(Box.createHorizontalGlue());
		p.add(Box.createHorizontalGlue());

		JButton okButton = new JButton("Ok");
		JButton cButton = new JButton("Cancel");

		p.add(okButton);
		p.add(cButton);

		okButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for(int i = 0; i < playersNames.length; i++){
					pNames.add(playersNames[i].getText());
				}
				setVisible(false);
			}
		});
		cButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("clicked cancel");
				setVisible(false);
			}
		});
		return p;
	}

	public ArrayList<String> getPlayerNames() {
		return pNames;
	}
}