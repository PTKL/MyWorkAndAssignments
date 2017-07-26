package mygui;
 
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
 
 
public class FirstFrame {
 
    public static void main(String[] args) {
         
        JFrame myframe = new JFrame("my frame title");
        myframe.setVisible(true);
        myframe.setSize(300,200);
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        JMenuBar mymenu = new JMenuBar();
        mymenu.setOpaque(true);
        mymenu.setBackground(new Color(154, 165, 127));
        mymenu.setPreferredSize(new Dimension(300,20));
        myframe.setJMenuBar(mymenu);
         
        JPanel mypanel = new JPanel();
        JLabel label = new JLabel("my label");
        JButton mybutton = new JButton("New Window");
        JButton exitbutton = new JButton("Exit");
         
        myframe.add(mypanel);
        mypanel.add(label);
        mypanel.add(mybutton);
        mybutton.addActionListener(new Thing());
        mypanel.add(exitbutton);
        exitbutton.addActionListener(new Quit()); //Quite first jframe
         
         
}
         
    static class Thing implements ActionListener {
         
        public void actionPerformed (ActionEvent e) {
            JFrame myframeB = new JFrame("frame number 2");
            myframeB.setVisible(true);
            myframeB.setSize(400,150);
            JPanel mypanelB = new JPanel();
            JLabel mylabelB = new JLabel("hi there");
            JButton exitbutton2 = new JButton("Quit");
            myframeB.add(mypanelB);
            mypanelB.add(mylabelB);
            mypanelB.add(exitbutton2);
            exitbutton2.addActionListener(Quit); //this ActionListener does not let me quit the second jframe.???
        }
    }
 
    static class Quit implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            System.exit(0);
             
        }
    }
}
