package timerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class Home extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField secondsField;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel minutesLabel;
	private JLabel hoursLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
	public Home() {
		/*
		 * Font montserratFont = null; GraphicsEnvironment ge =
		 * GraphicsEnvironment.getLocalGraphicsEnvironment(); try{ montserratFont =
		 * Font.createFont(Font.TRUETYPE_FONT, new
		 * File("assets\\Montserrat.ttf")).deriveFont(12f); } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setSize(500,650);
		contentPane = new JPanel();
		
		Color white = Color.decode("#FFFFFF"); //primary color, white
		Color lightBlue = Color.decode("#AED9E0"); //secondary color, light blue
		Color lightPink = Color.decode("#F7CED7"); //tertiary color, light pink
		
		Border lightBlueBorder = BorderFactory.createLineBorder(lightBlue);
		
		contentPane.setBackground(white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel createTimer = new JPanel();
		createTimer.setBackground(white);
		createTimer.setBounds(5, 11, 476, 90);
		contentPane.add(createTimer);
		
		JButton createButton = new JButton("Start");
		//createButton.setFont(montserratFont);
		
		createButton.setBounds(388, 32, 78, 23);
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		createTimer.setLayout(null);
		createTimer.add(createButton);
		
		nameField = new JTextField();
		nameField.setBounds(50, 34, 96, 20);
		createTimer.add(nameField);
		nameField.setColumns(1);
		nameField.setBorder(lightBlueBorder);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		nameLabel.setBounds(0, 37, 49, 14);
		createTimer.add(nameLabel);
		
		JLabel secondsLabel = new JLabel("Seconds:");
		secondsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		secondsLabel.setBounds(261, 64, 56, 14);
		createTimer.add(secondsLabel);
		
		secondsField = new JTextField();
		secondsField.setColumns(1);
		secondsField.setBounds(327, 61, 40, 20);
		createTimer.add(secondsField);
		
		textField = new JTextField();
		textField.setColumns(1);
		textField.setBounds(327, 7, 40, 20);
		createTimer.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(1);
		textField_1.setBounds(327, 33, 40, 20);
		createTimer.add(textField_1);
		
		minutesLabel = new JLabel("Minutes:");
		minutesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minutesLabel.setBounds(261, 36, 56, 14);
		createTimer.add(minutesLabel);
		
		hoursLabel = new JLabel("Hours:");
		hoursLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hoursLabel.setBounds(261, 10, 56, 14);
		createTimer.add(hoursLabel);
		
		JPanel listTimers = new JPanel();
		listTimers.setBounds(5, 112, 476, 490);
		contentPane.add(listTimers);
		listTimers.setLayout(null);
		
		table = new JTable();
		table.setBounds(0, 0, 476, 490);
		listTimers.add(table);
	}
}
