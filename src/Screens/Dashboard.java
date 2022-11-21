/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

import Medcine.MedcinesDB;
import client.clientDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.*;
import rv.rvDB;

/**
 *
 * @author AZA
 */
public class Dashboard extends JFrame{
    String[] clientop={"Client","Add Client","All Clients"};
    String[] appoint={"Appointement","Add Appointement","All Appointements"};
    String[] medcinop={"Medcine","Add Medcine","All Medcines"};
    JComboBox cl,app,md;
    public Dashboard(){
        int nc=new clientDB().numberOfClients();
        int nap=new rvDB().rvNumber();
        int nmd=new MedcinesDB().numberOfMedcines();
        URL Applogourl=getClass().getResource("/Assets/applogo.png");
        URL bccimage=getClass().getResource("/Assets/7622908.png");
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        ImageIcon logoApp=new ImageIcon(Applogourl);
        // add to JPanels
        JLabel logolabel=new JLabel();
        logolabel.setIcon(logoApp);
        Header.add(logolabel);
        cl=new JComboBox(clientop);
        md=new JComboBox(medcinop);
        app=new JComboBox(appoint);
        Header.add(cl);
        Header.add(md);
        Header.add(app);
        JLabel Image=new JLabel();
        Image.setIcon(new ImageIcon(bccimage));
        Body.add(Image);
        
        // add JComboBoxes to Action Listener
        cl.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                clientNav();
            }
            
        });
        md.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                medcineNav();
            }
            
        });
        app.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                appointNav();
            }
            
        });
        //config
        Header.setBackground(Color.white);
        Body.setBackground(Color.white);
        add(Header,BorderLayout.NORTH);
        add(Body);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Dashboard");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
    void clientNav(){
        switch(cl.getSelectedIndex()){
            case 1:new addClient();break;
            case 2:new AllClients();break;
        }
    }
    void medcineNav(){
        switch(md.getSelectedIndex()){
            case 1:new addMedcine();break;
            case 2:new AllMedcines();break;
        }
    }
    void appointNav(){
        switch(app.getSelectedIndex()){
            case 1:new addappointment();break;
            case 2:new appointements();break;
        }
    }
}
