package spring23team2;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
* @author Gwynevere Deterding
* @version 1.0
*
* This is the user interface for the ChocAn Manager. The ChocAn Manager can request
* a provider report, member report, or summary report.
*
*/

public class ManagerMenu extends JFrame{
	private JButton button, button1, button2;
    public ManagerMenu() {
        super("Manager Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  

        button = new JButton("Request Provider Report");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button) { //if "Request Provider Report" button is pressed
                    dispose(); // close current screen
                    new ProviderReportScreen(); // open Provider Report screen
                }
            }
        });

        button1 = new JButton("Request Member Report");
        button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == button1) { //if "Request Member Report" button is pressed
                    dispose(); // close current screen
                    new MemberReportScreen(); // open Member Report screen
                }
            }    
        });

		button2 = new JButton("Request Summary Report");
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button2) { //if "Request Summary Report" button is pressed
					dispose(); // close current screen
					SummaryReport.createSummaryReports();
					new TextFileViewer("SummaryReport/SummaryReport.txt");
				}
			}    
		});
		

        JPanel panel = new JPanel(new FlowLayout());
        
        //adds buttons to screen
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ManagerMenu(); //opens Manager Menu
    }
    
    //searches provider files for a provider
    public static Provider getProvider(int providerNum) {
    	Provider provider = ProviderFiles.searchProvider(providerNum);
    	return provider;
    }
    
    //searches member files for a member
    public static Member getMember(int memberNum) {
    	Member member = MemberFiles.searchMember(memberNum);
    	return member;
    }
}
/**
*  Reads text from report file and displays it on the screen
*/
class TextFileViewer extends JFrame {
    private JTextArea textArea;
    private JButton button;
    private JLabel label;
    public TextFileViewer(String fileName) {
        super("Text File Viewer");
        setSize(300, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {                          
                textArea.append(line + "\n");
            }
            reader.close();
        } catch (IOException e) {
        	textArea.append("No report available");
            e.printStackTrace();
        }
        
        button = new JButton("Close");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		MainMenu.main(null);
        	}
        });
        label = new JLabel("Report");
        
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);
        panel.add(scrollPane);        //adds label, text field, and button to screen
        panel.add(button);
        
        add(panel);
        setVisible(true);
    }
}

/**
* Screen to enter provider number to request the corresponding provider report
*/
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
                String s = t.getText(); //gets text entered by the user
                int providerNumber = Integer.parseInt(s); //converts string to an integer
                Provider provider = ManagerMenu.getProvider(providerNumber);
                if(provider != null) { // If provider number is valid, generate the report
                	dispose(); // close current screen
                	ProviderReport.createProviderReports();
                	new TextFileViewer("ProviderReports/" + providerNumber + ".txt");
                }
                else {
                	JOptionPane.showMessageDialog(ProviderReportScreen.this, "Invalid Provider Number");
                }
            }
        });
        
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(t);
        panel.add(button4);
        
        add(panel);
        setVisible(true);
    }
}

/**
* Screen to enter member number to request the corresponding member report
*/
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
                String s = t.getText(); //gets text entered by the user
                int memberNumber = Integer.parseInt(s); //converts string to an integer
                Member member = ManagerMenu.getMember(memberNumber);
                if(member != null) { // If member number is valid, generate the report
                	dispose(); // close current screen
                	MemberReport.createMemberReports();
                	new TextFileViewer("MemberReports/" + memberNumber + ".txt");
                }
                else {
                	JOptionPane.showMessageDialog(MemberReportScreen.this, "Invalid Member Number");
                }
            }
        });
        
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(t);
        panel.add(button4);
        
        add(panel);
        setVisible(true);
    }
    
}



