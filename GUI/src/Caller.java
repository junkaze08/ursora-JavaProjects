import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Caller {
    public static void main(String[] args) {
        X obj = new X();
    }
}
class X extends JFrame{
    public X(){
        JButton b = new JButton("ADD Form");
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Addition();
                dispose();
            }
        });

        add(b);
        setLayout(new FlowLayout());
        setVisible(true);
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}