/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rv;

import client.client;
import creneaux.creneaux;


/**
 *
 * @author AZA
 */
public class rv {
    private int id;
    private String date;
    private client c;
    private creneaux cr;
    
    public rv(int id,String date,client c,creneaux cr){
        this.id=id;
        this.c=c;
        this.cr=cr;
        this.date=date;
    }
    //getters
    public int getId(){
        return id;
    }
    public String getDate(){
        return date;
    }
    public client getClient(){
        return c;
    }
    public creneaux getCreneaux(){
        return cr;
    }
    //setters
    public void setDate(String date){
        this.date=date;
    }
    public void setClient(client c){
        this.c=c;
    }
    public void setCreneaux(creneaux cr){
        this.cr=cr;
    }
}
