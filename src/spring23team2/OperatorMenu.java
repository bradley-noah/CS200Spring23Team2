package spring23team2;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

/**
 * @author Billal Amer
 * @version 1.0
 * Operator Menu GUI for adding, deleting, and updating providers and members
 * in the ChocAn system
 * 
 */

public class OperatorMenu extends JFrame{
	private JButton amb, dmb, umb, apb, dpb, upb, quitb;
	public OperatorMenu() {
		super("Operator Menu");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		amb = new JButton("Add Member");
		amb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == amb) {
					dispose();
					new AddMemberScreen1();
					
				}
			}
		
		});
		
		dmb = new JButton("Delete Member");
		dmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dmb) {
					dispose();
					new DeleteMemberScreen();
				}
			}
		
		});
		
		umb = new JButton("Update Member");
		umb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == umb) {
					dispose();
					new UpdateMemberScreen();
				}
			}
		
		});
		
		apb = new JButton("Add Provider");
		apb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == apb) {
					dispose();
					
				}
			}
		
		});
		
		dpb = new JButton("Delete Provider");
		dpb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dpb) {
					dispose();
					
				}
			}
		
		});
		
		upb = new JButton("Update Provider");
		upb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == upb) {
					dispose();
					
				}
			}
		
		});
		
		quitb = new JButton("Quit");
		quitb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == quitb) {
					dispose();
					
				}
			}
		
		});
		
        JPanel panel = new JPanel(new FlowLayout());
        
        //adds buttons to screen
        panel.add(amb);
        panel.add(dmb);
        panel.add(umb);
        panel.add(apb);
        panel.add(dpb);
        panel.add(upb);
        panel.add(quitb);
        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OperatorMenu(); //opens Manager Menu
        ProviderFiles.loadProviderMap();
        MemberFiles.loadMemberMap();
        ProviderFiles.save();
        MemberFiles.save();
	}
}

class AddMemberScreen1 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public AddMemberScreen1() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter name of new member: ");
		field = new JTextField(20);
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				dispose();
				new AddMemberScreen2();
				}		
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);		
	}
			
}
class AddMemberScreen2 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public AddMemberScreen2() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter phone number of new member: ");
		field = new JTextField(20);
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				dispose();
				new AddMemberScreen3();
				}		
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);		
	}
			
}
class AddMemberScreen3 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public AddMemberScreen3() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter address of new member: ");
		field = new JTextField(20);
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				dispose();
				new AddMemberScreen4();
				}		
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);		
	}
			
}
class AddMemberScreen4 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public AddMemberScreen4() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter city of new member: ");
		field = new JTextField(20);
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				dispose();
				new AddMemberScreen5();
				}		
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);		
	}
			
}
class AddMemberScreen5 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public AddMemberScreen5() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter state of new member: ");
		field = new JTextField(20);
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				dispose();
				new AddMemberScreen6();
				}		
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);		
	}
			
}
class AddMemberScreen6 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public AddMemberScreen6() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter ZIP of new member: ");
		field = new JTextField(20);
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				dispose();
				JOptionPane.showMessageDialog(AddMemberScreen6.this, "Member Added");
				}		
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);		
	}
			
}

class DeleteMemberScreen extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public DeleteMemberScreen() {
		super("Delete Member");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter member number of member to delete:");
		
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = field.getText();
				int mnum = Integer.parseInt(s);
				Member member = MemberFiles.searchMember(mnum);
				if(member != null) {
					dispose();
					JOptionPane.showMessageDialog(DeleteMemberScreen.this, "Member " + mnum + " Deleted.");
				}
				else {
					JOptionPane.showMessageDialog(DeleteMemberScreen.this, "ERROR: Member " + mnum + " Not Found.");
				}
			}
			
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);
		
	}
}

class UpdateMemberScreen extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public UpdateMemberScreen() {
		super("Update Member");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter member number of member to update:");
		
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = field.getText();
				int mnum = Integer.parseInt(s);
				Member member = MemberFiles.searchMember(mnum);
				if(member != null) {
					dispose();
					new UpdateMemberScreen2();
				}
				else {
					JOptionPane.showMessageDialog(UpdateMemberScreen.this, "ERROR: Member " + mnum + " Not Found.");
				}
			}
			
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);
	}
}

class UpdateMemberScreen2 extends JFrame {
	private JButton name, phone, address, city, state, zip;
	public UpdateMemberScreen2() {
		super("Update Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		name = new JButton("Member Name");
		name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == name) {
					dispose();
					new UpdateMemberScreen3();
					
				}
			}
		
		});
		phone = new JButton("Member Phone Number");
		phone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == phone) {
					dispose();
					new UpdateMemberScreen3();
					
				}
			}
		
		});
		address = new JButton("Member Address");
		address.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == address) {
					dispose();
					new UpdateMemberScreen3();
					
				}
			}
		
		});
		city = new JButton("Member City");
		city.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == city) {
					dispose();
					new UpdateMemberScreen3();
					
				}
			}
		
		});
		state = new JButton("Member State");
		state.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == state) {
					dispose();
					new UpdateMemberScreen3();
					
				}
			}
		
		});
		zip = new JButton("Member ZIP Code");
		zip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == zip) {
					dispose();
					new UpdateMemberScreen3();
					
				}
			}
		
		});
	}
}

class UpdateMemberScreen3 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public UpdateMemberScreen3() {
		super("Update Member");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter updated member information:");
		
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = field.getText();
				dispose();
				JOptionPane.showMessageDialog(UpdateMemberScreen3.this, "Member Information Updated.");
			}
			
		});
        JPanel panel = new JPanel(new FlowLayout());
        
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(b);
        
        add(panel);
        setVisible(true);
	}
}
