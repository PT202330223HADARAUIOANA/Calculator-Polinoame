package graphicsinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Operatii.Op;
import DataModel.Polinom;
public class Calculator implements ActionListener {
    JFrame frame = new JFrame();
    final int xs=10;
    final int dist=30;
    int y=20;
    int h=25;
    final int wb= 255;

    JPanel panel1 = new JPanel();
    JButton addB = new JButton("Adunare");
    JButton difB = new JButton("Diferenta");
    JButton mulB = new JButton("Inmultire");
    JButton derB = new JButton("Derivare");
    JButton intB = new JButton("Integrare");
    JTextField p1Text = new JTextField(20);
    JTextField p2Text = new JTextField(20);

    JTextField rText = new JTextField(20);

    public Calculator(){
        frame.setSize(290,360);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel1);
        panel1.setBackground(new Color(	238	,248,253));
        panel1.setLayout(null);

        JLabel titlulabel = new JLabel("Polinoame");
        titlulabel.setBounds(xs, y, 250, h);
        panel1.add(titlulabel);

        //Polinomul 1
        JLabel p1 = new JLabel("Polinomul 1 ");
        y=y+dist;
        p1.setBounds(xs, y, 80, h);
        panel1.add(p1);
        p1Text.setBounds(100, y, 165, 25);
        panel1.add(p1Text);

        //Polinomul 2
        JLabel p2 = new JLabel("Polinomul 2");
        y=y+dist;
        p2.setBounds(xs, y, 100, h);
        panel1.add(p2);
        p2Text.setBounds(100, y, 165, h);
        panel1.add(p2Text);

        //rezultat
        JLabel r = new JLabel("Rezultatul");
        y=y+dist;
        r.setBounds(xs, y, 80, h);
        panel1.add(r);
        rText.setBounds(100, y, 165, h);
        panel1.add(rText);


        //operatia de adunare
        y=y+dist+10;
        addB .setBounds(xs, y, wb, h);
        addB.addActionListener(this);
        addB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b1= new Color(133	,200,	240);
        addB.setBackground(b1);
        panel1.add(addB);

        //dif
        y=y+dist;
        difB .setBounds(xs, y, wb, h);
        difB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        difB.setBackground(b1);
        difB.addActionListener((ActionListener) this);
        panel1.add( difB);

        //buton _>inmultire
        y=y+dist;
        mulB .setBounds(xs,y, wb, h);
        mulB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b2= new Color(	157,	211,	243);
        mulB.setBackground(b2);
        mulB.addActionListener((ActionListener) this);
        panel1.add(mulB);

        //buton->Derivare
        y=y+dist;
        derB.setBounds(xs,y, wb, h);
        derB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b3= new Color(		193	,227,	247);
        derB.setBackground(b3);
        derB.addActionListener(this);
        panel1.add(derB);

        //buton ->Integrare
        y=y+dist;
        intB .setBounds(xs,y, wb, h);
        intB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        intB.setBackground(b3);
        intB.addActionListener(this);
        panel1.add(intB);
        panel1.setVisible(true);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        String s1 =p1Text.getText();
        String s2 =p2Text.getText();
        Polinom p1=new Polinom(s1);
        Polinom p2=new Polinom(s2);
        Op operatie=new Op(p1,p2);
        if (e.getSource() == addB) {
            rText.setText( operatie.Adunare());
        }
        if (e.getSource() == difB) {
            rText.setText( operatie.Scadere());
        }
        if (e.getSource() == mulB) {
            rText.setText( operatie.Inmultire());
        }
        if (e.getSource() == derB) {
            rText.setText( operatie.Derivare());
        }
        if (e.getSource() == intB) {
            rText.setText( operatie.Integrare());
        }
    }
}
