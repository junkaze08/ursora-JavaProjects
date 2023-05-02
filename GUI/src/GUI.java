import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI{

	public static void main(String[] args) {
		new UserInput();
	}
}

class UserInput extends JFrame{
	
	String[] day = new String[31];
	String[] month = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
			"October", "November", "December"};
	String[] year = new String[50];
	private final JTextField lastName;
	private final JTextField firstName;
	private final JTextField middleName;
	private final JTextField address;
	private final JTextField place;
	private final JRadioButton male;
	private final JRadioButton female;
	private final JCheckBox fil;
	private final JCheckBox dual;
	private final JCheckBox bb;
	private final JCheckBox bn;
	private final JCheckBox single;
	private final JCheckBox widowed;
	private final JCheckBox other;
	private final JCheckBox married;
	private final JCheckBox separated;
	private final JComboBox dayBox, monthBox, yearBox;
	
	public UserInput() {

		JPanel panel = new JPanel();
		setSize(720, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setTitle("Personal Information Sheet");
		add(panel);
		
		panel.setLayout(null);

		JLabel label = new JLabel("Last Name");
		label.setBounds(10, 20, 75, 20);
		panel.add(label);
		
		lastName = new JTextField(20);
		lastName.setBounds(100, 20, 165, 20);
		panel.add(lastName);

		label = new JLabel("First Name");
		label.setBounds(10, 50, 75, 20);
		panel.add(label);
		
		firstName = new JTextField(25);
		firstName.setBounds(100, 50, 165, 20);
		panel.add(firstName);
		
		label = new JLabel("Middle Name");
		label.setBounds(10, 80, 75, 20);
		panel.add(label);
		
		middleName = new JTextField(20);
		middleName.setBounds(100, 80, 165, 20);
		panel.add(middleName);
		
		label = new JLabel("Address");
		label.setBounds(10, 110, 75, 20);
		panel.add(label);
		
		address = new JTextField(50);
		address.setBounds(100, 110, 165, 20);
		panel.add(address);

		label = new JLabel("Citizenship");
		label.setBounds(10, 155, 75, 20);
		panel.add(label);
		
		fil = new JCheckBox("Filipino");
		fil.setBounds(110, 155, 75, 20);
		panel.add(fil);
		
		dual = new JCheckBox("Dual Citizenship");
		dual.setBounds(190, 155, 165, 20);
		panel.add(dual);
		
		bb = new JCheckBox("by birth");
		bb.setBounds(200, 175, 75, 20);
		panel.add(bb);
		
		bn = new JCheckBox("by naturalization");
		bn.setBounds(290, 175, 165, 20);
		panel.add(bn);

		label = new JLabel("Birthdate");
		label.setBounds(350, 20, 75, 20);
		panel.add(label);
		
		int d = 1;
		for(int x = 0; x < day.length; x++) {
			day[x] = Integer.toString(d);
			d++;
		}
		
		dayBox = new JComboBox(day);
		dayBox.setBounds(440, 20, 50, 20);
		panel.add(dayBox);
		
		monthBox = new JComboBox(month);
		monthBox.setBounds(495, 20, 100, 20);
		panel.add(monthBox);
		
		int yr = 2000;
		for(int i = 0; i < year.length; i++) {
			year[i] = Integer.toString(yr);
			yr--;
		}
	
		
		yearBox = new JComboBox(year);
		yearBox.setBounds(600, 20, 75, 20);
		panel.add(yearBox);

		label = new JLabel("Place of Birth");
		label.setBounds(350, 50, 90, 20);
		panel.add(label);
		
		place = new JTextField(20);
		place.setBounds(460, 50, 165, 20);
		panel.add(place);
		
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		
		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(male);
		genderGroup.add(female);
		
		label = new JLabel("Gender");
		label.setBounds(350, 80, 75, 20);
		panel.add(label);

		male.setBounds(460, 80, 75, 20);
		panel.add(male);

		female.setBounds(540, 80, 75, 20);
		panel.add(female);
		
		label = new JLabel("Civil Status");
		label.setBounds(350, 110, 70, 20);
		panel.add(label);
		
		single = new JCheckBox("Single");
		single.setBounds(460, 110, 60, 20);
		panel.add(single);
		
		widowed = new JCheckBox("Widowed");
		widowed.setBounds(460, 130, 80, 20);
		panel.add(widowed);
		
		other = new JCheckBox("Other/s:");
		other.setBounds(460, 150, 75, 20);
		panel.add(other);

		married = new JCheckBox("Married");
		married.setBounds(550, 110, 80, 20);
		panel.add(married);

		separated = new JCheckBox("Separated");
		separated.setBounds(550, 130, 95, 20);
		panel.add(separated);

		JButton print = new JButton("Print");
		print.setBounds(200, 240, 80, 25);
		print.addActionListener(e -> {
			DisplayInfo display = new DisplayInfo();
			String lname = lastName.getText();
			String fname = firstName.getText();
			String mname = middleName.getText();
			String add = address.getText();
			String pob = place.getText();
			String day = (String)dayBox.getSelectedItem();
			String month = (String)monthBox.getSelectedItem();
			String year = (String)yearBox.getSelectedItem();

			if(fil.isSelected()) {
				display.cz.setText("Filipino");
			}

			if(dual.isSelected()) {

				if(bb.isSelected()) {
					display.cz.setText("Dual Citizenship by birth");
				} else if(bn.isSelected()) {
					display.cz.setText("Dual Citizenship by naturalization");
				} else {
					display.cz.setText("Dual Citizenship");
				}
			}

			if(male.isSelected()) {
				display.gender.setText("Male");
			}
			if(female.isSelected()) {
				display.gender.setText("Female");
			}

			if(single.isSelected()) {
				display.cs.setText("Single");
			} else if(widowed.isSelected()) {
				display.cs.setText("Widowed");
			} else if(other.isSelected()) {
				display.cs.setText("Other/s");
			} else if(married.isSelected()) {
				display.cs.setText("Married");
			} else if(separated.isSelected()) {
				display.cs.setText("Separated");
			}

			display.bdate.setText(month + " " + day + ", " + year);
			display.lname.setText(lname);
			display.fname.setText(fname);
			display.mname.setText(mname);
			display.address.setText(add);
			display.place.setText(pob);

			setVisible(false);
			dispose();
		});
		panel.add(print);

		JButton clear = new JButton("Clear");
		clear.setBounds(300, 240, 80, 25);
		clear.addActionListener(e -> {
			//Clear Text Fields

			lastName.setText("");
			firstName.setText("");
			middleName.setText("");
			address.setText("");
			place.setText("");

			//Clear Radio Buttons

			genderGroup.clearSelection();

			//Clear Check Boxes

			fil.setSelected(false);
			dual.setSelected(false);
			bb.setSelected(false);
			bn.setSelected(false);
			single.setSelected(false);
			widowed.setSelected(false);
			other.setSelected(false);
			married.setSelected(false);
			separated.setSelected(false);

			//Clear/Reset Combo Boxes

			dayBox.setSelectedIndex(0);
			monthBox.setSelectedIndex(0);
			yearBox.setSelectedIndex(0);

		});
		panel.add(clear);

		JButton exit = new JButton("Exit");
		exit.setBounds(400, 240, 80, 25);
		exit.addActionListener(e -> System.exit(0));
		panel.add(exit);		
		
		setVisible(true);
	}
}