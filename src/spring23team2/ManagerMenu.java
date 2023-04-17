package spring23team2;

import java.util.Scanner;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

/**
* @author Gwynevere Deterding
* @version 1.0
*
* This is the user interface for the ChocAn Manager. The ChocAn Manager can request
* a provider report, member report, summary report, or EFT data report to be run.
*
*/

/*
public class ManagerMenu {
	
	public static void main(String[] args) {
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		System.out.println("Manager Menu");
		System.out.println("Please enter a number to select an option from the menu:");
		System.out.println("1. Request Provider Report");
		System.out.println("2. Request Member Report");
		System.out.println("3. Request Summary Report");
		System.out.println("4. Request EFT Data Report");
		
		int menuOption = myObj.nextInt();  // Read user input
		
		switch (menuOption) {
		case 1: // Request Provider Report  
			System.out.println("Please enter the provider number for the report you would like to request.");
			int providerNumber = myObj.nextInt(); // Read user input
			Provider provider = ProviderFiles.searchProvider(providerNumber); //searches provider files for provider 
			if(provider != null) { // If provider number is valid, generate the report
				System.out.print("Generating Provider Report for Provider #" + providerNumber);
				System.out.println("...");
			}
			else { // If provider number is invalid, exit
				System.out.println("Invalid Provider Number.");
			}
			break;
		
		case 2: // Request Member Report
			System.out.println("Please enter the member number for the report you would like to request.");
			int memberID = myObj.nextInt(); // Read user input
			Member member = MemberFiles.searchMember(memberID); //searches member files for member
			if(member != null) { // If member number is valid, generate the report
				System.out.print("Generating Member Report for Member #" + memberID);
				System.out.println("...");
			}
			else { // If member number is invalid, exit
				System.out.println("Invalid Member Number.");
			}
			break;
			
		case 3: // Request Summary Report
			System.out.println("Generating Summary Report...");
			break;
			
		case 4: // Request EFT Data Report
			System.out.println("Generating EFT Data Report...");
			break;
			
		default: // User selected invalid option
			System.out.println("Invalid Option");
	    }
		
		System.out.println("Exiting System."); // Exits system, should return to main menu
    }
		
}

*/


public class ManagerMenu extends JFrame{
	private JButton button, button1, button2, button3;
    public ManagerMenu() {
        super("Manager Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  

        //add more buttons
        button = new JButton("Request Provider Report");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) {
                    dispose(); // close current screen
                    new ProviderReportScreen(); // open validation screen
                }
            }
        });

        button1 = new JButton("Request Member Report");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) {
                    dispose(); // close current screen
                    new MemberReportScreen(); // open something else screen
                }
            }    
        });

		button2 = new JButton("Request Summary Report");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button2) {
					dispose(); // close current screen
					//new summaryReportScreen(); // open something else screen
				}
			}    
		});
		
		button3 = new JButton("Request EFT Data Report");
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button3) {
					dispose(); // close current screen
					//new eftReportScreen(); // open something else screen
				}
			}    
		});


        JPanel panel = new JPanel(new FlowLayout());
        
        //add button
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerMenu();
    }
}

class ProviderReportScreen extends JFrame {
	private JLabel label;
	private JTextField t;
	private JButton button4;
    public ProviderReportScreen() {
        super("Provider Report");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Please enter the provider number.");
        t = new JTextField(16);
        button4 = new JButton("Enter");
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s = t.getText();
                int providerNumber = Integer.parseInt(s);
                Provider provider = ProviderFiles.searchProvider(providerNumber); //searches provider files for provider
                if(provider != null) { // If provider number is valid, generate the report
                	dispose(); // close current screen
					//new GenerateProviderReportScreen(); // open something else screen
                	JOptionPane.showMessageDialog(ProviderReportScreen.this, "Generating Provider Report for Provider #" + providerNumber);
                }
                else {
                	JOptionPane.showMessageDialog(ProviderReportScreen.this, "Invalid Provider Number");
                }
            }
        });
        
        JPanel panel1 = new JPanel(new FlowLayout());
        
        panel1.add(label);
        panel1.add(t);
        panel1.add(button4);
        
        add(panel1);
        setVisible(true);
    }
}

class MemberReportScreen extends JFrame {
	private JLabel label;
	private JTextField t;
	private JButton button4;
    public MemberReportScreen() {
        super("Member Report");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        label = new JLabel("Please enter the member number.");
        t = new JTextField(16);
        button4 = new JButton("Enter");
        button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String s = t.getText();
                int memberNumber = Integer.parseInt(s);
                Member member = MemberFiles.searchMember(memberNumber); //searches provider files for provider
                if(member != null) { // If provider number is valid, generate the report
                	dispose(); // close current screen
					//new GenerateMemberReportScreen(); // open something else screen
                	JOptionPane.showMessageDialog(MemberReportScreen.this, "Generating Member Report for Member #" + memberNumber);
                }
                else {
                	JOptionPane.showMessageDialog(MemberReportScreen.this, "Invalid Member Number");
                }
            }
        });
        
        JPanel panel1 = new JPanel(new FlowLayout());
        
        panel1.add(label);
        panel1.add(t);
        panel1.add(button4);
        
        add(panel1);
        setVisible(true);
    }
    
}
