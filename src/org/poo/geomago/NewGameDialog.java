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
	private JSpinner s1, s2, s3;
	/**
	 * Creates a NewGameDialog with Title title, width w and height h.
	 * Is BoxLayout, has Player number input, Board Size input, OK Button and Cancel Button.
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
		pack();
		setLocationRelativeTo(null);
	}
		
	/**
	 * New Board Container BoxLayout
	 * @return JPanel Container
	 * @see BoxLayout
	 */
	private JPanel getPlayersPane() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		
		JLabel l = new JLabel("Players:");
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(l);
		s3 = new JSpinner(new SpinnerNumberModel(1, 1, 4, 1));
		s3.setMaximumSize(new Dimension(40, 20));
		s3.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(s3);
		
		return p;
	}
	
	/**
	 * Players Names
	 * @return JPanel Container
	 * @see BoxLayout
	 */
	/*private JPanel getPlayersNames() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		
		JTextField l = new JTextfield("Players:");
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(l);
		s3 = new JSpinner(new SpinnerNumberModel(1, 1, 4, 1));
		s3.setMaximumSize(new Dimension(40, 20));
		s3.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(s3);
		
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
		
		JButton okButton = new JButton("Ok");
		JButton cButton = new JButton("Cancel");
		
		p.add(okButton);
		p.add(cButton);
		
        okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	System.out.println("clicked ok");
            	setVisible(false);
    			NewPlayersDialog n = new NewPlayersDialog("Players Names", (int)s3.getValue(),
    					gameFrame, (int)s1.getValue(), (int)s2.getValue());
    			n.setVisible(true);
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
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBorder(BorderFactory.createTitledBorder("Board Size"));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		
		JLabel l = new JLabel("Width:");
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(l);
		s1 = new JSpinner(new SpinnerNumberModel(20, 15, 30, 1));
		s1.setMaximumSize(new Dimension(40, 20));
		s1.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(s1);
		
		l = new JLabel("Height:");
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(l);
		s2 = new JSpinner(new SpinnerNumberModel(20, 15, 30, 1));
		s2.setMaximumSize(new Dimension(40, 20));
		s2.setAlignmentX(Component.CENTER_ALIGNMENT);
		p.add(s2);
		
		return p;
	}

}