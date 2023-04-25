package spring23team2;

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

public class ManagerMenu extends JFrame{
	private JButton button, button1, button2, button3;
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
					new SummaryReportScreen(); // open Summary Report screen
				}
			}    
		});
		
		button3 = new JButton("Request EFT Data Report");
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == button3) { //if "Request EFT Data Report" button is pressed
					dispose(); // close current screen
					new EFTReportScreen(); // open EFT Report screen
				}
			}    
		});


        JPanel panel = new JPanel(new FlowLayout());
        
        //adds buttons to screen
        panel.add(button);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        ProviderFiles.loadProviderMap();
        MemberFiles.loadMemberMap();
        new ManagerMenu(); //opens Manager Menu
        ProviderFiles.save();
        MemberFiles.save();
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
                String s = t.getText(); //gets text entered by the user
                int providerNumber = Integer.parseInt(s); //converts string to an integer
                Provider provider = ProviderFiles.searchProvider(providerNumber); //searches provider files for provider
                if(provider != null) { // If provider number is valid, generate the report
                	dispose(); // close current screen
					//new GenerateProviderReportScreen();
                	JOptionPane.showMessageDialog(ProviderReportScreen.this, "Generating Provider Report for Provider #" + providerNumber);
                	ProviderReport.createProviderReports();
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
                Member member = MemberFiles.searchMember(memberNumber); //searches member files for member
                if(member != null) { // If member number is valid, generate the report
                	dispose(); // close current screen
                	JOptionPane.showMessageDialog(MemberReportScreen.this, "Generating Member Report for Member #" + memberNumber);
                	MemberReport.createMemberReports();
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

class SummaryReportScreen extends JFrame{
	private JLabel label;
	public SummaryReportScreen() {
        super("Summary Report");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Generating Summary Report...");
        
        add(label);

        setVisible(true);
        
        SummaryReport.createSummaryReports();
    }
}

class EFTReportScreen extends JFrame{
	private JLabel label;
	public EFTReportScreen() {
        super("EFT Report");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        label = new JLabel("Generating EFT Report...");
        
        add(label);

        setVisible(true);
    }
}

