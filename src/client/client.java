/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

/**
 *
 * @author AZA
 */
public class client {
    private String nom,prenom,titre;
    private int id,version;
    //constructor
    public client(int id,int version,String titre,String nom,String prenom){
        this.id=id;
        this.version=version;
        this.nom=nom;
        this.prenom=prenom;
        this.titre=titre;
    }
    //getters
    public int getVersion(){
        return version;
    }
    public int getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public String getPrenom(){
        return prenom;
    }
    public String getTitre(){
        return titre;
    }
    //setters
    public void setVersion(int v){
        this.version=v;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setNom(String n){
        this.nom=n;
    }
    public void setPrenom(String p){
        this.prenom=p;
    }
    public void setTitre(String t){
        this.titre=t;
    }
}
