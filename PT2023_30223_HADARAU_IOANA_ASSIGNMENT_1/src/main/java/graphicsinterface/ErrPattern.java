package graphicsinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Operatii.Op;
import DataModel.Polinom;
public class ErrPattern implements ActionListener{

    JPanel panel1 = new JPanel();
    JFrame frame = new JFrame();
    JButton buton = new JButton("REIA ");
    public ErrPattern(){
       frame.setSize(100,100);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(panel1);

        panel1.setBackground(new Color(	238	,248,253));
       //panel1.setLayout(null);

        JLabel titlulabel = new JLabel("ERR");
       // titlulabel.setTextFill((255, 0, 0));
        titlulabel.setBounds(10, 20, 250, 25);
        buton .setBounds(10, 140, 10, 25);
        buton.addActionListener(this);
        buton.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b1= new Color(133	,200,	240);
        buton.setBackground(b1);

        panel1.add(buton);
        panel1.add(titlulabel);
        panel1.setVisible(true);
        frame.setVisible(true);
        }
        public void actionPerformed(ActionEvent e){
        if (e.getSource() ==buton) {
            Calculator c=new Calculator();
        }
    }

}

