package graphicsinterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Operatii.Op;
import DataModel.Polinom;
public class Calculator implements ActionListener {
    JFrame frame = new JFrame();

    final int s=10;
    final int wb= 255;

    JPanel panel1 = new JPanel();
    JButton addB = new JButton("Adunare");
    JButton difB = new JButton("Diferenta");
    JButton divB = new JButton("Impartire");
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
        titlulabel.setBounds(s, 20, 250, 25);
        panel1.add(titlulabel);

        //Polinomul 1
        JLabel p1 = new JLabel("Polinomul 1 ");
        p1.setBounds(s, 50, 80, 25);
        panel1.add(p1);

        p1Text.setBounds(100, 50, 165, 25);
        panel1.add(p1Text);

        //Polinomul 2
        JLabel p2 = new JLabel("Polinomul 2");
        p2.setBounds(10, 80, 100, 25);
        panel1.add(p2);

        p2Text.setBounds(100, 80, 165, 25);
        panel1.add(p2Text);

        //rezultat
        JLabel r = new JLabel("Rezultatul");
        r.setBounds(s, 110, 80, 25);
        panel1.add(r);

        rText.setBounds(100, 110, 165, 25);
        panel1.add(rText);


        //operatia de adunare
        addB .setBounds(s, 140, wb, 25);
        addB.addActionListener(this);
        addB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b1= new Color(133	,200,	240);
        addB.setBackground(b1);
        panel1.add(addB);

        //dif
        difB .setBounds(s, 170, wb, 25);
        difB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        difB.setBackground(b1);
        difB.addActionListener((ActionListener) this);
        panel1.add( difB);


        //boton-> impartire
        divB .setBounds(s, 200, wb, 25);
        divB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));

        Color b2= new Color(	157,	211,	243);
        divB.setBackground(b2);
        divB.addActionListener((ActionListener) this);
        panel1.add( divB);


        //buton _>inmultire
        mulB .setBounds(s,230, wb, 25);
        mulB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        mulB.setBackground(b2);
        mulB.addActionListener((ActionListener) this);
        panel1.add(mulB);

        //buton->Derivare
        derB.setBounds(s,260, wb, 25);
        derB.setFont(new java.awt.Font("Arial", Font.BOLD, 14));
        Color b3= new Color(		193	,227,	247);
        derB.setBackground(b3);
        derB.addActionListener(this);
        panel1.add(derB);

        //buton ->Integrare
        intB .setBounds(s,290, wb, 25);
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
        // System.out.println("Button clicked");
        if (e.getSource() == addB) {
            rText.setText( operatie.Adunare());
        }
        if (e.getSource() == difB) {
            rText.setText( operatie.Scadere());
        }
        /*if (e.getSource() == divB) {

        }
        if (e.getSource() == mulB) {

        }*/
        if (e.getSource() == derB) {
            rText.setText( operatie.Derivare());
        }
        if (e.getSource() == intB) {
            rText.setText( operatie.Integrare());
        }
    }
}
