/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.net.URL;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.border.Border;

/**
 *
 * @author AZA
 */
public class addappointment extends JFrame {
    JTextField patient,doctor;
    JFormattedTextField AppointementDate,AppointementTime,AppointementTime1,AppointementTime2,AppointementTime3;
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
        
        
        doctor=new JTextField("Doctor Number");
        doctor.setMaximumSize(new Dimension(1000,60));
        doctor.setHorizontalAlignment(JTextField.CENTER);
        
        DateFormat format = new SimpleDateFormat("DD-MM-YY");
        AppointementDate = new JFormattedTextField(format);
        AppointementDate.setMaximumSize(new Dimension(1000,60));
        AppointementDate.setText("Date of Appointement DD-MM-YY");
        AppointementDate.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        Format Time = DateFormat.getTimeInstance(DateFormat.SHORT);
        AppointementTime = new JFormattedTextField(Time);
        AppointementTime.setMaximumSize(new Dimension(1000,60));
        AppointementTime.setText("Client Start Hour");
        AppointementTime.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        
        AppointementTime1 = new JFormattedTextField(Time);
        AppointementTime1.setMaximumSize(new Dimension(1000,60));
        AppointementTime1.setText("client End Hour");
        AppointementTime1.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        AppointementTime2 = new JFormattedTextField(Time);
        AppointementTime2.setMaximumSize(new Dimension(1000,60));
        AppointementTime2.setText("Medcine Start Hour");
        AppointementTime2.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        
        AppointementTime3 = new JFormattedTextField(Time);
        AppointementTime3.setMaximumSize(new Dimension(1000,60));
        AppointementTime3.setText("Medcine End Hour");
        AppointementTime3.setHorizontalAlignment(JFormattedTextField.CENTER);
        
        
        addApp=new JButton("Add");
        addApp.setMinimumSize(new Dimension(1000,60));
        addApp.setPreferredSize(new Dimension(1000,60));
        // add event listener to add button
        
        
        Body.add(patient,BorderLayout.EAST);
        Body.add(doctor);
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
}
