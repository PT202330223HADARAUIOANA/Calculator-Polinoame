package graphicsinterface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JButton button1;
    private JPanel panel1;
    public Calculator(){
        JFrame frame=new JFrame("calculator");
        frame.setSize(400,400);
        frame.getContentPane().add(panel1);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
