package com.company;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

class GUI extends JFrame {

    /**
     * Create the frame.
     */
    private GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        JPanel contentPane = new JPanel();
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

        JTextField tfUrlNummer = new JTextField();
        panelURL.add(tfUrlNummer);
        tfUrlNummer.setText("hier URL eingeben");
        tfUrlNummer.setColumns(10);

        JPanel panelNummer = new JPanel();
        panelEinstellungen.add(panelNummer);
        panelNummer.setLayout(new BoxLayout(panelNummer, BoxLayout.X_AXIS));

        JLabel lblNummer = new JLabel("Vermittlungsnummer");
        panelNummer.add(lblNummer);

        JTextField tfNummer = new JTextField();
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

        ButtonGroup groupModus = new ButtonGroup();
        groupModus.add(rdbtnNummer);
        groupModus.add(rdbtnAbfrage);

        JPanel panelEmail = new JPanel();
        contentPane.add(panelEmail, BorderLayout.CENTER);
        panelEmail.setLayout(new BoxLayout(panelEmail, BoxLayout.X_AXIS));

        JLabel lblEmail = new JLabel("Email-Adresse");
        panelEmail.add(lblEmail);

        JTextField tfEmail = new JTextField();
        panelEmail.add(tfEmail);
        tfEmail.setColumns(10);

        JButton btnImpfzentrenAnzeigen = new JButton("Impfzentren anzeigen");
        btnImpfzentrenAnzeigen.addActionListener(e -> {
            //TODO neues Fenster mit Impfterminauswahl öffnen
        });

        JPanel panelButtons = new JPanel();
        contentPane.add(panelButtons, BorderLayout.SOUTH);

        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(e -> {
            //TODO Suche starten
        });

        panelButtons.add(btnStart);
        panelButtons.add(btnImpfzentrenAnzeigen);
    }

    /**
     * Launch the application.
     */
    void run() {
        EventQueue.invokeLater(() -> {
            try {
                GUI frame = new GUI();
                frame.setVisible(true);
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }

}
