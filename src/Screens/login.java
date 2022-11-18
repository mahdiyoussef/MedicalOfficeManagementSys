/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author AZA
 */
public class login extends JFrame {
    // logos
    
    // Login inputs 
    JTextField user;
    JPasswordField pwd;
    JLabel LoginMessage;
    // login button
    JButton login;
    public login(){
        URL Applogourl=getClass().getResource("/Assets/applogo.png");
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        JPanel Footer=new JPanel();
        JPanel Body_JTF1=new JPanel();
        JPanel Body_JTF2=new JPanel();
        JPanel Body_BTN=new JPanel();
        JLabel FooterLabel=new JLabel();
        FooterLabel.setText("Developed By : Youssef Mahdi");
        FooterLabel.setVerticalAlignment(JLabel.CENTER);
        FooterLabel.setHorizontalAlignment(JLabel.CENTER);
        //logo
        ImageIcon logoApp=new ImageIcon(Applogourl);
        // Fields pwd,user button,images
        user=new JTextField();
        user.setText("Username");
        pwd=new JPasswordField();
        pwd.setText("Password");
        pwd.setColumns(50);
        login=new JButton("Login");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        // JTF Sizes
        user.setMaximumSize(new Dimension(1000,30));
        pwd.setMaximumSize(new Dimension(1000,60));
        user.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
        pwd.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
        
        
        
        // logo insertion
        JLabel logolabel=new JLabel();
        logolabel.setIcon(logoApp);
        logolabel.setVerticalAlignment(JLabel.CENTER);
        logolabel.setHorizontalAlignment(JLabel.CENTER);
        
        
        //add items to JPanel
        Header.add(logolabel);
        //Body_JTF1.add(user);
        //Body_JTF2.add(pwd);
        //Body_BTN.add(login);
        Body_JTF1.setLayout(new BoxLayout(Body_JTF1, BoxLayout.Y_AXIS));
        //Body_JTF1.add(user);
        //Body_JTF2.add(pwd);
        //Body_BTN.add(login);
        //Body_JTF1.setSize(JPanel.WIDTH,40);
        Body_JTF1.add(user);
        Body_JTF1.add(pwd);
        Body_JTF1.add(login);
        Body_JTF1.setBackground(new Color(255,255,255));
        Body.add(Body_JTF1,BorderLayout.EAST);
        Footer.add(FooterLabel);
        
        
        Body.setBackground(new Color(255,255,255));
        Footer.setBackground(new Color(255,255,255));
        Header.setBackground(new Color(255,255,255));
        add(Header,BorderLayout.NORTH);
        add(Body,BorderLayout.CENTER);
        add(Footer,BorderLayout.SOUTH);
        setSize(1280,720);
        //add Items to Jpanel
        getContentPane().setBackground(new Color(255,255,255));
        setTitle("Medical Office Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
}
