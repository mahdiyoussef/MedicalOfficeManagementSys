/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Screens;

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
public class appointements extends JFrame {
    String[][] dataappo=new rvDB().fullAppointement();
    JTable data;
    JButton delete,cancel;
    String[][] dataappoit=new rvDB().fullAppointement();
    String[] columns ={"Number", "Date", "H-Debut", "H-Fin", "M-Debut", "M-Fin", "client", "medcine"};
    public appointements(){
        
        
        //JPanels
        JPanel Header=new JPanel();
        JPanel Body=new JPanel();
        JPanel Footer=new JPanel();
        // Header
        JLabel Title=new JLabel("Appointements");
        Title.setHorizontalAlignment(JLabel.CENTER);
        Header.add(Title);
        Header.setBackground(Color.WHITE);
        // Body
        data=new JTable(dataappoit,columns);
        data.setBackground(Color.white);
        Body.setBackground(Color.WHITE);
        
        //footer
        delete=new JButton("Delete");
        cancel=new JButton("Cancel");
        Footer.add(delete);
        Footer.add(cancel);
        Footer.setBackground(Color.white);
        // JButtons controllers
        delete.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                deleteApo();
            }
        
        });
        cancel.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }
            
        });
        // JFrame configuration
        add(Header,BorderLayout.NORTH);
        add(new JScrollPane(data),BorderLayout.CENTER);
        add(Footer,BorderLayout.SOUTH);
        URL Thumbnailurl=getClass().getResource("/Assets/thumbnail.png");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("All Appointements");
        setIconImage(new ImageIcon(Thumbnailurl).getImage());
        setSize(1280,720);
        setVisible(true);
    }
    void deleteApo(){
        try{
            rvDB fncns=new rvDB();
            //int RVID=Integer.parseInt(dataappo[row][1]);
            //System.out.println(dataappo[data.getSelectedRow()][0]);
            fncns.deleteRv(fncns.rvById(Integer.parseInt(dataappo[data.getSelectedRow()][0])));
            data=new JTable(fncns.fullAppointement(),columns);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
    
    
}
