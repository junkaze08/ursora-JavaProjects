import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.concurrent.Flow;

import static javax.swing.GroupLayout.Alignment.*;

public class PersonalInformationSheet {
    public static void main(String[] args) {
        JFrame frame= new JFrame("PIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = frame.getContentPane();
        GroupLayout groupLayout = new GroupLayout(contentPanel);
        groupLayout.setAutoCreateGaps(true);
        groupLayout.setAutoCreateContainerGaps(true);
        contentPanel.setLayout(groupLayout);
        frame.pack();
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setSize(550, 400);

        JLabel lay = new JLabel("Personal Information Sheet");
        JLabel bd = new JLabel("Birth Date");
        JLabel pb = new JLabel("Place of Birth");
        JRadioButton r1 = new JRadioButton("Male");
        JRadioButton r2 = new JRadioButton("Female");
        JLabel gen = new JLabel("Gender");
        JTextField pbl = new JTextField(15);
        JLabel l1 = new JLabel("Last Name");
        JTextField t1 = new JTextField(15);
        JLabel l2 = new JLabel("First Name");
        JTextField t2 = new JTextField(15);
        JLabel l3 = new JLabel("Middle Name");
        JTextField t3 = new JTextField(15);
        JLabel l4 = new JLabel("Address");
        JTextField t4 = new JTextField(15);
        JLabel l5 = new JLabel("Citizenship");
        JCheckBox c1 = new JCheckBox("Filipino");
        JCheckBox c2 = new JCheckBox("Dual Citizenship");
        JCheckBox c3 = new JCheckBox("by birth");
        JCheckBox c4 = new JCheckBox("by naturalization");


            frame.add(l1, BorderLayout.NORTH);
            frame.add(t1, BorderLayout.NORTH);

        frame.add(bd);
        String date[]={"1","2","4","5","6","7","8","9","10","11","12","13","14","15"
                      ,"16","17","18","19","20","21","22","23","24","25","26","27",
                       "28","29","30","31",};
        String Month[]={"January","February","March","April","May","June","July","August","September","October","November","December",};
        String[] Year ={"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};
        JComboBox d=new JComboBox(date);
        JComboBox m=new JComboBox(Month);
        JComboBox y=new JComboBox(Year);
        d.setBounds(50, 50,90,20);
        m.setBounds(50, 50,90,20);
        y.setBounds(50, 50,90,20);
        frame.add(d);
        frame.add(m);
        frame.add(y);

            frame.add(l2);
            frame.add(t2);

        frame.add(pb);
        frame.add(pbl);

        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
                                .addGroup(groupLayout.createParallelGroup(LEADING).addComponent(l3)
                                        .addGroup(groupLayout.createParallelGroup(TRAILING).addComponent(t3))));

        frame.add(gen);
        frame.add(r1);
        frame.add(r2);



    }
}
