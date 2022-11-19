/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Medcine.*;
import java.awt.BorderLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author AZA
 */
public class AllMedcines extends JFrame {
    JTable data;
    String[][] allMedcines;
    
    
    public AllMedcines(){
        String[] Columns={"id","version","titre","nom","prenom"};
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        JPanel Footer=new JPanel();
        //Header
        JLabel title=new JLabel("All Medcines");
        Header.add(title);
        //Body
        Body.setBounds(0,110,1000,550);
        allMedcines=new MedcinesDB().AllMedcines();
        data=new JTable(allMedcines,Columns);
        data.setRowHeight(60);
        data.setRowHeight(10,100);
        
        Body.add(data);
        //Footer
        
        add(Header,BorderLayout.NORTH);
        add(new JScrollPane(data),BorderLayout.CENTER);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("All Medcines");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
}
