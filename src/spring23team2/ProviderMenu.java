package spring23team2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.time.LocalTime;
/**
* @author Zach Simpson
* @version 2.0
* Provider Menu
*/

//reads text from report file and displays it on the screen

class TextFileViewers extends JFrame {
	  private JTextArea textArea;
	  private JButton button;
	  private JLabel label;
	  public TextFileViewers(String fileName) {
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
	          e.printStackTrace();
	      }
	      
	      button = new JButton("Close");
	      button.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent e) {
	      		dispose();
	      	}
	      });
	      label = new JLabel("Directory");
	      
	      JPanel panel = new JPanel(new FlowLayout());
	      
	      panel.add(label);
	      panel.add(scrollPane);        //adds label, text field, and button to screen
	      panel.add(button);
	      
	      add(panel);
	      setVisible(true);
	  }
}

public class ProviderMenu extends JFrame{
	public static int memberNum = -1;
	public static String Date = "";
	public static Boolean authenticated = true;
	private JTextField memberNumber;
    private JButton validateMember;
    private JButton billChocAn;
    private JButton requestProviderDirectory;
    
    public ProviderMenu() {
        super("Provider Menu");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 

        MemberFiles.loadMemberMap();
        ProviderDirectory.loadProviderDirectoryMap();
        
        validateMember = new JButton("Validate Member");
        billChocAn = new JButton("Bill ChocAn");
        requestProviderDirectory = new JButton("Request Provider Directory");
        memberNumber = new JTextField(30);
        memberNumber.setBorder(null);
        

        validateMember.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == validateMember) {
                    dispose(); 
                    new ValidateMemberScreen();
                }
            }
        });

        billChocAn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == billChocAn) {
                    dispose(); 
                    new BillChocAnVerify(); 
                }
            }
        });

        requestProviderDirectory.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == requestProviderDirectory) {
                    new TextFileViewers("ProviderDirectory.properties");
                }
            }
        });



        JPanel panel = new JPanel(new FlowLayout());
        
        //add button
        panel.add(validateMember);
        panel.add(billChocAn);
        panel.add(requestProviderDirectory);
        panel.add(memberNumber);
        
        add(panel);
        setVisible(true);
    }
    public static void main(String[] args){
        new ProviderMenu();
    }
}

class ValidateMemberScreen extends JFrame {
	public JTextField memberNumber = new JTextField(9);
    public JButton enterNumber = new JButton("Enter Member Number");
    public JButton backToProviderMenu = new JButton("Back");
    public JTextArea status = new JTextArea();
    
    
    public ValidateMemberScreen () {
        super("Validate Member");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        status.setEditable(false);
        status.setBorder(null);
        
        backToProviderMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backToProviderMenu) {
                    dispose();
                    new ProviderMenu(); 
                }
            }
        });
        
        enterNumber.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == enterNumber) {
                	if((memberNumber.getText() == null) || (memberNumber.getText().length() != 9)) {
                		status.setText("Please enter a 9 digit member number.");
                	}
                	else if(memberNumber.getText().length() == 9) {
                		if(MemberFiles.searchMember(Integer.parseInt(memberNumber.getText())) == null) {
                    		JOptionPane.showMessageDialog(ValidateMemberScreen.this, "Member could not be found or does not exist.");
                        }
                		else if(MemberFiles.searchMember(Integer.parseInt(memberNumber.getText())) != null) {
                			JOptionPane.showMessageDialog(ValidateMemberScreen.this, "Valid Member");
                		}
                	}
                }
            }
        });
        
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(memberNumber);
        panel.add(enterNumber);
        panel.add(backToProviderMenu);
        panel.add(status);
        
        
        add(panel);
        setVisible(true);
    }
}

