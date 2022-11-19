/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.util.ArrayList;

/**
 *
 * @author AZA
 */
public interface loginDAO {
    public boolean checkLogin(String username,String pwd);
    public void addUser(login l);
    public void updateUser(login l);
    public login getUser(String username);
    public ArrayList<login> getAllUsers();
}
