/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

import java.time.LocalDate;

/**
 *
 * @author tien
 */
public class ChiTietHoaDon {
    private int maHangHoa;
    private int maHoaDon;
    private float soLuong;
    private int donGia;
    
    public ChiTietHoaDon(){
        
    }
    public ChiTietHoaDon(float soLuong, int donGia,int maHangHoa, int maHoaDon){
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.maHangHoa = maHangHoa;
        this.maHoaDon = maHoaDon; 
    }
    public ChiTietHoaDon(float soLuong, int maHangHoa, int maHoaDon){
        this.soLuong = soLuong;
        this.maHangHoa = maHangHoa;
        this.maHoaDon = maHoaDon; 
    }
    
    public int getMaHangHoa(){
        return maHangHoa;
    }
    public void setMaHangHoa(int id){
        this.maHangHoa = id;
    }
    public int getMaHoaDon(){
        return maHoaDon;
    }
    public void setMaHoaDon(int id){
        this.maHoaDon = id;
    }
    public float getSoLuong(){
        return soLuong;
    }
    public void setSoLuong(float soLuong){
        this.soLuong = soLuong;
    }
    public int getDonGia(){
        return donGia;
    }
    public void setDonGia(int donGia){
        this.donGia = donGia;
    }
}