class BillChocAnVerify extends JFrame {
	public JTextField memberNumber = new JTextField(9);
    public JButton enterNumber = new JButton("Enter Member Number");
    public JButton backToProviderMenu = new JButton("Back");
    public JTextArea status = new JTextArea();
    
    
    public BillChocAnVerify () {
        super("Validate Member");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        status.setEditable(false);
        status.setBorder(null);
        
        backToProviderMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backToProviderMenu) {
                    dispose();
                    new ProviderMenu(); 
                }
            }
        });
        
        enterNumber.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == enterNumber) {
                	if((memberNumber.getText() == null) || (memberNumber.getText().length() != 9)) {
                		status.setText("Please enter a 9 digit member number.");
                	}
                	else if(memberNumber.getText().length() == 9) {
                		if(MemberFiles.searchMember(Integer.parseInt(memberNumber.getText())) == null) {
                    		JOptionPane.showMessageDialog(BillChocAnVerify.this, "Member could not be found or does not exist.");
                        }
                		else if(MemberFiles.searchMember(Integer.parseInt(memberNumber.getText())) != null) {
                			ProviderMenu.memberNum = Integer.parseInt(memberNumber.getText());
                			dispose();
                			new Date();
                		}
                	}
                }
            }
        });
        
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(memberNumber);
        panel.add(enterNumber);
        panel.add(backToProviderMenu);
        panel.add(status);
        
        
        add(panel);
        setVisible(true);
    }
}

class BillChocAnScreen extends JFrame {
	public JTextField serviceDate = new JTextField(10);
	public JTextField recievedDate = new JTextField(10);
	public JTextField recievedTime = new JTextField(10);
	public JTextField serviceCode = new JTextField(6);
	public JTextField providerNum = new JTextField(9);
	public JTextField fee = new JTextField(6);
	public JTextField comments = new JTextField(100);
	public JButton backToProviderMenu = new JButton("Back");
	public JButton confirm = new JButton("Confirm");
	public JTextArea errors = new JTextArea();
	
    public BillChocAnScreen () {
        super("Bill ChocAn");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        serviceDate.setText("Service Date");
        recievedDate.setText("Recieved Date");
        recievedTime.setText("Recieved Time");
        serviceCode.setText("Code");
        providerNum.setText("Provider#");
        fee.setText("Fee");
        comments.setText("Comments");
        errors.setEditable(false);
        errors.setBorder(null);
        errors.setText("");
        
        confirm.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == confirm) {
                    Boolean noErrors = true;
                    errors.setText("");
                    if(serviceDate.getText().length() != 10) {
                    	errors.setText(errors.getText() + "Please ensure the service date is 10 characters long (Format MM/DD/YYYY). \n");
                    	noErrors = false;
                    }
                    if(recievedDate.getText().length() != 10) {
                    	errors.setText(errors.getText() + "Please ensure the recieved date is 10 characters long (Format MM/DD/YYYY). \n");
                    	noErrors = false;
                    }
                    if(recievedTime.getText().length() != 5) {
                    	errors.setText(errors.getText() + "Please ensure the recieved time is 5 characters long (Format HH/MM). \n");
                    	noErrors = false;
                    }
                    if(serviceCode.getText().length() != 6) {
                    	errors.setText(errors.getText() + "Please ensure the service code is exactly 6 digits. \n");
                    	noErrors = false;
                    }
                    if(providerNum.getText().length() != 9) {
                    	errors.setText(errors.getText() + "Please ensure the provider number is exactly 9 digits. \n");
                    	noErrors = false;
                    }
                    if(comments.getText().length() > 100) {
                    	errors.setText(errors.getText() + "Please ensure your comments are no longer than 100 characters. \n");
                    	noErrors = false;
                    }
                    if(ProviderMenu.memberNum == -1) {
                    	errors.setText(errors.getText() + "Please sign in as a valid member. \n");
                    	noErrors = false;
                    }
                    try {
                    	int value;
                    	value = Integer.parseInt(fee.getText());
                    }
                    catch (NumberFormatException f) {
                    	errors.setText(errors.getText() + "Please enter a valid fee (integer) \n");
                    	noErrors = false;
                    }
                    if(noErrors) {
                    	ProviderTransactionFiles.insertProviderTransaction(Integer.parseInt(providerNum.getText()), serviceDate.getText(), recievedDate.getText(), recievedTime.getText(), ProviderMenu.memberNum, MemberFiles.searchMember(ProviderMenu.memberNum).name, Integer.parseInt(serviceCode.getText()), Integer.parseInt(fee.getText()));
                    	dispose();
                    }
                }
            }
        });
        
        backToProviderMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backToProviderMenu) {
                    dispose();
                    new ProviderMenu(); 
                }
            }
        });

        JPanel panel = new JPanel(new FlowLayout());
        add(panel);
        
        panel.add(serviceDate);
        panel.add(recievedDate);
        panel.add(recievedTime);
        panel.add(serviceCode);
        panel.add(providerNum);
        panel.add(fee);
        panel.add(comments);
        panel.add(confirm);
        panel.add(backToProviderMenu);
        panel.add(errors);
        
        setVisible(true);
    }
}

