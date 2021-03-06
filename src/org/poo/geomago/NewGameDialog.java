package org.poo.geomago;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * New Game Dialog for starting a new game
 */
public class NewGameDialog extends JDialog {
	private int b;
	private GameFrame gameFrame;
	private JSpinner mHeightSpinner;
	private JSpinner mWidthSpinner;
	private JSpinner mNPlayersSpinner;
	private JSpinner mHumanPlayersSpinner;
	private SpinnerNumberModel mHumanSpinnerModel;

	private JPanel getNumberPlayersPanel() {
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {1};
		gbl_panel.rowHeights = new int[] {1};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		{
			JLabel lblNewLabel = new JLabel("Número total de jugadores:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			mNPlayersSpinner = new JSpinner(new SpinnerNumberModel(2, 2, 4, 1));
			mNPlayersSpinner.addChangeListener(new ChangeListener() {

				@Override
				public void stateChanged(ChangeEvent arg0) {
					if ((Integer) mHumanPlayersSpinner.getValue() > (Integer) mNPlayersSpinner.getValue()) {
						mHumanPlayersSpinner.setValue(mNPlayersSpinner.getValue());
					}
					mHumanSpinnerModel.setMaximum((Comparable) mNPlayersSpinner.getValue());
				}
			});
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner.anchor = GridBagConstraints.EAST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 0;
			panel.add(mNPlayersSpinner, gbc_spinner);
		}
		return panel;
	}

	private JPanel getNumberHumanPlayersPanel() {
		JPanel panel = new JPanel();
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {1};
		gbl_panel.rowHeights = new int[] {1};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		{
			JLabel lblNewLabel = new JLabel("Número de jugadores humanos:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			panel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			mHumanSpinnerModel = new SpinnerNumberModel(1, 0, (Comparable) mNPlayersSpinner.getValue(), 1);
			mHumanPlayersSpinner = new JSpinner(mHumanSpinnerModel);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner.anchor = GridBagConstraints.EAST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 0;
			panel.add(mHumanPlayersSpinner, gbc_spinner);
		}
		return panel;
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
				if (getDesiredNumberOfHumanPlayers() != 0) {
					NewPlayersDialog n = new NewPlayersDialog("Nombres jugadores humanos",getDesiredNumberOfHumanPlayers(),
							gameFrame);
					setVisible(false);
					n.setVisible(true);
					if (n.getRetunValue() == JOptionPane.OK_OPTION) {
						gameFrame.newBoard(getDesiredTableroWidth(), getDesiredTableroHeight(), getDesiredNumberOfPlayers(),
								n.getPlayerNames());
					} else {
						setVisible(true);
					}
				} else {
					setVisible(false);
					gameFrame.newBoard(getDesiredTableroWidth(), getDesiredTableroHeight(), getDesiredNumberOfPlayers(),
							new ArrayList<String>());
				}
			}
		});
		cButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
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
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tamaño del Tablero", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {115, 70};
		gbl_panel.rowHeights = new int[] {28, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0, 1.0};
		panel.setLayout(gbl_panel);
		{
			JLabel lblHorizontal = new JLabel("Horizontal:");
			GridBagConstraints gbc_lblHorizontal = new GridBagConstraints();
			gbc_lblHorizontal.anchor = GridBagConstraints.WEST;
			gbc_lblHorizontal.insets = new Insets(0, 0, 5, 5);
			gbc_lblHorizontal.gridx = 0;
			gbc_lblHorizontal.gridy = 0;
			panel.add(lblHorizontal, gbc_lblHorizontal);
		}
		{
			mWidthSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 40, 1));
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner.anchor = GridBagConstraints.EAST;
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 0;
			panel.add(mWidthSpinner, gbc_spinner);
		}
		{
			JLabel lblVertical = new JLabel("Vertical:");
			GridBagConstraints gbc_lblVertical = new GridBagConstraints();
			gbc_lblVertical.anchor = GridBagConstraints.WEST;
			gbc_lblVertical.insets = new Insets(0, 0, 0, 5);
			gbc_lblVertical.gridx = 0;
			gbc_lblVertical.gridy = 1;
			panel.add(lblVertical, gbc_lblVertical);
		}
		{
			mHeightSpinner = new JSpinner(new SpinnerNumberModel(10, 10, 40, 1));
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.fill = GridBagConstraints.HORIZONTAL;
			gbc_spinner.insets = new Insets(0, 0, 0, 5);
			gbc_spinner.anchor = GridBagConstraints.EAST;
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 1;
			panel.add(mHeightSpinner, gbc_spinner);
		}
		return panel;
	}

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
		super(gameFrame);
		this.gameFrame = gameFrame;
		setTitle(title);
		setSize(w,h);
		setLocationRelativeTo(gameFrame);
		setModal(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		b = border;
		add(getNumberPlayersPanel());
		add(getNumberHumanPlayersPanel());
		add(Box.createVerticalGlue());
		add(getTableroSizePanel());
		add(Box.createVerticalGlue());
		add(getReturnPanel());
	}

	public int getDesiredTableroWidth() {
		return (Integer) mWidthSpinner.getValue();
	}

	public int getDesiredTableroHeight() {
		return (Integer) mHeightSpinner.getValue();
	}

	public int getDesiredNumberOfPlayers() {
		return (Integer) mNPlayersSpinner.getValue();
	}
	public int getDesiredNumberOfHumanPlayers() {
		return (Integer) mHumanPlayersSpinner.getValue();
	}
}