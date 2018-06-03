/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Zakakaria
 */
public class LoginInfo {
    String name;
    String userName;
    String pass;
    String messName;
    Date date;

    public String getName() throws IOException {
        if(name.isEmpty())
           throw new IOException();
        else
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() throws IOException {
         if(userName.isEmpty())
           throw new IOException();
        else
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() throws IOException {
        if(pass.isEmpty())
           throw new IOException();
        else
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getMessName() {
        return messName;
    }

    public void setMessName(String messName) {
        this.messName = messName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
