package com.company;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField tfNummer;
	private JTextField tfUrlNummer;
	private ButtonGroup groupModus;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	void run() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEinstellungen = new JPanel();
		contentPane.add(panelEinstellungen, BorderLayout.NORTH);
		panelEinstellungen.setLayout(new BorderLayout(0, 0));
		
		JPanel panelURL = new JPanel();
		panelEinstellungen.add(panelURL, BorderLayout.NORTH);
		panelURL.setLayout(new BoxLayout(panelURL, BoxLayout.X_AXIS));
		
		JLabel lblUrlNummer = new JLabel("URL");
		panelURL.add(lblUrlNummer);
		
		tfUrlNummer = new JTextField();
		panelURL.add(tfUrlNummer);
		tfUrlNummer.setText("hier URL eingeben");
		tfUrlNummer.setColumns(10);
		
		JPanel panelNummer = new JPanel();
		panelEinstellungen.add(panelNummer);
		panelNummer.setLayout(new BoxLayout(panelNummer, BoxLayout.X_AXIS));
		
		JLabel lblNummer = new JLabel("Vermittlungsnummer");
		panelNummer.add(lblNummer);
		
		tfNummer = new JTextField();
		panelNummer.add(tfNummer);
		tfNummer.setText("hier Nummer eingeben");
		tfNummer.setToolTipText("");
		tfNummer.setColumns(10);
		
		JPanel panelModus = new JPanel();
		panelEinstellungen.add(panelModus, BorderLayout.SOUTH);
		
		JRadioButton rdbtnNummer = new JRadioButton("Termin abfragen");
		rdbtnNummer.setSelected(true);
		panelModus.add(rdbtnNummer);
		
		JRadioButton rdbtnAbfrage = new JRadioButton("keine Vermittlungsnummer");
		panelModus.add(rdbtnAbfrage);
		
		groupModus = new ButtonGroup();
		groupModus.add(rdbtnNummer);
		groupModus.add(rdbtnAbfrage);
		
		JPanel panelEmail = new JPanel();
		contentPane.add(panelEmail, BorderLayout.CENTER);
		panelEmail.setLayout(new BoxLayout(panelEmail, BoxLayout.X_AXIS));
		
		JLabel lblEmail = new JLabel("Email-Adresse");
		panelEmail.add(lblEmail);
		
		tfEmail = new JTextField();
		panelEmail.add(tfEmail);
		tfEmail.setColumns(10);
		
		JButton btnImpfzentrenAnzeigen = new JButton("Impfzentren anzeigen");
		btnImpfzentrenAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO neues Fenster mit Impfterminauswahl öffnen
			}
		});
		
		JPanel panelButtons = new JPanel();
		contentPane.add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO Suche starten
			}
		});
		
		panelButtons.add(btnStart);
		panelButtons.add(btnImpfzentrenAnzeigen);
	}

}
