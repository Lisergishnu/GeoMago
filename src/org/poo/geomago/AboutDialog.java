package org.poo.geomago;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * About Dialog for further information about the game
 */
public class AboutDialog extends JDialog{
	private GameFrame gameFrame;
	private int b;
	
	/**
	 * Creates a about dialog.
	 * Has a BoxLayout, has Player number input, Board Size input, OK Button and Cancel Button.
	 * @param title JDialog title
	 * @param w JDialog width
	 * @param h JDialog height
	 * @param border Borders for Panels
	 * @see JDialog
	 */
	public AboutDialog(String title, int w, int h, int border, GameFrame gameFrame) {
		super(gameFrame);
		this.gameFrame = gameFrame;
		setTitle(title);
		setSize(w,h);
		setLocationRelativeTo(gameFrame);
		setModal(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		b = border;
		add(getAboutPanel());
		add(getReturnPanel());
		setResizable(false);
	}
	
	/**
	 * New Board with About Dialog
	 * @return JPanel with a text
	 * @see JButton
	 */
	private JPanel getAboutPanel() {
		JPanel a = new JPanel();
		
		setSize(350,400);
		
		a.setLayout(new BoxLayout(a,BoxLayout.X_AXIS));
		a.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		{
			// aquí se pone el JTextArea dentro de un JScrollPane
			// para que tenga barras de desplazamiento
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 424, 146);
			a.add(scrollPane);
			{
				JTextArea about = new JTextArea();
				about.setText("Este juego fue creado bajo los estandares GNU y por lo tanto de código abierto."
						+ "\n\n Creadores: \n\tAndres Ulloa \n\tMarco Benzi \n\tRene Pozo");
				about.setLineWrap(true);
				about.setAutoscrolls(true);
				scrollPane.setViewportView(about);
			}
		}
		return a;
	}
	
	/**
	 * New Board with OK button
	 * @return JPanel with button
	 * @see JButton
	 */
	private JPanel getReturnPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		p.add(Box.createHorizontalGlue());
		p.add(Box.createHorizontalGlue());
		
		JButton okButton = new JButton("OK");
		p.add(okButton);
		okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
               	setVisible(false);
            }
        });
		return p;
	}
}
