package org.poo.geomago;

import java.awt.event.*;

import javax.swing.*;

/**
 * About Dialog for further information about the game
 */
public class AboutDialog extends JDialog{
	private GameFrame gameFrame;
	private int b;
	
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

	/**
	 * New Board with About Dialog
	 * @return JPanel with a text
	 * @see JButton
	 */
	private JPanel getAboutPanel() {
		JPanel a = new JPanel();
		
		setSize(350,275);
		
		a.setLayout(new BoxLayout(a,BoxLayout.X_AXIS));
		a.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		{
			{
				JLabel about = new JLabel();
				about.setText("<html><h1><strong>GeoMago v1.0</strong></h1>"+
						"<strong>Autores:</strong><br/><ul>"+
						"<li>Andrés Ulloa</li><li>Marco Benzi</li><li>René Pozo</li>"+
						"</ul><h3>(c) 2014. GNU v2</h3></html>");
				a.add(about);
			}
		}
		return a;
	}
	
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
}
