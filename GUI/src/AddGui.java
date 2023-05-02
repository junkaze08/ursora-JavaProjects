import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddGui {
    public static void main(String[] args) {
        Addition obj = new Addition();
    }
}

class Addition extends JFrame{

    JTextField t1, t2;
    JButton b;
    JLabel l;
    public Addition(){
        t1 = new JTextField(20);
        t2 = new JTextField(20);

        b = new JButton("OK");
        l = new JLabel("Result");

        add(t1);
        add(t2);
        add(b);
        add(l);


        b.addActionListener(ae -> {
            int num1 = Integer.parseInt(t1.getText());
            int num2 = Integer.parseInt(t2.getText());

            int value = num1 + num2;
            l.setText(value + "");
        });

        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

}

