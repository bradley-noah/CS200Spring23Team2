package spring23team2;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
/**
 * @author Billal Amer
 * @version 2.0
 * Operator Menu GUI for adding, deleting, and updating providers and members
 * in the ChocAn system.
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
					new AddMemberScreen();
					
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
					new AddProviderScreen();
				}
			}
		
		});
		
		dpb = new JButton("Delete Provider");
		dpb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == dpb) {
					dispose();
					new DeleteProviderScreen();
				}
			}
		
		});
		
		upb = new JButton("Update Provider");
		upb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == upb) {
					dispose();
					new UpdateProviderScreen();
					
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
    	MemberFiles.loadMemberMap();
    	ProviderFiles.loadProviderMap();
        new OperatorMenu(); //opens Operator Menu
        ProviderFiles.save();
        MemberFiles.save();
	}
  
}
class AddMemberScreen extends JFrame {
	private JLabel label, label1,label2,label3,label4,label5;
	private JTextField field, field1, field2,field3,field4,field5;
	private JButton b;
	public AddMemberScreen() {
		super("Add Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter name of new member: ");
		field = new JTextField(20);
		label4 = new JLabel("Enter new member number: ");
		field4 = new JTextField(20);
		label1 = new JLabel("Enter address of new member: ");
		field1 = new JTextField(20);
		label2 = new JLabel("Enter city of new member: ");
		field2 = new JTextField(20);
		label3 = new JLabel("Enter state of new member: ");
		field3 = new JTextField(20);
		label5 = new JLabel("Enter ZIP code of new member: ");
		field5 = new JTextField(20);
		
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();				
				String address = field1.getText();
				String city = field2.getText();
				String state = field3.getText();
				int number = Integer.parseInt(field4.getText());
				int zip = Integer.parseInt(field5.getText());
				MemberFiles.insertMember(name, number, address, city, state, zip);
				MemberFiles.save();
				dispose();
				JOptionPane.showMessageDialog(AddMemberScreen.this, "New member created.");
				MainMenu.main(null);
			}
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(label1);        //adds label, text field, and button to screen
        panel.add(field1);
        panel.add(label2);        //adds label, text field, and button to screen
        panel.add(field2);
        panel.add(label3);        //adds label, text field, and button to screen
        panel.add(field3);
        panel.add(label4);        //adds label, text field, and button to screen
        panel.add(field4);
        panel.add(label5);        //adds label, text field, and button to screen
        panel.add(field5);
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
					MemberFiles.removeMember(mnum);
					MemberFiles.save();
					dispose();
					JOptionPane.showMessageDialog(DeleteMemberScreen.this, "Member " + mnum + " Deleted.");
					MainMenu.main(null);
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
					new UpdateMemberScreen2(mnum);
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
	private JButton name,address, city, state, zip;
	private JLabel label;
	public UpdateMemberScreen2(final int mnum) {
		super("Update Member");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Select a field to update.");
		name = new JButton("Member Name");
		name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == name) {
					dispose();
					new UpdateMemberScreen3(mnum, 1);
					
				}
			}
		
		});
		address = new JButton("Member Address");
		address.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == address) {
					dispose();
					new UpdateMemberScreen3(mnum, 2);
					
				}
			}
		
		});
		city = new JButton("Member City");
		city.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == city) {
					dispose();
					new UpdateMemberScreen3(mnum, 3);
					
				}
			}
		
		});
		state = new JButton("Member State");
		state.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == state) {
					dispose();
					new UpdateMemberScreen3(mnum, 4);
					
				}
			}
		
		});
		zip = new JButton("Member ZIP Code");
		zip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == zip) {
					dispose();
					new UpdateMemberScreen3(mnum, 5);
					
				}
			}
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(name);
        panel.add(address);
        panel.add(city);
        panel.add(state);
        panel.add(zip);
        add(panel);
        setVisible(true);
	}
}
class UpdateMemberScreen3 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public UpdateMemberScreen3(final int mnum, final int info) {
		super("Update Member");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Enter updated member information:");
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Member member = MemberFiles.searchMember(mnum);
				String name = member.getName();				
				String address = member.getAddress();
				String city = member.getCity();
				String state = member.getState();
				int zip = member.getZip();
				int number = member.getMemberNumber();
				String s = field.getText();
				if (info == 1) {
					MemberFiles.removeMember(number);
					MemberFiles.insertMember(s, number, address, city, state, zip);
					MemberFiles.save();
				}
				if (info == 2) {
					MemberFiles.removeMember(number);
					MemberFiles.insertMember(name, number, s, city, state, zip);
					MemberFiles.save();
				}
				if (info == 3) {
					MemberFiles.removeMember(number);
					MemberFiles.insertMember(name, number, address, s, state, zip);
					MemberFiles.save();
				}
				if (info == 4) {
					MemberFiles.removeMember(number);
					MemberFiles.insertMember(name, number, address, city, s, zip);
					MemberFiles.save();
				}
				if (info == 5) {
					int zipcode = Integer.parseInt(s);
					MemberFiles.removeMember(number);
					MemberFiles.insertMember(name, number, address, city, state, zipcode);
					MemberFiles.save();
				}
				dispose();
				JOptionPane.showMessageDialog(UpdateMemberScreen3.this, "Member Information Updated.");
				MainMenu.main(null);
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
class AddProviderScreen extends JFrame {
	private JLabel label, label1,label2,label3,label4,label5;
	private JTextField field, field1, field2,field3,field4,field5;
	private JButton b;
	public AddProviderScreen() {
		super("Add Provider");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter name of new provider: ");
		field = new JTextField(20);
		label4 = new JLabel("Enter new provider number: ");
		field4 = new JTextField(20);
		label1 = new JLabel("Enter address of new provider: ");
		field1 = new JTextField(20);
		label2 = new JLabel("Enter city of new provider: ");
		field2 = new JTextField(20);
		label3 = new JLabel("Enter state of new provider: ");
		field3 = new JTextField(20);
		label5 = new JLabel("Enter ZIP code of new provider: ");
		field5 = new JTextField(20);
		
		b = new JButton("Confirm");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = field.getText();
				String address = field1.getText();
				String city = field2.getText();
				String state = field3.getText();
				int number = Integer.parseInt(field4.getText());
				int zip = Integer.parseInt(field5.getText());
				ProviderFiles.insertProvider(name, number, address, city, state, zip);
				ProviderFiles.save();
				dispose();
				JOptionPane.showMessageDialog(AddProviderScreen.this, "New provider created.");
				MainMenu.main(null);
			}
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(field);
        panel.add(label1);        //adds label, text field, and button to screen
        panel.add(field1);
        panel.add(label2);        //adds label, text field, and button to screen
        panel.add(field2);
        panel.add(label3);        //adds label, text field, and button to screen
        panel.add(field3);
        panel.add(label4);        //adds label, text field, and button to screen
        panel.add(field4);
        panel.add(label5);        //adds label, text field, and button to screen
        panel.add(field5);
        panel.add(b);
        add(panel);
        setVisible(true);		
	}
			
}
class DeleteProviderScreen extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public DeleteProviderScreen() {
		super("Delete provider");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter member number of provider to delete:");
		
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = field.getText();
				int pnum = Integer.parseInt(s);
				Provider provider = ProviderFiles.searchProvider(pnum);
				if(provider != null) {
					ProviderFiles.removeProvider(pnum);
					ProviderFiles.save();
					dispose();
					JOptionPane.showMessageDialog(DeleteProviderScreen.this, "Provider " + pnum + " Deleted.");
					MainMenu.main(null);
				}
				else {
					JOptionPane.showMessageDialog(DeleteProviderScreen.this, "ERROR: Provider " + pnum + " Not Found.");
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
class UpdateProviderScreen extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public UpdateProviderScreen() {
		super("Update Provider");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Enter provider number of provider to update:");
		
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = field.getText();
				int pnum = Integer.parseInt(s);
				Provider provider = ProviderFiles.searchProvider(pnum);
				if(provider != null) {
					dispose();
					new UpdateProviderScreen2(pnum);
				}
				else {
					JOptionPane.showMessageDialog(UpdateProviderScreen.this, "ERROR: Member " + pnum + " Not Found.");
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
class UpdateProviderScreen2 extends JFrame {
	private JButton name,address, city, state, zip;
	private JLabel label;
	public UpdateProviderScreen2(final int pnum) {
		super("Update Provider");
		setSize(300,200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		label = new JLabel("Select a field to update.");
		name = new JButton("Provider Name");
		name.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == name) {
					dispose();
					new UpdateProviderScreen3(pnum, 1);
					
				}
			}
		
		});
		address = new JButton("Provider Address");
		address.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == address) {
					dispose();
					new UpdateProviderScreen3(pnum, 2);
					
				}
			}
		
		});
		city = new JButton("Provider City");
		city.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == city) {
					dispose();
					new UpdateProviderScreen3(pnum, 3);
					
				}
			}
		
		});
		state = new JButton("Provider State");
		state.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == state) {
					dispose();
					new UpdateProviderScreen3(pnum, 4);
					
				}
			}
		
		});
		zip = new JButton("Provider ZIP Code");
		zip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == zip) {
					dispose();
					new UpdateProviderScreen3(pnum, 5);
					
				}
			}
		
		});
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(label);        //adds label, text field, and button to screen
        panel.add(name);
        panel.add(address);
        panel.add(city);
        panel.add(state);
        panel.add(zip);
        add(panel);
        setVisible(true);
	}
}
class UpdateProviderScreen3 extends JFrame {
	private JLabel label;
	private JTextField field;
	private JButton b;
	public UpdateProviderScreen3(final int mnum, final int info) {
		super("Update Provider");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		label = new JLabel("Enter updated Provider information:");
		field = new JTextField(16);
		b = new JButton("Enter");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Provider provider = ProviderFiles.searchProvider(mnum);
				String name = provider.getName();				
				String address = provider.getAddress();
				String city = provider.getCity();
				String state = provider.getState();
				int zip = provider.getZip();
				int number = provider.getProviderNumber();
				String s = field.getText();
				if (info == 1) {
					ProviderFiles.removeProvider(number);
					ProviderFiles.insertProvider(s, number, address, city, state, zip);
					ProviderFiles.save();
				}
				if (info == 2) {
					ProviderFiles.removeProvider(number);
					ProviderFiles.insertProvider(name, number, s, city, state, zip);
					ProviderFiles.save();
				}
				if (info == 3) {
					ProviderFiles.removeProvider(number);
					ProviderFiles.insertProvider(name, number, address, s, state, zip);
					ProviderFiles.save();
				}
				if (info == 4) {
					ProviderFiles.removeProvider(number);
					ProviderFiles.insertProvider(name, number, address, city, s, zip);
					ProviderFiles.save();
				}
				if (info == 5) {
					int zipcode = Integer.parseInt(s);
					ProviderFiles.removeProvider(number);
					ProviderFiles.insertProvider(name, number, address, city, state, zipcode);
					ProviderFiles.save();
				}
				dispose();
				JOptionPane.showMessageDialog(UpdateProviderScreen3.this, "Provider Information Updated.");
				MainMenu.main(null);
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
