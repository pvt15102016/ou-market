/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

/**
 *
 * @author tien
 */
public class ChucVu {
    private int id;
    private String tenChucVu;
    
    public ChucVu(){
        
    }
    public String toString(){
        return this.tenChucVu;
    }
    public ChucVu(int id, String tenChucVu){
        this.id = id;
        this.tenChucVu = tenChucVu;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTenChucVu(){
        return tenChucVu;
    }
    public void setTenChucVu(String tenChucVu){
        this.tenChucVu = tenChucVu;
    }
}
