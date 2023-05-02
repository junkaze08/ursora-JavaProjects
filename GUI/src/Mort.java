import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Mort {
    public static void main(String[] args) {
        MainFrame obj = new MainFrame();
    }
    static class MainFrame extends JFrame {
        public MainFrame(){
        JPanel topPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        JPanel tempPanel;
    
        JLabel l1 = new JLabel("Last Name");
        JLabel l2 = new JLabel("First Name");
        JLabel l3 = new JLabel("Middle Name");
        JLabel l4 = new JLabel("Citizenship");
        JLabel l5 = new JLabel("Address");
        JLabel l6 = new JLabel("Birthdate");
        String date[]={"1","2","4","5","6","7","8","9","10","11","12","13","14","15"
                ,"16","17","18","19","20","21","22","23","24","25","26","27",
                "28","29","30","31",};
        String Month[]={"January","February","March","April","May","June","July","August","September","October","November","December",};
        String[] Year ={"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014"};

        JLabel l7 = new JLabel("Place of Birth");
        JLabel l8 = new JLabel("Gender");
        JLabel l10 = new JLabel("                   ");
        JLabel l11 = new JLabel("                          ");
        JLabel l9 = new JLabel("Civil Status");
        JRadioButton b1= new JRadioButton("Male");
        JRadioButton b2= new JRadioButton("Female");
            ButtonGroup bgr = new ButtonGroup();
            bgr.add(b1);
            bgr.add(b2);
        JCheckBox c1 = new JCheckBox("Filipino");
        JCheckBox c2 = new JCheckBox("Dual Citizenship");
        JCheckBox c3 = new JCheckBox("by birth");
        JCheckBox c4 = new JCheckBox("by naturalization");
        JCheckBox c5 = new JCheckBox("Single");
        JCheckBox c6 = new JCheckBox("Married");
        JCheckBox c7 = new JCheckBox("Widowed");
        JCheckBox c8 = new JCheckBox("Separated");
        JCheckBox c9 = new JCheckBox("Other/s:");
        JButton print = new JButton("PRINT");
        JButton clear = new JButton("CLEAR");
        JButton exit = new JButton("EXIT");


            exit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });

            clear.addActionListener(e -> {            });

            print.addActionListener(e -> {
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setResizable(false);
                setLocationRelativeTo(null);
            });


        gc.anchor = GridBagConstraints.LINE_START;

        // Top
        // 0 Column
        gc.gridx = 0;

        gc.gridy = 0;
        topPanel.add((l1), gc);

        gc.gridy = 1;
        topPanel.add((l2), gc);

        gc.gridy = 2;
        topPanel.add((l3), gc);

        gc.gridy = 3;
        topPanel.add((l4), gc);

        gc.gridy = 4;

        gc.gridy = 5;
        topPanel.add((l5), gc);

        gc.gridwidth = 1;
        gc.anchor = GridBagConstraints.LINE_START;

        // 1 Column
        gc.gridx = 1;

        gc.gridy = 0;
        tempPanel = new JPanel();
        tempPanel.add(new JTextField(15));
        tempPanel.add((l6), gc);
        tempPanel.add(new JComboBox(date));
        tempPanel.add(new JComboBox(Month));
        tempPanel.add(new JComboBox(Year));
        topPanel.add(tempPanel, gc);

        gc.gridy = 1;
        tempPanel = new JPanel();
        tempPanel.add(new JTextField(15));
        tempPanel.add((l7), gc);
        tempPanel.add(new JTextField(15));
        topPanel.add(tempPanel, gc);

        gc.gridy = 2;
        tempPanel = new JPanel();
        tempPanel.add(new JTextField(15));
        tempPanel.add((l8), gc);
        tempPanel.add((b1), gc);
        tempPanel.add((b2), gc);
        topPanel.add(tempPanel, gc);

        gc.gridy = 3;
        tempPanel = new JPanel();
        tempPanel.add((c1), gc);
        tempPanel.add(c2, gc);
        tempPanel.add((l9), gc);
        tempPanel.add((c5), gc);
        tempPanel.add((c6), gc);
        topPanel.add(tempPanel, gc);

        gc.gridy = 4;
        tempPanel = new JPanel();
        tempPanel.add((c3), gc);
        tempPanel.add((c4), gc);
        tempPanel.add((l10), gc);
        tempPanel.add((c7), gc);
        tempPanel.add((c8), gc);
        topPanel.add(tempPanel, gc);

        gc.gridy = 5;
        tempPanel = new JPanel();
        tempPanel.add(new JTextField(15));
        tempPanel.add((l11), gc);
        tempPanel.add((c9), gc);
        topPanel.add(tempPanel, gc);


        JPanel bottomPanel = new JPanel();
        bottomPanel.add((print), gc);
        bottomPanel.add((clear), gc);
        bottomPanel.add((exit), gc);

        // Main
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.add(new JLabel("Personal Information Sheet"));
        mainPanel.add(new JSeparator());
        mainPanel.add(topPanel);
        mainPanel.add(new JSeparator());
        mainPanel.add(bottomPanel);

        getContentPane().add(mainPanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        pack();
        setVisible(true);
    }
    static class Window{

    }
}
}