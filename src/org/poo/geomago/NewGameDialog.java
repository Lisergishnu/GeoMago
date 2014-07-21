package org.poo.geomago;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

/**
 * New Game Dialog for starting a new game
 */
public class NewGameDialog extends JDialog {
	private int b;
	private GameFrame gameFrame;
	/**
	 * Creates a New Game modal dialog.
	 * Has a BoxLayout, has Player number input, Board Size input, OK Button and Cancel Button.
	 * @param title JDialog title
	 * @param w JDialog width
	 * @param h JDialog height
	 * @param border Borders for Panels
	 * @see JDialog
	 */
	public NewGameDialog(String title, int w, int h, int border, GameFrame gameFrame) {
		this.gameFrame = gameFrame;
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		b = border;
		add(getTableroSizePanel());
		add(getPlayersPane());
		add(getReturnPanel());
		setTitle(title);
		setSize(w,h);
		setLocationRelativeTo(null);
		setModal(true);
	}
		
	/**
	 * New Board Container BoxLayout
	 * @return JPanel Container
	 * @see BoxLayout
	 */
	private JPanel getPlayersPane() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		return p;
	}

	/**
	 * New Board OK, and CANCEL Buttons
	 * @return JPanel with Buttons
	 * @see JButton
	 */
	private JPanel getReturnPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		p.add(Box.createHorizontalGlue());
		p.add(Box.createHorizontalGlue());
		
		JButton okButton = new JButton("wena");
		JButton cButton = new JButton("Cancel");
		p.add(okButton);
		p.add(cButton);
		
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("clicked ok");
            	gameFrame.newBoard(10, 10, 2);
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

	/**
	 * New Board Size panel selector
	 * @return JPanel with Labels and Spinners
	 * @see SpinnerNumberModel
	 */
	private JPanel getTableroSizePanel() {
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.setBorder(BorderFactory.createTitledBorder("Board Size"));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		
		JLabel l = new JLabel("Width:");
		l.setAlignmentX(Component.RIGHT_ALIGNMENT);
		p.add(l);
		JSpinner s = new JSpinner(new SpinnerNumberModel(20, 15, 30, 1));
		s.setPreferredSize(getMinimumSize());
		p.add(s);
		
		l = new JLabel("Height:");
		l.setAlignmentX(Component.RIGHT_ALIGNMENT);
		p.add(l);
		s = new JSpinner(new SpinnerNumberModel(20, 15, 30, 1));
		p.add(s);
		
		return p;
	}

}