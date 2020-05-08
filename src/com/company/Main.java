package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {
    JFrame window;
    JButton Bpay,Breset,Bitem,Bitem2,Bitem3,Bitem4;
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
        window.add(panel);
        window.setVisible(true);

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

        Bitem=new JButton("Item1");
        Bitem.setBounds(30,77,100,50);
        Bitem2=new JButton("Item2");
        Bitem2.setBounds(30,135,100,50);
        Bitem3=new JButton("Item3");
        Bitem3.setBounds(30,190,100,50);
        Bitem4=new JButton("Item4");
        Bitem4.setBounds(30,245,100,50);

    }
}