class RequestProviderDirectoryScreen extends JFrame {
	
	private JButton backToProviderMenu = new JButton("Back");
	private JTextField serviceCode = new JTextField(6);
	private JButton requestInfo = new JButton("Request Service Info");
	private JTextArea info = new JTextArea();
	private JButton confirm = new JButton("Confirm");
	private JButton ProviderDirectoryButton = new JButton("Provider Directory");
	
    public RequestProviderDirectoryScreen () {
        super("Provider Directory");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        info.setEditable(false);
        info.setBorder(null);
        
        backToProviderMenu.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == backToProviderMenu) {
                    dispose();
                    new ProviderMenu(); 
                }
            }
        });
        
        requestInfo.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == requestInfo) {
                    if(serviceCode.getText().length() != 6) {
                    	info.setText("Please enter a valid 6 digit code. ");
                    }
                    else if(ProviderDirectory.searchDirectory(Integer.parseInt(serviceCode.getText())) == null) {
                    	info.setText("Entered service code does not exist. ");
                    }
                    else {
                    	String val[] = ProviderDirectory.searchDirectory(Integer.parseInt(serviceCode.getText()));
                    	info.setText("Service Name: " + val[0] + "\n" + "Service Fee: $" + val[1]);
                    }
                }
            }
        });
        
        confirm.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == confirm) {
        			LocalTime currentTime = LocalTime.now();
        			String formattedTime = String.format("%02d:%02d", currentTime.getHour(), currentTime.getMinute());
        			String val[] = ProviderDirectory.searchDirectory(Integer.parseInt(serviceCode.getText()));
        			ProviderTransactionFiles.insertProviderTransaction(MainMenu.getProviderNumber(), ProviderMenu.Date, ProviderMenu.Date, formattedTime, ProviderMenu.memberNum, MemberFiles.searchMember(ProviderMenu.memberNum).name, Integer.parseInt(serviceCode.getText()), Integer.parseInt(val[1]));
        		}
        	}
        });
        
        ProviderDirectoryButton.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e) {
        		if (e.getSource() == ProviderDirectoryButton) {
        			new TextFileViewers("ProviderDirectory.properties");
        		}
        	}
        });
        JPanel panel = new JPanel(new FlowLayout());
        add(panel);
        
        panel.add(serviceCode);
        panel.add(requestInfo);
        panel.add(backToProviderMenu);
        panel.add(info);
        panel.add(confirm);
        panel.add(ProviderDirectoryButton);
        setVisible(true);
    }
}

class Date extends JFrame {
	private JButton Date = new JButton("Enter Date");
	private JTextField DateText = new JTextField(6);
	public JTextArea errors = new JTextArea();
	
    public Date () {
        super("Date");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); 
        
        errors.setEditable(false);
        errors.setBorder(null);
        errors.setText("");
        
        Date.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Date) {
                	Boolean noErrors = true;
                    if(DateText.getText().length() != 10) {
                    	errors.setText(errors.getText() + "Please ensure the recieved date is 10 characters long (Format MM/DD/YYYY). \n");
                    	noErrors = false;
                    }
                    if (noErrors) {
                    	ProviderMenu.Date = Date.getText();
                    	dispose();
                    	new RequestProviderDirectoryScreen();
                    }
                }
            }
        });
 
        

        JPanel panel = new JPanel(new FlowLayout());
        add(panel);
        
        panel.add(DateText);
        panel.add(Date);
        panel.add(errors);
        setVisible(true);
    }
}