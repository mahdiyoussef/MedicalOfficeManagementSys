/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author AZA
 */
public class login {
    private int id;
    private String username,pwd;
    public login(int id,String username,String pwd){
        this.id=id;
        this.username=username;
        this.pwd=pwd;
    }
    // getters
    public int getId(){
        return id;
    }
    public String getUsername(){
        return username;
    }
    public String getPwd(){
        return pwd;
    }
    //setters
    public void setUsername(String username){
        this.username=username;
    }
    public void setPwd(String pwd){
        this.pwd=pwd;
    }
}
