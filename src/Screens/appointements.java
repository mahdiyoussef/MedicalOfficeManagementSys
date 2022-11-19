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
import rv.rvDB;

/**
 *
 * @author AZA
 */
public class appointements extends JFrame {
    String[][] dataappo=new rvDB().fullAppointement();
    String[][] emptydata={{" "," "," "," "," "," "," ",""}};
    JTable data;
    public appointements(){
        String[] columns ={"Number", "Date", "H-Debut", "H-Fin", "M-Debut", "M-Fin", "client", "medcine"};
        
        //JPanels
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        
        // Header
        JLabel Title=new JLabel("Appointements");
        Title.setHorizontalAlignment(JLabel.CENTER);
        Header.add(Title);
        Header.setBackground(Color.WHITE);
        // Body
        if(dataappo!=null){
            data=new JTable(new rvDB().fullAppointement(),columns);
            Body.add(data);
        }
        else{
            data=new JTable(emptydata,columns);
            Body.add(data);
        }
        Body.setBackground(Color.WHITE);
        // JFrame configuration
        add(Header,BorderLayout.NORTH);
        add(Body,BorderLayout.CENTER);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add an Appointement");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
}
