package org.poo.geomago;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class AboutDialog extends JDialog{
	private GameFrame gameFrame;
	private int b;
	
	public AboutDialog(String title, int w, int h, int border, GameFrame gameFrame) {
		super(gameFrame);
		this.gameFrame = gameFrame;
		setTitle(title);
		setSize(w,h);
		setLocationRelativeTo(gameFrame);
		setModal(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		b = border;
		add(getReturnPanel());
	}
	
	private JPanel getReturnPanel() {
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.X_AXIS));
		p.setBorder(BorderFactory.createEmptyBorder(b,b,b,b));
		p.add(Box.createHorizontalGlue());
		p.add(Box.createHorizontalGlue());
		
		JButton okButton = new JButton("OK");
		
		okButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
            	//TODO: Abrir otro dialogo que permita poner nombres a jugadores humanos?
               	setVisible(false);
            }
        });
		return p;
	}
}
