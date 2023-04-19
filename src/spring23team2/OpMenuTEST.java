package spring23team2;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class OpMenuTEST extends JFrame{
	private JButton amb, dmb, umb, apb, dpb, upb, quitb;
	public OpMenuTEST() {
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
        new OpMenuTEST(); //opens Manager Menu
        ProviderFiles.loadProviderMap();
        MemberFiles.loadMemberMap();
        ProviderFiles.save();
        MemberFiles.save();
	}
}

class AddMemberScreen1 extends JFrame{
	private JLabel label, label1,label2,label3,label4,label5;
	private JTextField field, field1, field2,field3,field4,field5;
	private JButton b;
	public AddMemberScreen1() {
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
		label5 = new JLabel("Enter zip: ");
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
				dispose();
				JOptionPane.showMessageDialog(AddMemberScreen1.this, "Done");
				MainMenu.main(null);
			}
		});
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(label); //adds label, text field, and button to screen
		panel.add(field);
		panel.add(label1); //adds label, text field, and button to screen
		panel.add(field1);
		panel.add(label2); //adds label, text field, and button to screen
		panel.add(field2);
		panel.add(label3); //adds label, text field, and button to screen
		panel.add(field3);
		panel.add(label4); //adds label, text field, and button to screen
 		panel.add(field4);
 		panel.add(label5); //adds label, text field, and button to screen
 		panel.add(field5);
 		panel.add(b);
 		add(panel);
 		setVisible(true);
		}
	}