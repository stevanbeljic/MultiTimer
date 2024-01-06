package timerGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.MenuKeyEvent;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.JTable;

public class Home extends JFrame {

	
	private Color white = Color.decode("#FFFFFF"); //primary color, white
	private Color lightBlue = Color.decode("#AED9E0"); //secondary color, light blue
	private Color lightPink = Color.decode("#F7CED7"); //tertiary color, light pink
	
	private int buttonDimension = 30;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nameField;
	private JTextField secondsField;
	private JTextField hoursField;
	private JTextField minutesField;
	private JLabel minutesLabel;
	private JLabel hoursLabel;
	JPanel createTimer;
	JPanel listTimers;

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
					Thread updaterWorker = new Thread(new Runnable() {
						@Override
						public void run() {
							frame.updateGUI();
						}
					});
					updaterWorker.start();
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
		setTitle("MutliTimer");
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
		setResizable(false);
		contentPane = new JPanel();
				
		Border lightBlueBorder = BorderFactory.createLineBorder(lightBlue);
		
		contentPane.setBackground(white);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		createTimer = new JPanel();
		createTimer.setBackground(white);
		createTimer.setBounds(5, 11, 476, 90);
		contentPane.add(createTimer);
		
		JButton createButton = new JButton("Start");
		//createButton.setFont(montserratFont);
		
