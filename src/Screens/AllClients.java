/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import client.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 *
 * @author AZA
 */
public class AllClients extends JFrame {
    JTable data;
    String[][] allclients;
    
    
    public AllClients(){
        String[] Columns={"id","version","titre","nom","prenom"};
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        JPanel Footer=new JPanel();
        //Header
        JLabel title=new JLabel("All Clients");
        Header.add(title);
        //Body
        Body.setBounds(0,110,1000,550);
        allclients=new clientDB().AllClients();
        data=new JTable(allclients,Columns);
        data.setRowHeight(60);
        data.setRowHeight(10,100);
        
        Body.add(data);
        //Footer
        
        add(Header,BorderLayout.NORTH);
        add(new JScrollPane(data),BorderLayout.CENTER);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add an Client");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
}
