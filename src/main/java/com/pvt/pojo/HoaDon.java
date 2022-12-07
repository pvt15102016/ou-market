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
public class HoaDon {
    private int id;
    private Date ngayXuatDon;
    private int maNV;
    private int maKH;
    private int maCN;
    private int tienNhan;
    private float giaTriCuoi;
    public HoaDon(){
        
    }
    public HoaDon(int id, Date ngayXuatDon, int maNV, int maKH, int maCN, int tienNhan, float giaTriCuoi){
        this.id = id;
        this.ngayXuatDon = ngayXuatDon;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maCN = maCN;
        this.tienNhan = tienNhan;
        this.giaTriCuoi = giaTriCuoi;
    }
    public HoaDon(int id, Date ngayXuatDon, int maNV, int maCN){
        this.id = id;
        this.ngayXuatDon = ngayXuatDon;
        this.maNV = maNV;
        this.maCN = maCN;
    }
    public HoaDon(int id)
    {
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public Date getNgayXuatDon(){
        return ngayXuatDon;
    }
    public void setNgayXuatDon(Date ngayXuatDon){
        this.ngayXuatDon = ngayXuatDon;
    }
    public int getMaNV(){
        return maNV;
    }
    public void setMaNV(int maNV){
        this.maNV = maNV;
    }
    public int getMaKH(){
        return maKH;
    }
    public void setMaKH(int maKH){
        this.maKH = maKH;
    }
    public int getMaCN(){
        return maCN;
    }
    public void setMaCN(int maCN){
        this.maCN = maCN;
    }
    public int getTienNhan(){
        return tienNhan;
    }
    public void setTienNhan(int tienNhan){
        this.tienNhan = tienNhan;
    }
    public float getGiaTriCuoi(){
        return giaTriCuoi;
    }
    public void setGiaTriCuoi(float giaTriCuoi){
        this.giaTriCuoi = giaTriCuoi;
    }
}
