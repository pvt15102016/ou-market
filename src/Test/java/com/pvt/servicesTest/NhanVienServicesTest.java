/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

import com.pvt.pojo.NhanVien;
import com.pvt.services.NhanVienServices;
import com.pvt.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NhanVienServicesTest {

    private static Connection conn;
    private static NhanVienServices nvsv;

    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(NhanVienServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        nvsv = new NhanVienServices();

    }

    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {

            Logger.getLogger(NhanVienServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testGetListNhanVien() throws SQLException {
        String kw = "An";
        List<NhanVien> nv = nvsv.getListNhanVien(kw);

        for (NhanVien n : nv) {
            System.out.println(n.getId());
            System.out.println(n.getHoTen());
            System.out.println(n.getNgayBatDau());
            System.out.println(n.getNgayKetThuc());
            System.out.println(n.getSdt());
            System.out.println(n.getCmnd());
            System.out.println(n.getMaChucVu());
            System.out.println(n.getMaChiNhanh());
            System.out.println(n.getTienLuong());
        }
    }
    
//    @Test
//    public void testSuccessThemNhanVien() throws Exception{
//        NhanVien nV = new NhanVien(99, "String", "Ho Chi Minh", 50000);
//        nvsv.ThemNhanVien(nV);
//        
//        Assertions.assertEquals(1, hhsv.getListNhanVien().get(0).getId());
//    }
//    
    @Test
    public void testSuccessTimNhanVien() throws Exception{
        String kw = "Bảo";
        List<NhanVien> NhanVien = nvsv.TimNhanVien(kw);
        for(NhanVien n:NhanVien){
            Assertions.assertTrue(n.getHoTen().toLowerCase().contains(kw.toLowerCase()));
        }
    }
    
    @Test
    public void testSuccessXoaNhanVien() throws Exception {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setId(7);
        nvsv.XoaNhanVien(nhanVien);
        try ( Connection conn = JDBCUtils.getConn()) {
            String sql = "SELECT * FROM nhanvien Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(7));
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                Assertions.assertNotEquals(7, rs.getInt("id"));
            }
        }
    }
    
//    @Test
//    public void testFailerXoaNhanVien() throws Exception {
//        NhanVien hH = new NhanVien(23, "trà sữa", "hồ chí minh", 50000);
//        try {
//            hhsv.xoaNhanVien(hH);
//            Assertions.assertFalse(hhsv.getListNhanVien().contains(hH));
//        } catch (SQLException e) {
//            Assertions.assertTrue(hhsv.getListNhanVien().contains(hH));
//        }
//    }
//    
//    @Test
//    public void testSuccessCapNhatNhanVien() throws SQLException {
//        
//        NhanVien hangH = new NhanVien(4, "Hồng trà", "Khanh Hoa", 10000);
//        hhsv.suaNhanVien(hangH);
//
//        Assertions.assertTrue(hhsv.getListNhanVien().contains(hangH));
//       
//    }
//    
//    @Test
//    public void testFailCapNhatNhanVien() throws SQLException {
//        
//        NhanVien hangH = new NhanVien(4, "Hồng trà", "Khanh Hoa", 10000);
//        hhsv.suaNhanVien(hangH);
//
//        Assertions.assertFalse(hhsv.getListNhanVien().contains(hangH));
//    }
}
