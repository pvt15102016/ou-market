/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

/**
 *
 * @author tien
 */
public class ChiNhanh {
    private int id;
    private String tenChiNhanh;
    private String diaChi;
    
    public ChiNhanh(){
        
    }
    public ChiNhanh(int id, String tenChiNhanh, String diaChi){
        this.id = id;
        this.tenChiNhanh = tenChiNhanh;
        this.diaChi = diaChi;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTenChiNhanh(){
        return tenChiNhanh;
    }
    public void setTenChiNhanh(String tenChiNhanh){
        this.tenChiNhanh = tenChiNhanh;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    
    @Override
    public String toString() {
        return id + "." + tenChiNhanh; 
    }
}
