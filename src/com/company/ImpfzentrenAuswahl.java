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

public class ImpfzentrenAuswahl extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private JTextField tfname1;
	private JTextField tfname2;
	private JTextField tfname3;
	private JTextField tfname4;
	private JTextField tfname5;
	private JTextField tfname6;
	private JTextField tfname7;
	private JTextField tfname8;
	private JTextField tfname9;
	private JTextField tfname10;
	private JTextField tfname11;
	private JTextField tfname12;
	private JTextField tfname13;
	private JTextField tfname14;
	private JTextField tfname15;
	private JTextField tfname16;
	private JTextField tfname17;
	private JTextField tfname18;
	private JTextField tfname19;
	private JTextField tfname20;

	private JTextField tfUrl1;
	private JTextField tfUrl2;
	private JTextField tfUrl3;
	private JTextField tfUrl4;
	private JTextField tfUrl5;
	private JTextField tfUrl6;
	private JTextField tfUrl7;
	private JTextField tfUrl8;
	private JTextField tfUrl9;
	private JTextField tfUrl10;
	private JTextField tfUrl11;
	private JTextField tfUrl12;
	private JTextField tfUrl13;
	private JTextField tfUrl14;
	private JTextField tfUrl15;
	private JTextField tfUrl16;
	private JTextField tfUrl17;
	private JTextField tfUrl18;
	private JTextField tfUrl19;
	private JTextField tfUrl20;

	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JLabel lbl6;
	private JLabel lbl7;
	private JLabel lbl8;
	private JLabel lbl9;
	private JLabel lbl10;
	private JLabel lbl11;
	private JLabel lbl12;
	private JLabel lbl13;
	private JLabel lbl14;
	private JLabel lbl15;
	private JLabel lbl16;
	private JLabel lbl17;
	private JLabel lbl18;
	private JLabel lbl19;
	private JLabel lbl20;

	
	
	
	
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
	public ImpfzentrenAuswahl() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(20, 3, 0, 0));
		{
		
			tfname1 = new JTextField();
			tfname2 = new JTextField();
			tfname3 = new JTextField();
			tfname4 = new JTextField();
			tfname5 = new JTextField();
			tfname6 = new JTextField();
			tfname7 = new JTextField();
			tfname8 = new JTextField();
			tfname9 = new JTextField();
			tfname10 = new JTextField();
			tfname11 = new JTextField();
			tfname12 = new JTextField();
			tfname13 = new JTextField();
			tfname14 = new JTextField();
			tfname15 = new JTextField();
			tfname16 = new JTextField();
			tfname17 = new JTextField();
			tfname18 = new JTextField();
			tfname19 = new JTextField();
			tfname20 = new JTextField();

			tfUrl1 = new JTextField();
			tfUrl2 = new JTextField();
			tfUrl3 = new JTextField();
			tfUrl4 = new JTextField();
			tfUrl5 = new JTextField();
			tfUrl6 = new JTextField();
			tfUrl7 = new JTextField();
			tfUrl8 = new JTextField();
			tfUrl9 = new JTextField();
			tfUrl10 = new JTextField();
			tfUrl11 = new JTextField();
			tfUrl12 = new JTextField();
			tfUrl13 = new JTextField();
			tfUrl14 = new JTextField();
			tfUrl15 = new JTextField();
			tfUrl16 = new JTextField();
			tfUrl17 = new JTextField();
			tfUrl18 = new JTextField();
			tfUrl19 = new JTextField();
			tfUrl20 = new JTextField();

			lbl1 = new JLabel("1");
			lbl2 = new JLabel("2");
			lbl3 = new JLabel("3");
			lbl4 = new JLabel("4");
			lbl5 = new JLabel("5");
			lbl6 = new JLabel("6");
			lbl7 = new JLabel("7");
			lbl8 = new JLabel("8");
			lbl9 = new JLabel("9");
			lbl10 = new JLabel("10");
			lbl11 = new JLabel("11");
			lbl12 = new JLabel("12");
			lbl13 = new JLabel("13");
			lbl14 = new JLabel("14");
			lbl15 = new JLabel("15");
			lbl16 = new JLabel("16");
			lbl17 = new JLabel("17");
			lbl18 = new JLabel("18");
			lbl19 = new JLabel("19");
			lbl20 = new JLabel("20");

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
