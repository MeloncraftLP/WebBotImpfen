package com.company;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;

class ImpfzentrenAuswahl extends JDialog {


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ImpfzentrenAuswahl dialog = new ImpfzentrenAuswahl();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	private ImpfzentrenAuswahl() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		JPanel contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(20, 3, 0, 0));
		{

			JTextField tfname1 = new JTextField();
			JTextField tfname2 = new JTextField();
			JTextField tfname3 = new JTextField();
			JTextField tfname4 = new JTextField();
			JTextField tfname5 = new JTextField();
			JTextField tfname6 = new JTextField();
			JTextField tfname7 = new JTextField();
			JTextField tfname8 = new JTextField();
			JTextField tfname9 = new JTextField();
			JTextField tfname10 = new JTextField();
			JTextField tfname11 = new JTextField();
			JTextField tfname12 = new JTextField();
			JTextField tfname13 = new JTextField();
			JTextField tfname14 = new JTextField();
			JTextField tfname15 = new JTextField();
			JTextField tfname16 = new JTextField();
			JTextField tfname17 = new JTextField();
			JTextField tfname18 = new JTextField();
			JTextField tfname19 = new JTextField();
			JTextField tfname20 = new JTextField();

			JTextField tfUrl1 = new JTextField();
			JTextField tfUrl2 = new JTextField();
			JTextField tfUrl3 = new JTextField();
			JTextField tfUrl4 = new JTextField();
			JTextField tfUrl5 = new JTextField();
			JTextField tfUrl6 = new JTextField();
			JTextField tfUrl7 = new JTextField();
			JTextField tfUrl8 = new JTextField();
			JTextField tfUrl9 = new JTextField();
			JTextField tfUrl10 = new JTextField();
			JTextField tfUrl11 = new JTextField();
			JTextField tfUrl12 = new JTextField();
			JTextField tfUrl13 = new JTextField();
			JTextField tfUrl14 = new JTextField();
			JTextField tfUrl15 = new JTextField();
			JTextField tfUrl16 = new JTextField();
			JTextField tfUrl17 = new JTextField();
			JTextField tfUrl18 = new JTextField();
			JTextField tfUrl19 = new JTextField();
			JTextField tfUrl20 = new JTextField();

			JLabel lbl1 = new JLabel("1");
			JLabel lbl2 = new JLabel("2");
			JLabel lbl3 = new JLabel("3");
			JLabel lbl4 = new JLabel("4");
			JLabel lbl5 = new JLabel("5");
			JLabel lbl6 = new JLabel("6");
			JLabel lbl7 = new JLabel("7");
			JLabel lbl8 = new JLabel("8");
			JLabel lbl9 = new JLabel("9");
			JLabel lbl10 = new JLabel("10");
			JLabel lbl11 = new JLabel("11");
			JLabel lbl12 = new JLabel("12");
			JLabel lbl13 = new JLabel("13");
			JLabel lbl14 = new JLabel("14");
			JLabel lbl15 = new JLabel("15");
			JLabel lbl16 = new JLabel("16");
			JLabel lbl17 = new JLabel("17");
			JLabel lbl18 = new JLabel("18");
			JLabel lbl19 = new JLabel("19");
			JLabel lbl20 = new JLabel("20");

			contentPanel.add(lbl1);
			contentPanel.add(tfname1);
			contentPanel.add(tfUrl1);
			contentPanel.add(lbl2);
			contentPanel.add(tfname2);
			contentPanel.add(tfUrl2);
			contentPanel.add(lbl3);
			contentPanel.add(tfname3);
			contentPanel.add(tfUrl3);
			contentPanel.add(lbl4);
			contentPanel.add(tfname4);
			contentPanel.add(tfUrl4);
			contentPanel.add(lbl5);
			contentPanel.add(tfname5);
			contentPanel.add(tfUrl5);
			contentPanel.add(lbl6);
			contentPanel.add(tfname6);
			contentPanel.add(tfUrl6);
			contentPanel.add(lbl7);
			contentPanel.add(tfname7);
			contentPanel.add(tfUrl7);
			contentPanel.add(lbl8);
			contentPanel.add(tfname8);
			contentPanel.add(tfUrl8);
			contentPanel.add(lbl9);
			contentPanel.add(tfname9);
			contentPanel.add(tfUrl9);
			contentPanel.add(lbl10);
			contentPanel.add(tfname10);
			contentPanel.add(tfUrl10);
			contentPanel.add(lbl11);
			contentPanel.add(tfname11);
			contentPanel.add(tfUrl11);
			contentPanel.add(lbl12);
			contentPanel.add(tfname12);
			contentPanel.add(tfUrl12);
			contentPanel.add(lbl13);
			contentPanel.add(tfname13);
			contentPanel.add(tfUrl13);
			contentPanel.add(lbl14);
			contentPanel.add(tfname14);
			contentPanel.add(tfUrl14);
			contentPanel.add(lbl15);
			contentPanel.add(tfname15);
			contentPanel.add(tfUrl15);
			contentPanel.add(lbl16);
			contentPanel.add(tfname16);
			contentPanel.add(tfUrl16);
			contentPanel.add(lbl17);
			contentPanel.add(tfname17);
			contentPanel.add(tfUrl17);
			contentPanel.add(lbl18);
			contentPanel.add(tfname18);
			contentPanel.add(tfUrl18);
			contentPanel.add(lbl19);
			contentPanel.add(tfname19);
			contentPanel.add(tfUrl19);
			contentPanel.add(lbl20);
			contentPanel.add(tfname20);
			contentPanel.add(tfUrl20);

			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
