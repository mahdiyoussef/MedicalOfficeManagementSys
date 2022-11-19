/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import java.sql.*;
import java.util.ArrayList;
import DBConnection.DBConnection;
import client.clientDB;
import creneaux.creneauxDB;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AZA
 */
public class rvDB implements rvDAO{
    Connection con;
    ResultSet RS;
    Statement St;
    
    public rvDB(){
        try {
            con=DBConnection.getInstance();
            St=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public void addRv(rv rv) {
        try {
            St.executeUpdate("insert into rv values("+rv.getId()+",to_date('"+rv.getDate()+"','dd-mm-yy'),"+rv.getClient().getId()+","+rv.getCreneaux().getId()+")");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateRv(rv rv) {
        try {
            St.executeUpdate("update rv set date=to_date('"+rv.getDate()+"','dd-mm-yy'),id_client="+rv.getClient().getId()+",id_creneaux="+rv.getCreneaux().getId()+" where id="+rv.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteRv(rv rv) {
        try {
            St.executeUpdate("delete from rv where id="+rv.getId());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public rv rvById(int id) {
        rv rv=null;
        try {
            RS=St.executeQuery("select * from rv where id="+id);
            while(RS.next()){
                rv=new rv(RS.getInt("id"),RS.getString("date").charAt(0),new clientDB().clientById(RS.getInt("id_client")),new creneauxDB().searchCreneau(RS.getInt("id_creneaux")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rv;
    }

    @Override
    public ArrayList<rv> AllRv() {
        ArrayList<rv> list =new ArrayList<rv>();
        try {
            RS=St.executeQuery("select * from rv");
            while(RS.next()){
                list.add(new rvDB().rvById(RS.getInt("id")));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public int rvNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
