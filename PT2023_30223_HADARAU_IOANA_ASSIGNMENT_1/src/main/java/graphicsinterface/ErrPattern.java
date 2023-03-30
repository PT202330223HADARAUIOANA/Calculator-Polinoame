package graphicsinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrPattern implements ActionListener{

    JPanel panel1 = new JPanel();
    JFrame frame = new JFrame();
    JButton buton = new JButton("REIA ");
    public ErrPattern(){
       frame.setSize(200,200);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel1.setBackground(new Color(	238	,248,253));
        panel1.setLayout(null);
        JLabel titlulabel = new JLabel("Sintaxa nu e corecta! ");
        titlulabel.setBounds(30, 60, 300, 30);
        panel1.add(titlulabel);

        JLabel textB= new JLabel("ERR");
       textB.setBounds(65, 45, 250, 25);
        panel1.add(textB);

        buton .setBounds(40, 90, 100, 25);
        buton.addActionListener(this);
        buton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b1= new Color(133	,200,	240);
        buton.setBackground(b1);

        panel1.add(buton);
        panel1.setVisible(true);
        frame.add(panel1);
        frame.setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
        if (e.getSource() ==buton) {
            Calculator c=new Calculator();
        }
    }

}

