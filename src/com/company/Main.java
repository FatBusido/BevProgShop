package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  implements ActionListener {
    JFrame window;
    JButton Bpay,Breset,Bitem,Bitem2,Bitem3,Bitem4,Binfo;
    JTextField Jitem,Jitem2,Jitem3,Jitem4;
    JLabel JitemDB,Jitem2DB,Jitem3DB,Jitem4DB;
    JLabel Jcash;

    public static void main(String[] args) {
        new Main();

    }
    public Main()
    {
        createWindow();
        createButtons();
        JPanel panel = new JPanel();
        panel.setLayout(null);

        panel.add(Bpay);
        panel.add(Breset);
        panel.add(Bitem);
        panel.add(Bitem2);
        panel.add(Bitem3);
        panel.add(Bitem4);
        panel.add(Binfo);

        panel.add(Jcash);
        panel.add(JitemDB);
        panel.add(Jitem2DB);
        panel.add(Jitem3DB);
        panel.add(Jitem4DB);

        window.add(Jitem);
        window.add(Jitem2);
        window.add(Jitem3);
        window.add(Jitem4);

        window.add(panel);
        window.setVisible(true);
        Breset.addActionListener(this);
        Binfo.addActionListener(this);
        Bpay.addActionListener(this);

    }
    private void createWindow(){
        window=new JFrame("Shop");
        window.setSize(800,400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void createButtons(){
        Bpay=new JButton("Pay");
        Bpay.setBounds(680,305,100,50);
        Breset=new JButton("Reset");
        Breset.setBounds(10,10,100,50);
        Binfo=new JButton("Info");
        Binfo.setBounds(680,10,100,50);
        Jcash=new JLabel("1000 Ft");
        Jcash.setBounds(140,10,50,50);


        Bitem=new JButton("Alma");
        Jitem=new JTextField("0");
        JitemDB=new JLabel("30 DB");
        Jitem.setBounds(150,77,100,50);
        Bitem.setBounds(30,77,100,50);
        JitemDB.setBounds(300,77,100,50);

        Bitem2=new JButton("Ropi");
        Jitem2=new JTextField("0");
        Jitem2DB=new JLabel("30 DB");
        Jitem2.setBounds(150,135,100,50);
        Bitem2.setBounds(30,135,100,50);
        Jitem2DB.setBounds(300,135,100,50);

        Bitem3=new JButton("Csoki");
        Jitem3=new JTextField("0");
        Jitem3DB=new JLabel("30 DB");
       Jitem3.setBounds(150,190,100,50);
        Bitem3.setBounds(30,190,100,50);
        Jitem3DB.setBounds(300,190,100,50);

        Bitem4=new JButton("Sütik");
        Jitem4=new JTextField("0");
        Jitem4DB=new JLabel("30 DB");
        Jitem4.setBounds(150,245,100,50);
        Bitem4.setBounds(30,245,100,50);
        Jitem4DB.setBounds(300,245,100,50);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(Breset))
        {
            Jcash.setText("1000 Ft");
            JitemDB.setText("30 DB");
            Jitem2DB.setText("30 DB");
            Jitem3DB.setText("30 DB");
            Jitem4DB.setText("30 DB");
        }
        if(e.getSource().equals(Binfo))
        {
            JOptionPane.showMessageDialog(null,"Minden termék az egyszerüség kedvéért 100Ft ba kerül \n A textfieldek melletti labelben a raktárkészlet látható\n A sütin 2 őt fizet 3 mat kap akció van!\n");
        }
        if(e.getSource().equals(Bpay))
        {
            int item=Integer.parseInt(Jitem.getText());
            int itemDB=Integer.parseInt(JitemDB.getText());
            int item2=Integer.parseInt(Jitem2.getText());
            int item2DB=Integer.parseInt(Jitem2DB.getText());
            int item3=Integer.parseInt(Jitem3.getText());
            int item3DB=Integer.parseInt(Jitem3DB.getText());
            int item4=Integer.parseInt(Jitem4.getText());
            int item4DB=Integer.parseInt(Jitem4DB.getText());
            int penz=Integer.parseInt(Jcash.getText());
            int akcio=0;
            if(item4%3==0)
            { akcio=item4*100-((item4/3)*100);}
            else if (item4%3<0.5)
            { akcio=(item4/3*100)+100; }
            else{ akcio=(item4/3*100)+200; }

            int osszeg =(item+item2+item3+akcio);

            if((item >Integer.parseInt(JitemDB.getText()) || item2 >Integer.parseInt(Jitem2DB.getText())||
                    item3 >Integer.parseInt(Jitem3DB.getText()) || item4 >Integer.parseInt(Jitem4DB.getText())))
            {
                JOptionPane.showMessageDialog(null,"Nem lehet több terméket venni mint amennyi raktáron van");
            }
            else if(penz<osszeg)
            {
                JOptionPane.showMessageDialog(null,"Nem vásárolhatsz többért mint amennyi pénzed van");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Sikeresen fizettél: "+osszeg+"Ft ot!");
                JitemDB.setText(String.valueOf((itemDB-item)));
                Jitem2DB.setText(String.valueOf((item2DB-item2)));
                Jitem3DB.setText(String.valueOf((item3DB-item3)));
                Jitem4DB.setText(String.valueOf((item4DB-item4)));
            }
        }
    }
}
