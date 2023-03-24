package graphicsinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Operatii.Op;
import DataModel.Polinom;
public class ErrPattern {


    final int s=10;
    final int wb= 255;

    JPanel panel1 = new JPanel();
    JFrame frame = new JFrame();

    public ErrPattern(){
        frame.setSize(100,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);

        panel1.setBackground(new Color(	238	,248,253));
        panel1.setLayout(null);

        JLabel titlulabel = new JLabel("ERR");
       // titlulabel.setTextFill((255, 0, 0));
        titlulabel.setBounds(s, 20, 250, 25);
        panel1.add(titlulabel);
        panel1.setVisible(true);
        frame.setVisible(true);
    }

}

