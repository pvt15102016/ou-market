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
public class NhanVien {
    private int id;
    private String hoTen;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String sdt;
    private String cmnd;
    private int maChucVu;
    private int maChiNhanh;
    private int tienLuong;
    private int maTK;
    
    public NhanVien(){
        
    }
    public NhanVien(int id, String hoTen, Date ngayBatDau, 
            String sdt, String cmnd, int maChucVu, int maChiNhanh,int tienLuong,
            int maTK){
        this.id = id;
        this.hoTen = hoTen;
        this.ngayBatDau = ngayBatDau;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.maChucVu = maChucVu;
        this.maChiNhanh = maChiNhanh;
        this.tienLuong = tienLuong;
        this.maTK = maTK;
    }
    public NhanVien(int id, String hoTen, Date ngayBatDau, Date ngayKetThuc ,
                String sdt, String cmnd, int maChucVu, int maChiNhanh, int tienLuong,
            int maTK){
        this.id = id;
        this.hoTen = hoTen;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.maChucVu = maChucVu;
        this.maChiNhanh = maChiNhanh;
        this.tienLuong = tienLuong;      
        this.maTK = maTK;
    }
    public NhanVien( String hoTen, Date ngayBatDau, Date ngayKetThuc,
            String sdt, String cmnd, int maChucVu, int tienLuong, int maChiNhanh, int maTK){
        this.hoTen = hoTen;
        this.ngayBatDau = ngayBatDau;
        this.sdt = sdt;
        this.cmnd = cmnd;
        this.maChucVu = maChucVu;
        this.maChiNhanh = maChiNhanh;
        this.tienLuong = tienLuong;   
        this.maTK = maTK;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getHoTen(){
        return hoTen;
    }
    public void setHoTen(String hoTen){
        this.hoTen = hoTen;
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
    public String getSdt(){
        return sdt;
    }
    public void setSdt(String sdt){
        this.sdt = sdt;
    }
    public String getCmnd(){
        return cmnd;
    }
    public void setCmnd(String cmnd){
        this.cmnd = cmnd;
    }
    public int getMaChucVu(){
        return maChucVu;
    }
    public void setMaChucVu(int maChucVu){
        this.maChucVu = maChucVu;
    }
    public int getMaChiNhanh(){
        return maChiNhanh;
    }
    public void setMaChiNhanh(int maChiNhanh){
        this.maChiNhanh = maChiNhanh;
    }
    public int getTienLuong(){
        return tienLuong;
    }
    public void setTienLuong(int tienLuong){
        this.tienLuong = tienLuong;
    }
    public int getMaTK(){
        return maTK;
    }
    public void setMaTK(int maTK){
        this.maTK = maTK;
    }
}
