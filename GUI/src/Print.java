import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Print{

	public static void main(String args[]) {
		DisplayInfo display = new DisplayInfo();
	}
	
}

class DisplayInfo extends JFrame implements ActionListener{

	JButton back, exit;
	JLabel label, lname, fname, mname, address, place, cz, gender, cs, bdate;
	JPanel panel;
	
	public DisplayInfo() {
		
		panel = new JPanel();
		setSize(720, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Personal Information Sheet - PRINT");
		add(panel);
		
		panel.setLayout(null);
		
		label = new JLabel("Last Name:");
		label.setBounds(10, 20, 75, 20);
		panel.add(label);
		
		lname = new JLabel("");
		lname.setBounds(100, 20, 165, 20);
		panel.add(lname);
		
		label = new JLabel("First Name:");
		label.setBounds(10, 50, 75, 20);
		panel.add(label);
		
		fname = new JLabel("");
		fname.setBounds(100, 50, 165, 20);
		panel.add(fname);
		
		label = new JLabel("Middle Name:");
		label.setBounds(10, 80, 95, 20);
		panel.add(label);
		
		mname = new JLabel("");
		mname.setBounds(100, 80, 165, 20);
		panel.add(mname);
		
		label = new JLabel("Address:");
		label.setBounds(10, 110, 95, 20);
		panel.add(label);
		
		address = new JLabel("");
		address.setBounds(100, 110, 165, 20);
		panel.add(address);
		
		label = new JLabel("Citizenship:");
		label.setBounds(10, 155, 95, 20);
		panel.add(label);
		
		cz = new JLabel("");
		cz.setBounds(100, 155, 190, 20);
		panel.add(cz);
		
		label = new JLabel("Birthdate");
		label.setBounds(350, 20, 75, 20);
		panel.add(label);
		
		bdate = new JLabel("");
		bdate.setBounds(460, 20, 200, 20);
		panel.add(bdate);
		
		label = new JLabel("Place of Birth:");
		label.setBounds(350, 50, 90, 20);
		panel.add(label);
		
		place = new JLabel("");
		place.setBounds(460, 50, 165, 20);
		panel.add(place);
		
		label = new JLabel("Gender");
		label.setBounds(350, 80, 75, 20);
		panel.add(label);
		
		gender = new JLabel("");
		gender.setBounds(460, 80, 165, 20);
		panel.add(gender);
		
		label = new JLabel("Civil Status");
		label.setBounds(350, 110, 70, 20);
		panel.add(label);
		
		cs = new JLabel("");
		cs.setBounds(460, 110, 100, 20);
		panel.add(cs);
		
		back = new JButton("Back");
		back.setBounds(200, 240, 80, 25);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserInput();
				setVisible(false);
				dispose();
			}
		});
		panel.add(back);
		
		exit = new JButton("Exit");
		exit.setBounds(400, 240, 80, 25);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel.add(exit);
		
		setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}