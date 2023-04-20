package spring23team2;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

/**
 * 
 * @author Brandon Nguyen
 * @version 2.0
 *
 * Main Menu Class to verify and direct the user to the desired menu.
 * Update: added GUI
 */

public class MainMenu extends JFrame{
	
	private JButton button;
	private JButton button1;
	private JButton button2;
	
    public MainMenu() {
        super("ChocAn Main Screen");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //add more buttons
        button = new JButton("Provider Menu");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    dispose(); // close current screen
                    new ProviderLoginScreen(); // open validation screen
                }
            }
        });
        
        button1 = new JButton("Manager Menu");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    dispose(); // close current screen
                    new ManagerLoginScreen(); // open something else screen
                }
            }
        });
        
        button2 = new JButton("Operator Menu");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button2) {
					dispose(); // close current screen
					new OperatorLoginScreen(); // open validation screen
				}
			}
		});
		
        JPanel panel = new JPanel(new FlowLayout());
        
        //add button
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        
        add(panel);
        setVisible(true);
    }
    
    public static void main(String[] args) {
    	ManagerFiles.loadManagerMap();
    	MemberFiles.loadMemberMap();
    	OperatorFiles.loadOperatorMap();
    	ProviderFiles.loadProviderMap();
    	ProviderTransactionFiles.loadProviderTransactionMap();
        new MainMenu();
        ManagerFiles.save();
        MemberFiles.save();
        OperatorFiles.save();
        ProviderFiles.save();
        ProviderTransactionFiles.save();
    }
}

class ProviderLoginScreen extends JFrame {
	
	private JTextField textField;
	
    public ProviderLoginScreen() {
        super("Provider Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		textField = new JTextField(20);
		JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the value of the text field and display it
            	String inputValue = textField.getText();
                int number = Integer.parseInt(inputValue);
                if (ProviderFiles.searchProvider(number) == null) {
                	JOptionPane.showMessageDialog(ProviderLoginScreen.this, "You have entered an invalid number");
                } else {
                	JOptionPane.showMessageDialog(ProviderLoginScreen.this, "You have entered a correct number");
                }
            }
        });
        
        // Create a new panel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter your Provider Code: "));
        inputPanel.add(textField);
        inputPanel.add(submitButton);

        // Add the panel to the frame's content pane
        getContentPane().add(inputPanel);

        // Set the frame size and make it visible
        setSize(400, 400);
        setVisible(true);        
    }
}

class ManagerLoginScreen extends JFrame {
	
	private JTextField textField;
	
    public ManagerLoginScreen() {
        super("Manager Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		textField = new JTextField(20);
		JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the value of the text field and display it
                String inputValue = textField.getText();
                int number = Integer.parseInt(inputValue);
                if (ManagerFiles.searchManager(number) == null) {
                	JOptionPane.showMessageDialog(ManagerLoginScreen.this, "You have entered an invalid number");
                } else {
                	ManagerMenu.main(null);
                }
            }
        });
        
        // Create a new panel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter your Provider Code: "));
        inputPanel.add(textField);
        inputPanel.add(submitButton);

        // Add the panel to the frame's content pane
        getContentPane().add(inputPanel);

        // Set the frame size and make it visible
        setSize(400, 400);
        setVisible(true);        
    }
}


class OperatorLoginScreen extends JFrame {
	
	private JTextField textField;
	
	public OperatorLoginScreen() {
		super("Operator Login");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	textField = new JTextField(20);
    	JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    // Get the value of the text field and display it
                String inputValue = textField.getText();
                int number = Integer.parseInt(inputValue);
                if (OperatorFiles.searchOperator(number) == null) {
                	JOptionPane.showMessageDialog(OperatorLoginScreen.this, "You have entered an invalid number");
                } else {
                	OperatorMenu.main(null);;
                }
            }
       });
            
            // Create a new panel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter your Provider Code: "));
        inputPanel.add(textField);
        inputPanel.add(submitButton);

        // Add the panel to the frame's content pane
        getContentPane().add(inputPanel);

        // Set the frame size and make it visible
        setSize(400, 400);
        setVisible(true);        
    }
}

