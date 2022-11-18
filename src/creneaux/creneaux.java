/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creneaux;

import Medcine.Medcine;

/**
 *
 * @author AZA
 */
public class creneaux {
    private int id;
    private int version;
    private int HDebut;
    private int MDebut;
    private int HFin;
    private int MFin;
    private Medcine medcine;
    creneaux(int id,int version,int HD,int MD,int HF,int MF,Medcine m){
        this.id=id;
        this.version=version;
        this.HDebut=HD;
        this.MDebut=MD;
        this.HFin=HF;
        this.MFin=MF;
        this.medcine=m;
    }
    public int getId(){
        return id;
    }
    public int getVersion(){
        return version;
    }
    public int getHDebut(){
        return HDebut;
    }
    public int getMDebut(){
        return MDebut;
    }
    public int getHFin(){
        return HFin;
    }
    public int getMFin(){
        return MFin;
    }
    public Medcine getMedcine(){
            return medcine;
    }
    public void setId(int id){
        this.id=id;
    }
    public void setVersion(int version){
        this.version=version;
    }
    public void setHDebut(int HD){
        this.HDebut=HD;
    }
    public void setMDebut(int MD){
        this.MDebut=MD;
    }
    public void setHFin(int HF){
        this.HFin=HF;
    }
    public void setMFin(int MF){
        this.MFin=MF;
    }
    public void setMedcine(Medcine m){
        this.medcine=m;
    }
}