		createButton.setBounds(388, 32, 78, 23);
		createButton.setEnabled(false);
		createButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try{
					createTimerCard();
				} catch (NumberFormatException n) {
					//Non-digits entered as numbers
				}
				clearLabels();
			}
		});
		createTimer.setLayout(null);
		createTimer.add(createButton);
		
		nameField = new JTextField();
		nameField.setBounds(50, 34, 96, 20);
		createTimer.add(nameField);
		nameField.setColumns(1);
		//nameField.setBorder(lightBlueBorder);
		nameField.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				createButton.setEnabled(true);
			}
		});
		
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
		
		hoursField = new JTextField();
		hoursField.setColumns(1);
		hoursField.setBounds(327, 7, 40, 20);
		createTimer.add(hoursField);
		
		minutesField = new JTextField();
		minutesField.setColumns(1);
		minutesField.setBounds(327, 33, 40, 20);
		createTimer.add(minutesField);
		
		minutesLabel = new JLabel("Minutes:");
		minutesLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		minutesLabel.setBounds(261, 36, 56, 14);
		createTimer.add(minutesLabel);
		
		hoursLabel = new JLabel("Hours:");
		hoursLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hoursLabel.setBounds(261, 10, 56, 14);
		createTimer.add(hoursLabel);
		
		listTimers = new JPanel();
		listTimers.setBackground(new Color(255, 255, 255));
		listTimers.setBounds(5, 112, 476, 490);
		contentPane.add(listTimers);
		
		BoxLayout bl_listTimers = new BoxLayout(listTimers, BoxLayout.Y_AXIS);
		listTimers.setLayout(bl_listTimers);
		
	}
	
	private void createTimerCard() {
        String name = nameField.getText();
        int hours, minutes, seconds;
        
        if(hoursField.getText().equals("")) {
        	hours = 0;
        } else {
            hours = Integer.parseInt(hoursField.getText());
        }
        
        if(minutesField.getText().equals("")) {
        	minutes = 0;
        } else {
            minutes = Integer.parseInt(minutesField.getText());
        }
        
        if(secondsField.getText().equals("")) {
        	seconds = 0;
        } else {
            seconds = Integer.parseInt(secondsField.getText());
        }
        
        
        TimerCard timerCard = new TimerCard(name, hours, minutes, seconds);  

        listTimers.add(timerCard);
        listTimers.add(Box.createVerticalStrut(5));

        listTimers.revalidate();
        //listTimers.repaint();
	}
	
	
	public class TimerCard extends JPanel {
	    private static final long serialVersionUID = 1L;
	    private String timerName;
	    private int totalDuration;
	    private int durationHours;
	    private int durationMinutes;
	    private int durationSeconds;
	    private LocalTimer lt;
	    private GridBagLayout gbl;
	    private LineBorder lBorder;
	    private JButton cancelButton;
	    private JButton pauseButton;
	    JLabel timeLabel;
	    
	    private boolean paused = false;
	    private boolean disabled = false;
	    
	    public void setPause(boolean pauseStatus) {
	    	paused = pauseStatus;
	    }
	    
	    public boolean getPause() {
	    	return paused;
	    }

	    public TimerCard(String name, int hours, int minutes, int seconds) {
	    	this.setBackground(white);
	    	
	        this.timerName = name;
	        durationHours = hours;
	        durationMinutes = minutes;
	        durationSeconds = seconds;
	        
	        lBorder = new LineBorder(Color.BLACK, 2, true);
	        setBorder(lBorder);
	        gbl = new GridBagLayout();
	        setLayout(gbl);
	        GridBagConstraints gbc = new GridBagConstraints();
	        
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout());
	        
	        JLabel nameLabel = new JLabel(name);
	        nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.gridwidth = 1;
	        add(nameLabel, gbc);

	        totalDuration = seconds + (60 * minutes) + (3600 * hours);
	        lt = new LocalTimer(timerName, totalDuration);

	        timeLabel = new JLabel(String.format("%02d:%02d:%02d", hours, minutes, seconds));
	        timeLabel.setFont(new Font("SansSerif", Font.PLAIN, 18));
	        gbc.gridx = 1;
	        gbc.gridy = 2;
	        gbc.gridwidth = 1;
	        add(timeLabel, gbc);
	        
	        gbc.gridx = 2;
	        gbc.gridy = 2;
	        add(Box.createHorizontalStrut(200), gbc);
	        
	        pauseButton = new JButton();
	        ImageIcon pauseImg = new ImageIcon(getClass().getResource("pause.png"));
	        pauseButton.setIcon(getScaledImage(pauseImg, buttonDimension, buttonDimension));
	        pauseButton.setPreferredSize(new Dimension(buttonDimension, buttonDimension));
	        
	        ImageIcon playImg = new ImageIcon(getClass().getResource("play.png"));
	        
	        pauseButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(getPause()) {
						pauseButton.setIcon(getScaledImage(pauseImg, buttonDimension, buttonDimension));
						setPause(false);
					} else {
						pauseButton.setIcon(getScaledImage(playImg, buttonDimension, buttonDimension));
						setPause(true);
					}
					
				}
			});
	        gbc.gridx = 3;
	        gbc.gridy = 2;
	        add(pauseButton, gbc);
	        
	        gbc.gridx = 4;
	        gbc.gridy = 2;
	        add(Box.createHorizontalStrut(20), gbc);
	        
	        cancelButton = new JButton();
	        ImageIcon cancelImg = new ImageIcon(getClass().getResource("close.jpg"));
	        cancelButton.setIcon(getScaledImage(cancelImg, buttonDimension, buttonDimension));
	        cancelButton.setPreferredSize(new Dimension(buttonDimension, buttonDimension));
	        cancelButton.setEnabled(true);
	        cancelButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					removeTimerCard();
				}
			});
	        gbc.gridx = 5;
	        gbc.gridy = 2;
	        add(cancelButton, gbc);
	        
	        this.setPreferredSize(new Dimension(456, 85));
	        this.setMinimumSize(new Dimension(456, 85));
	        this.setMaximumSize(new Dimension(456, 85)); 
	        validate();
	    }

	    public void updateTimeLabel() {
	        if (lt.getRemainingDuration() == 0 && !disabled) {
	        	disabled = true;
	            AudioPlayer ap = new AudioPlayer("harp.wav");
	            ap.play();
	            this.timeLabel.setText("Finished - " + formatTimeLabel(lt.getTotalDuration()));
	            pauseButton.setVisible(false);
	            return;
	        } else if(!disabled) {
	        	timeLabel.setText(formatTimeLabel(lt.getRemainingDuration()));
	        }
	    }
	    
	    public void removeTimerCard() {
	    	listTimers.remove(this);
	    	listTimers.revalidate();
	    }

	    public void decrementTime() {
	        if (lt.getRemainingDuration() > 0 && !this.paused) {
	            lt.decrementTime();
	        }
	    }
	    
	    public String formatTimeLabel(int duration) {
			return String.format("%02d:%02d:%02d", duration / 3600, duration % 3600 / 60, duration % 60);
		}
	}
	
	public void clearLabels() {
		hoursField.setText("");
		minutesField.setText("");
		secondsField.setText("");
		nameField.setText("");
	}
	
	public void updateGUI() {
		Component[] components;
		while(true) {
			components = listTimers.getComponents();
			for(Component c : components) {
				if (c instanceof TimerCard) {
					TimerCard tc = (TimerCard)c;
					tc.updateTimeLabel();					
					tc.decrementTime();
				}
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public ImageIcon getScaledImage(ImageIcon imgIcon, int width, int height) {
		Image image = imgIcon.getImage();
		Image newImage = image.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(newImage);
	}
	
}
