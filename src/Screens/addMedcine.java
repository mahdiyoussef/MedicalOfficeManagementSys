/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;
import Medcine.Medcine;
import client.client;
import client.clientDB;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.URL;
import javax.swing.*;
import Medcine.MedcinesDB;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author AZA
 */
public class addMedcine extends JFrame {
    JTextField version,titre,nom,prenom;
    JLabel msg;
    JButton add;
    public addMedcine(){
        // JPanels
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        JPanel Body1=new JPanel();
        JPanel Body2=new JPanel();
        JPanel Body3=new JPanel();
        JPanel Body4=new JPanel();
        JPanel Body5=new JPanel();
        JPanel Footer=new JPanel();
        
        // Header Jpanel
        JLabel title=new JLabel();
        title.setText("Add an Medcine");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        
        Header.add(title);
        
        // body
        
        version=new JTextField("version");
        version.setAlignmentY(JTextField.CENTER);
        version.setMaximumSize(new Dimension(1000,60));
        version.setHorizontalAlignment(JTextField.CENTER);
        
        
        titre=new JTextField("title");
        titre.setAlignmentY(JTextField.CENTER);
        titre.setMaximumSize(new Dimension(1000,60));
        titre.setHorizontalAlignment(JTextField.CENTER);
        
        
        nom=new JTextField("Last Name");
        nom.setHorizontalAlignment(JTextField.CENTER);
        nom.setMaximumSize(new Dimension(1000,60));
        
        
        prenom=new JTextField("First Name");
        prenom.setAlignmentY(JLabel.CENTER);
        prenom.setMaximumSize(new Dimension(1000,60));
        prenom.setHorizontalAlignment(JTextField.CENTER);
        
        
        add=new JButton("Add");
        add.setMinimumSize(new Dimension(1000,60));
        add.setPreferredSize(new Dimension(1000,60));
        add.setHorizontalAlignment(JButton.CENTER);
        add.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                addMedcineDB();
            }
            
        });
        msg=new JLabel();
        Body.setLayout(new FlowLayout(FlowLayout.CENTER));
        Body.setLayout(new BoxLayout(Body, BoxLayout.Y_AXIS));
        Body.add(version);
        Body.add(titre);
        Body.add(nom);
        Body.add(prenom);
        Body.add(msg);
        
        
        //footer
        Footer.add(add);
        Footer.setBackground(Color.white);
        
        // JFrame configuration
        Header.setBackground(Color.WHITE);
        Body.setBackground(Color.WHITE);
        add(Header,BorderLayout.NORTH);
        add(Body,BorderLayout.CENTER);
        add(Footer,BorderLayout.SOUTH);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add an Client");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
    void addMedcineDB(){
        MedcinesDB MD=new MedcinesDB();
        Medcine c=null;
        int id;
        int vsi;
        String vs=version.getText();
        String tt=titre.getText();
        String pn=prenom.getText();
        String nm=nom.getText();
        try {
            if(vs=="" || tt=="" || pn=="" || nm==""){
                msg.setText("Not enough information");
            }
            else if(vs.length()>11){
                msg.setText("Version Must be less than 11 numbers");
            }
            else{
                try {
                    vsi=Integer.parseInt(vs);
                    id=MD.numberOfMedcines()+1;
                    c=new Medcine(id,vsi,tt,nm,pn);
                    MD.addMedicines(c);
                    
                } catch (Exception e) {
                    msg.setText("Version Must be an number");
                }
            }
        } catch (Exception e) {
            msg.setText("You Have a problem in data that you insert please retry");
            
        }
    }
    
}
