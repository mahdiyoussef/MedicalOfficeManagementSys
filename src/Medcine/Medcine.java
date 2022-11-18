/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medcine;

/**
 *
 * @author AZA
 */
public class Medcine {
    private char nom,prenom,titre;
    private int id,version;
    //constructor
    public Medcine(int id,int version,char titre,char nom,char prenom){
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
    public char getNom(){
        return nom;
    }
    public char getPrenom(){
        return prenom;
    }
    public char getTitre(){
        return titre;
    }
    //setters
    public void setVersion(int v){
        this.version=v;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setNom(char n){
        this.nom=n;
    }
    public void setPrenom(char p){
        this.prenom=p;
    }
    public void setTitre(char t){
        this.titre=t;
    }
    
}
