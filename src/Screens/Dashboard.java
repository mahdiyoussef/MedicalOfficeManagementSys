/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;
import javax.swing.*;

/**
 *
 * @author AZA
 */
public class Dashboard extends JFrame{
    public Dashboard(){
        URL Applogourl=getClass().getResource("/Assets/applogo.png");
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        ImageIcon logoApp=new ImageIcon(Applogourl);
        // add to JPanels
        JLabel logolabel=new JLabel();
        logolabel.setIcon(logoApp);
        Header.add(logolabel);
        
        //config
        Header.setBackground(Color.white);
        Body.setBackground(Color.white);
        add(Header,BorderLayout.NORTH);
        add(Body);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dashbord");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
}
