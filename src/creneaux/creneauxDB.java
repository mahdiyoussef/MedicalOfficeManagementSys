/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creneaux;

import java.sql.*;
import java.util.ArrayList;
import DBConnection.DBConnection;
import Medcine.Medcine;
import java.util.logging.Level;
import java.util.logging.Logger;
import Medcine.MedcinesDB;
/**
 *
 * @author AZA
 */
public class creneauxDB implements creneauxDAO{
    Connection con;
    Statement St;
    ResultSet RS;
    MedcinesDB MD=new MedcinesDB();
    public creneauxDB(){
        try{
            con=DBConnection.getInstance();
            St=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public void addCreneau(creneaux c) {
        int id;
        try{
            id=c.getMedcine().getId();
            St.executeUpdate("insert into creneaux values("+c.getId()+","+c.getVersion()+","+c.getHDebut()+","+c.getMDebut()+","+c.getHFin()+","+c.getMFin()+","+id+");");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateCreneau(creneaux c) {
        try {
            St.executeUpdate("update creneaux set version="+c.getVersion()+" ,hdebut="+c.getHDebut()+" ,mdebut="+c.getMDebut()+",hfin="+c.getMDebut()+",mfin="+c.getMFin()+" ,id_medcine="+c.getMedcine().getId()+" where id="+c.getId());
            System.out.println(c.getId()+" is updated succesfuly");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deletecreneau(creneaux c) {
        try {
            St.executeUpdate("delete from creneaux where id="+c.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<creneaux> AllCreneaux() {
        ArrayList<creneaux> list =new ArrayList<creneaux>();
        Medcine m = null;
        try {
            RS=St.executeQuery("select * from creneaux");
            while(RS.next()){
                m=MD.MedcineById(RS.getInt("id_medcine"));
                list.add(new creneaux(RS.getInt("id"),RS.getInt("version"),RS.getInt("hdebut"),RS.getInt("mdebut"),RS.getInt("hfin"),RS.getInt("mfin"),m));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public creneaux searchCreneau(int id) {
        creneaux c=null;
        Medcine m = null;
        try {
            
            RS=St.executeQuery("select * from creneaux where id="+id);
            while(RS.next()){
                m=MD.MedcineById(RS.getInt("id_medcine"));
                c=new creneaux(RS.getInt("id"),RS.getInt("version"),RS.getInt("hdebut"),RS.getInt("mdebut"),RS.getInt("hfin"),RS.getInt("mfin"),m);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return c;
    }

    @Override
    public int CreneauxNumber() {
        int n=0;
        try {
            RS=St.executeQuery("select count(*) as n from creneaux");
            while(RS.next()){
                n=RS.getInt("n");
            }
        } catch (Exception e) {
        }
        return n;
    }
    
}
