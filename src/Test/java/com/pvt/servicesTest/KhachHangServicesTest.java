/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

import com.pvt.pojo.KhachHang;
import com.pvt.services.KhachHangServices;
import com.pvt.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 *
 * @author mello
 */
public class KhachHangServicesTest {
    private static KhachHangServices khachhang;
    private static Connection conn;
    
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        khachhang= new KhachHangServices();
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetListKhachHang() throws SQLException {
        String kw = "Ly";
        List<KhachHang> kh = khachhang.getListKhachHang(kw);
        
        for (KhachHang h: kh){
            System.out.println(h.getId());
            System.out.println(h.getTenKH());
            System.out.println(h.getNgayThamGia());
            System.out.println(h.getSDT());
            System.out.println(h.getCmnd());
            System.out.println(h.getNgaySinh());
        }
    }
    
    @Test
    public void testSuccessThemKhachHang() throws Exception{
        KhachHang hh = new KhachHang(8, "tien", new Date(2021, 12, 03), "123", "1231", new Date(2021, 12, 03));
        khachhang.ThemKhachHang(hh);
        
        Assertions.assertTrue(khachhang.getListKhachHang(null).contains(hh));
    }
    
    @Test
    public void testSuccessTimKhachHang() throws Exception{
        String kw = "tien";
        List<KhachHang> KhachHang = khachhang.getListKhachHang(kw);
        for(KhachHang h:KhachHang){
            Assertions.assertTrue(h.getTenKH().toLowerCase().contains(kw.toLowerCase()));
        }
    }
    
    @Test
    public void testSuccessXoaKhachHang() throws Exception{
        KhachHang kh = new KhachHang(5, null, null, "123123", "123123", new Date(2021, 12, 12));
        try {
            khachhang.XoaKhachHang(kh.getId());
            Assertions.assertFalse(khachhang.getListKhachHang(null).contains(kh));
        } catch (SQLException e) {
            Assertions.assertTrue(khachhang.getListKhachHang(null).contains(kh));
        }
    }
    
    @Test
    public void testFailerXoaKhachHang() throws Exception{
        KhachHang kh = new KhachHang(5, null, null, "123123", "123123", new Date(2021, 12, 12));
        try {
            khachhang.XoaKhachHang(kh.getId());
            Assertions.assertTrue(khachhang.getListKhachHang(null).contains(kh));
        } catch (SQLException e) {
            Assertions.assertFalse(khachhang.getListKhachHang(null).contains(kh));
        }
    }
   
    @Test
    public void testSuccessCapNhatKhachHang() throws SQLException {
        
        KhachHang khachH = new KhachHang(5, "toan", null, "123123", "123123", new Date(2021, 12, 12));
        khachhang.CapNhatKhachhang(khachH);

        Assertions.assertTrue(khachhang.getListKhachHang(null).contains(khachH));
       
    }
    
    @Test
    public void testFailCapNhatKhachHang() throws SQLException {
        
        KhachHang kHang = new KhachHang(5, "toan", null, "123123", "123123", new Date(2021, 12, 12));
        khachhang.CapNhatKhachhang(kHang);

        Assertions.assertFalse(khachhang.getListKhachHang(null).contains(kHang));
    }
    
}
