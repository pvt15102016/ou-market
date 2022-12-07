/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

/**
 *
 * @author tien
 */
public class HangHoa {
    private int id;
    private String tenHangHoa;
    private String xuatXu;
    private int donGia;
    
    public HangHoa(){
        
    }
    public HangHoa(int id, String tenHangHoa, String xuatXu, int donGia){
        this.id = id;
        this.tenHangHoa = tenHangHoa;
        this.xuatXu = xuatXu;
        this.donGia = donGia;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTenHangHoa(){
        return tenHangHoa;
    }
    public void setTenHangHoa(String tenHangHoa){
        this.tenHangHoa = tenHangHoa;
    }
    public String getXuatXu(){
        return xuatXu;
    }
    public void setXuatXu(String xuatXu){
        this.xuatXu = xuatXu;
    }
    public int getDonGia(){
        return donGia;
    }
    public void setDonGia(int donGia){
        this.donGia = donGia;
    }
}
