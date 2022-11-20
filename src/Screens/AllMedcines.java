/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Medcine.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
        String[] Columns={"Number","Version","Title","Last Name","First Name"};
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
        
        
        //Footer
        JButton delete=new JButton("delete");
        JButton cancel=new JButton("cancel");
        Footer.add(delete);
        Footer.add(cancel);
        delete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                delete();
            }
            
        });
        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        
        });
        data.setBackground(Color.white);
        Header.setBackground(Color.white);
        Footer.setBackground(Color.white);
        add(Header,BorderLayout.NORTH);
        add(new JScrollPane(data),BorderLayout.CENTER);
        add(Footer,BorderLayout.SOUTH);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("All Medcines");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
    void delete(){
        try {
            MedcinesDB MDB=new MedcinesDB();
            MDB.deleteMedcine(MDB.MedcineById(Integer.parseInt(allMedcines[data.getSelectedRow()][0])));
            System.out.println(Integer.parseInt(allMedcines[data.getSelectedRow()][0])+"is deleted");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
