/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.pojo;

import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author tien
 */
public class KhuyenMai {
    private int id;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private int giaKhuyenMai;
    
    public KhuyenMai(){
        
    }
    public KhuyenMai(int id, Date ngayBatDau, Date ngayKetThuc,
            int giaKhuyenMai){
        this.id = id;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.giaKhuyenMai = giaKhuyenMai;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public Date getNgayBatDau(){
        return ngayBatDau;
    }
    public void setNgayBatDau(Date ngayBatDau){
        this.ngayBatDau = ngayBatDau;
    }
    public Date getNgayKetThuc(){
        return ngayKetThuc;
    }
    public void setNgayKetThuc(Date ngayKetThuc){
        this.ngayKetThuc = ngayKetThuc;
    }
    public int getGiaKhuyenMai(){
        return giaKhuyenMai;
    }
    public void setGiaKhuyenMai(int giaKhuyenMai){
        this.giaKhuyenMai = giaKhuyenMai;
    }
}
