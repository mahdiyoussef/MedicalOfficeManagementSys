/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import client.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    String[] Columns={"id","version","titre","nom","prenom"};
    
    public AllClients(){
        
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
        //JButtons
        JButton delete=new JButton("delete");
        JButton cancel=new JButton("Cancel");
        Footer.add(delete);
        Footer.add(cancel);
        // add to ActionListener
        delete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteClient();
            }
        
        });
        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
        
        });
        // configuration
        Header.setBackground(Color.white);
        Body.setBackground(Color.white);
        Footer.setBackground(Color.white);
        add(Header,BorderLayout.NORTH);
        add(new JScrollPane(data),BorderLayout.CENTER);
        add(Footer,BorderLayout.SOUTH);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add an Client");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
    void deleteClient(){
        try {
            clientDB CDB=new clientDB();
        CDB.deleteClient(CDB.clientById(Integer.parseInt(allclients[data.getSelectedRow()][0])));
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
