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
	
	public static int providerNum;
	private JButton button;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	
    public MainMenu() {
        super("ChocAn Main Screen");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
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
                    new ManagerLoginScreen(); // open validation screen
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
		
		button3 = new JButton("Run Main Accounting Procedure");
		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button3) {
					//generate every report
					MemberReport.createMemberReports();
					ProviderReport.createProviderReports();
					SummaryReport.createSummaryReports();
					JOptionPane.showMessageDialog(MainMenu.this, "Reports Generated");
				}
			}
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        //add buttons
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        add(panel);
        setVisible(true);
        setLocationRelativeTo(null);
    }
    
    //load all of the maps
    public static void main(String[] args) {
    	ManagerFiles.loadManagerMap();
    	MemberFiles.loadMemberMap();
    	OperatorFiles.loadOperatorMap();
    	ProviderFiles.loadProviderMap();
    	ProviderTransactionFiles.loadProviderTransactionMap();
    	MemberTransactionFiles.loadMemberTransactionMap();
    	ProviderDirectory.loadProviderDirectoryMap();
    	ProviderTransactionFiles.insertProviderTransaction(100000001, "April 22", "April 22","5:00", 100000001, "Charles", 200, 200);
    	new MainMenu();
        ManagerFiles.save();
        MemberFiles.save();
        OperatorFiles.save();
        ProviderFiles.save();
        ProviderTransactionFiles.save();
        MemberTransactionFiles.save();
        ProviderDirectory.save();
    }
    
	public static int getProviderNumber() {
		return providerNum;
	}
/**
 *  searches provider files for a provider
 *  @param providerNum
 */
public static Provider verifyProvider(int providerNum) {
	Provider provider = ProviderFiles.searchProvider(providerNum);
	return provider;
}

/**
 *  searches operator files for a operator
 *  @param operatorNum
 */
public static Operator verifyOperator(int operatorNum) {
	Operator operator = OperatorFiles.searchOperator(operatorNum);
	return operator;
}

/**
 *  searches manager files for a manager
 *  @param managerNum
 */
public static Manager verifyManager(int managerNum) {
	Manager manager = ManagerFiles.searchManager(managerNum);
	return manager;
}

/**
 *  Login Screen for Provider
 */
class ProviderLoginScreen extends JFrame {
	
	private JTextField textField;
	
    public ProviderLoginScreen() {
        super("Provider Login");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		textField = new JTextField(20);
		JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the value of the text field and display it
            	String inputValue = textField.getText();
                int number = Integer.parseInt(inputValue);
                if (MainMenu.verifyProvider(number) != null) {
                	MainMenu.providerNum = number;
                	dispose();
                	ProviderMenu.main(null);
                } else {
                	JOptionPane.showMessageDialog(ProviderLoginScreen.this, "You have entered an invalid number");
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
        setVisible(true);        
    }
}

/**
 *  Login Screen for Manager
 */
class ManagerLoginScreen extends JFrame {

	private JTextField textField;
	
    public ManagerLoginScreen() {
        super("Manager Login");
        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
		textField = new JTextField(20);
		JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the value of the text field and display it
                String inputValue = textField.getText();
                int number = Integer.parseInt(inputValue);
                if (MainMenu.verifyManager(number) != null) {
                	dispose();
                	ManagerMenu.main(null);
                } else {
                	JOptionPane.showMessageDialog(ManagerLoginScreen.this, "You have entered an invalid number");
                }
            }
        });
        
        // Create a new panel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter your Manager Code: "));
        inputPanel.add(textField);
        inputPanel.add(submitButton);

        // Add the panel to the frame's content pane
        getContentPane().add(inputPanel);

        // Set the frame size and make it visible
        setVisible(true);        
    }
}

/**
 *  Login Screen for Operator
 */
class OperatorLoginScreen extends JFrame {
	
	private JTextField textField;
	
	public OperatorLoginScreen() {
		super("Operator Login");
		setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	textField = new JTextField(20);
    	JButton submitButton = new JButton("Submit");

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                    // Get the value of the text field and display it
                String inputValue = textField.getText();
                int number = Integer.parseInt(inputValue);
                if (MainMenu.verifyOperator(number) != null) {
                	dispose();
                	OperatorMenu.main(null);
                } else {
                	JOptionPane.showMessageDialog(OperatorLoginScreen.this, "You have entered an invalid number");
                }
            }
       });
            
            // Create a new panel to hold the input components
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());
        inputPanel.add(new JLabel("Enter your Operator Code: "));
        inputPanel.add(textField);
        inputPanel.add(submitButton);

        // Add the panel to the frame's content pane
        getContentPane().add(inputPanel);

        // Set the frame size and make it visible
        setVisible(true);        
    	}
	}
}

