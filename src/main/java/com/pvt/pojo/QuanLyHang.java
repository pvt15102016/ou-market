/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

/**
 *
 * @author tien
 */
public class QuanLyHang {
    private int maHangHoa;
    private int maChiNhanh;
    private float soLuong;
    
    public QuanLyHang(){
        
    }
    public QuanLyHang(int maChiNhanh, int maHangHoa, float soLuong){
        this.maChiNhanh = maChiNhanh;
        this.maHangHoa = maHangHoa;
        this.soLuong = soLuong;
    }
    
    public int getMaChiNhanh(){
        return maChiNhanh;
    }
    public void setMaChiNhanh(int maChiNhanh){
        this.maChiNhanh = maChiNhanh;
    }
    public int getMaHangHoa(){
        return maHangHoa;
    }
    public void setMaHangHoa(int maHangHoa){
        this.maHangHoa = maHangHoa;
    }
    public float getSoLuong(){
        return soLuong;
    }
    public void setMaChiNhanh(float soLuong){
        this.soLuong = soLuong;
    }
}
