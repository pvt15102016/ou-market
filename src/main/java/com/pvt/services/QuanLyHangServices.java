/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.pojo.QuanLyHang;
import com.pvt.utils.JDBCUtils;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class QuanLyHangServices {
//    public void ThemHangHoaTrongChiNhanh(QuanLyHang x) throws SQLException{
//        try(Connection conn = JDBCUtils.getConn()){
//            PreparedStatement stm = conn.prepareStatement("INSERT hanghoa_thuoc_chinhanh (MaTiec, MaDV)\n" +
//                " VALUES(?, ?)");
//            PreparedStatement stm1 = conn.prepareStatement(
//                "call thanhTienHoaDon(?)");
//            stm.setInt(1, d.getMaTiec());
//            stm.setInt(2, d.getMaDV());
//            stm1.setInt(1, d.getMaTiec());
//            stm.executeUpdate();
//            stm1.executeUpdate();
//        }
//    }
//    public void xoaDatDichVu(DatDichVu d) throws SQLException{
//        try(Connection conn = JdbcUtils.getConn()){
//            PreparedStatement stm = conn.prepareStatement("delete from DATDICHVU \n" +
//"		WHERE MaDV = ? AND maTiec = ?");
//            PreparedStatement stm1 = conn.prepareStatement(
//                "call thanhTienHoaDon(?)");
//            stm.setInt(1, d.getMaDV());
//            stm.setInt(2, d.getMaTiec());
//            stm1.setInt(1,  d.getMaTiec());
//            stm.executeUpdate();
//            stm1.executeUpdate();
//        }
//    }
//    public int getTongDichVu(int maTiec) throws SQLException{
//        int soLuong = 0 ;
//        try(Connection conn = JdbcUtils.getConn()){ 
//            PreparedStatement stm = conn.prepareStatement("SELECT IFNULL(Count(*), 0) FROM datdichvu WHERE MaTiec = ?");
//            stm.setInt(1, maTiec);
//            ResultSet rs = stm.executeQuery();
//            while(rs.next())
//                soLuong = rs.getInt(1);  
//        }
//        return soLuong;
//    }
//    public BigDecimal getThanhTienDichVu(int maTiec) throws SQLException{
//        BigDecimal thanhTien = BigDecimal.ZERO ;
//        try(Connection conn = JdbcUtils.getConn()){ 
//            PreparedStatement stm = conn.prepareStatement("SELECT IFNULL(SUM(d.DonGia), 0) FROM dichvu d, datdichvu dd WHERE d.maDV = dd.MaDV AND dd.MaTiec = ?");
//            stm.setInt(1, maTiec);
//            ResultSet rs = stm.executeQuery();
//            while(rs.next())
//                thanhTien = rs.getBigDecimal(1);  
//        }
//        return thanhTien;
//    }
//    public List<DichVu> getListDichVuDat(int maTiec) throws SQLException
//    {
//        List<DichVu> DichVus = new ArrayList<>();
//        try(Connection conn = JdbcUtils.getConn()){
//            PreparedStatement stm = conn.prepareStatement("SELECT d.* FROM dichvu d, datdichvu dd WHERE d.maDV = dd.MaDV AND dd.MaTiec = ?");
//                stm.setInt(1, maTiec);
//            ResultSet rs = stm.executeQuery();
//            while(rs.next()){
//                DichVu s = new DichVu();
//                s.setMaDV(rs.getInt("MaDV"));
//                s.setTenDV(rs.getString("TenDV"));
//                s.setDonGia(rs.getBigDecimal("DonGia"));
//                DichVus.add(s);
//            }
//        }
//        return DichVus;
//    }
//    public DatDichVu getDatDV(int maTiec, int maDV) throws SQLException
//    {
//        DatDichVu s = new DatDichVu();
//        try(Connection conn = JdbcUtils.getConn()){
//            PreparedStatement stm = conn.prepareStatement("SELECT * FROM datdichvu WHERE MaTiec = ? AND MaDV = ?");
//            stm.setInt(1, maTiec);
//            stm.setInt(2, maDV);
//            ResultSet rs = stm.executeQuery();
//            if(!rs.next()){
//                return null;
//            }
//            else{   
//                s.setMaDV(rs.getInt("MaDV"));
//                s.setMaTiec(rs.getInt("MaTiec"));
//            }
//        }
//        return s;
//    }
}
