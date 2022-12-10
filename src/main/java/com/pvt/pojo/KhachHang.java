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
public class KhachHang {
    private int id;
    private String tenKH;
    private Date ngayThamGia;
    private String soDienThoai;
    private String cmnd;
    private Date ngaySinh;
    public KhachHang(){
        
    }
    public KhachHang(int id, String tenKH, Date ngayThamGia, String soDienThoai,
            String cmnd, Date ngaySinh){
        this.id = id;
        this.tenKH = tenKH;
        this.ngayThamGia = ngayThamGia;
        this.soDienThoai = soDienThoai;
        this.cmnd = cmnd;
        this.ngaySinh = ngaySinh;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTenKH(){
        return tenKH;
    }
    public void setTenKH(String tenKH){
        this.tenKH = tenKH;
    }
    public Date getNgayThamGia(){
        return ngayThamGia;
    }
    public void setNgayThamGia(Date ngayThamGia){
        this.ngayThamGia = ngayThamGia;
    }
    public String getSDT(){
        return soDienThoai;
    }
    public void setSDT(String soDienThoai){
        this.soDienThoai = soDienThoai;
    }
    public String getCmnd(){
        return cmnd;
    }
    public void setCmnd(String cmnd){
        this.cmnd = cmnd;
    }
    public Date getNgaySinh(){
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh){
        this.ngaySinh = ngaySinh;
    }
    @Override
    public String toString() {
        return id + "." + tenKH; 
    }
}
