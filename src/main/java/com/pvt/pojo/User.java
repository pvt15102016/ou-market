/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

/**
 *
 * @author tien
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int maUserRole;
    
    public User(){
        
    }
    public User(int id, String username, String password, int maUserRole){
        this.id = id;
        this.username = username;
        this.password = password;
        this.maUserRole = maUserRole;
    }
    public User(String username, String password, int maUserRole){
        this.username = username;
        this.password = password;
        this.maUserRole = maUserRole;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUserName(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public int getMaUserrole(){
        return maUserRole;
    }
    public void setMaUserRole(int maUserRole){
        this.maUserRole = maUserRole;
    }
    
    
    
}
