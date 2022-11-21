/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import login.loginDB;

/**
 *
 * @author AZA
 */
public class Loginscreen extends JFrame {
    // logos
    
    // Login inputs 
    JTextField user;
    JPasswordField pwd;
    JLabel LoginMessage;
    // login button
    JButton login;
    JLabel msg;
    public Loginscreen(){
        URL Applogourl=getClass().getResource("/Assets/applogo.png");
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        JPanel Footer=new JPanel();
        JLabel FooterLabel=new JLabel();
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
        user.setMaximumSize(new Dimension(1000,60));
        pwd.setMaximumSize(new Dimension(1000,60));
        user.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
        pwd.setHorizontalAlignment((int) JPanel.CENTER_ALIGNMENT);
        login.setPreferredSize(new Dimension(1000,60));
        msg=new JLabel("");
        
        // logo insertion
        JLabel logolabel=new JLabel();
        logolabel.setIcon(logoApp);
        logolabel.setVerticalAlignment(JLabel.CENTER);
        logolabel.setHorizontalAlignment(JLabel.CENTER);
        
        
        //add items to JPanel footer ,Body
        Header.add(logolabel);
        Body.setLayout(new BoxLayout(Body, BoxLayout.Y_AXIS));
        Body.add(user);
        Body.add(pwd);
        Body.add(msg);
        Body.setBackground(new Color(255,255,255));
        
        Footer.add(login);
        
        // add button to Actio listener
        login.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                loginVerify();
            }
            
        });
        
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
    void loginVerify(){
        loginDB logv=new loginDB();
        try {
            if(logv.checkLogin(user.getText(), pwd.getText())){
                new Dashboard();
                this.dispose();
            }
            else{
                msg.setText("unknown infos");
            }
        } catch (Exception e) {
            
        }
    }
}
