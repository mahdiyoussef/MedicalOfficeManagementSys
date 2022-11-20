/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;
import Medcine.MedcinesDB;
import creneaux.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.Border;
import rv.*;
import client.*;

/**
 *
 * @author AZA
 */
public class addappointment extends JFrame {
    JTextField patient,doctor,version,AppointementDate,AppointementTime,AppointementTime1,AppointementTime2,AppointementTime3;
    
    JButton addApp;
    public addappointment(){
        JPanel Header =new JPanel();
        JPanel Body=new JPanel(new BorderLayout());
        JPanel Footer =new JPanel();
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        // Header
        JLabel title=new JLabel();
        title.setText("Add an Appointement");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        
        Header.add(title);
        Header.setBackground(Color.white);
        // body 
        patient=new JTextField("Patient Number");
        patient.setMaximumSize(new Dimension(1000,60));
        patient.setHorizontalAlignment(JTextField.CENTER);
        
        version=new JTextField("Version Number");
        version.setMaximumSize(new Dimension(1000,60));
        version.setHorizontalAlignment(JTextField.CENTER);
        
        
        doctor=new JTextField("Doctor Number");
        doctor.setMaximumSize(new Dimension(1000,60));
        doctor.setHorizontalAlignment(JTextField.CENTER);
        
        
        AppointementDate = new JTextField("Date of Appointement DD-MM-YY");
        AppointementDate.setMaximumSize(new Dimension(1000,60));
        AppointementDate.setHorizontalAlignment(JTextField.CENTER);
        
        
        AppointementTime = new JTextField("Client Start Hour");
        AppointementTime.setMaximumSize(new Dimension(1000,60));
        AppointementTime.setText("Client Start Hour");
        AppointementTime.setHorizontalAlignment(JTextField.CENTER);
        
        
        AppointementTime1 = new JTextField("client End Hour");
        AppointementTime1.setMaximumSize(new Dimension(1000,60));
        AppointementTime1.setHorizontalAlignment(JTextField.CENTER);
        
        AppointementTime2 = new JTextField("Medcine Start Hour");
        AppointementTime2.setMaximumSize(new Dimension(1000,60));
        
        AppointementTime2.setHorizontalAlignment(JTextField.CENTER);
        
        
        AppointementTime3 = new JTextField("Medcine End Hour");
        AppointementTime3.setMaximumSize(new Dimension(1000,60));
        AppointementTime3.setHorizontalAlignment(JTextField.CENTER);
        
        
        addApp=new JButton("Add");
        addApp.setMinimumSize(new Dimension(1000,60));
        addApp.setPreferredSize(new Dimension(1000,60));
        // add event listener to add button
        addApp.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                addAppointement();
            }
        
        });
        
        Body.add(patient,BorderLayout.EAST);
        Body.add(doctor);
        Body.add(version);
        Body.add(AppointementDate);
        Body.add(AppointementTime);
        Body.add(AppointementTime1);
        Body.add(AppointementTime2);
        Body.add(AppointementTime3);
        Footer.add(addApp);
        
        Body.setLayout(new FlowLayout(FlowLayout.CENTER));
        Body.setLayout(new BoxLayout(Body, BoxLayout.Y_AXIS));
        Body.setAlignmentX(JPanel.CENTER_ALIGNMENT);
        Body.setBackground(Color.white);
       
        // footer
        
        Footer.setBackground(Color.white);
        // add to frame
        Body.setAlignmentY(JPanel.CENTER_ALIGNMENT);
        add(Header,BorderLayout.NORTH);
        add(Body,BorderLayout.CENTER);
        add(Footer,BorderLayout.SOUTH);
        // JFrame configuration
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Add an Appointement");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
    void addAppointement(){
        String ptnt=patient.getText();
        String vrs=version.getText();
        String dctr=doctor.getText();
        String AD=AppointementDate.getText();
        String AT=AppointementTime.getText();
        String AT1=AppointementTime1.getText();
        String AT2=AppointementTime2.getText();
        String AT3=AppointementTime3.getText();
        creneaux cr;
        rv r;
        int n=new creneauxDB().CreneauxNumber()+1;
        int nrv=new rvDB().rvNumber()+1;
        try{
            cr=new creneaux(n,Integer.parseInt(vrs),Integer.parseInt(AT),Integer.parseInt(AT2),Integer.parseInt(AT1),Integer.parseInt(AT3),new MedcinesDB().MedcineById(Integer.parseInt(dctr)));
            new creneauxDB().addCreneau(cr);
            client cl=new clientDB().clientById(Integer.parseInt(ptnt));
            r=new rv(nrv,AD,cl,new creneauxDB().searchCreneau(n));
            new rvDB().addRv(r);
            System.out.println("added");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
