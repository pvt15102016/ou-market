/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

<<<<<<< HEAD
=======
/**
 *
 * @author DELL
 */


>>>>>>> c11b44922ec8d255a239051fa19971f14971c882
import com.pvt.pojo.NhanVien;
import com.pvt.services.NhanVienServices;
import com.pvt.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Date;
>>>>>>> c11b44922ec8d255a239051fa19971f14971c882
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

<<<<<<< HEAD
/**
 *
 * @author mello
 */
public class NhanVienServicesTest {
    private static NhanVienServices nhanvien;
    private static Connection conn;
    
=======
public class NhanVienServicesTest {
    
    private static Connection conn;
    private static NhanVienServices nvsv;
    
    @BeforeAll
>>>>>>> c11b44922ec8d255a239051fa19971f14971c882
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
<<<<<<< HEAD
        nhanvien= new NhanVienServices();
=======
        nvsv = new NhanVienServices();
>>>>>>> c11b44922ec8d255a239051fa19971f14971c882
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
<<<<<<< HEAD
            Logger.getLogger(NhanVienServicesTest.class.getName()).log(Level.SEVERE, null, ex);
=======
            Logger.getLogger(ChiNhanhServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testGetListNhanVien() throws SQLException {
        String kw = "An";
        List<NhanVien> nv = nvsv.getListNhanVien(kw);
        
        for (NhanVien n:nv){
            System.out.println(n.getId());
            System.out.println(n.getHoTen());
            System.out.println(n.getNgayBatDau());
            System.out.println(n.getNgayKetThuc());
            System.out.println(n.getSdt());
            System.out.println(n.getCmnd());
            System.out.println(n.getMaChucVu());
            System.out.println(n.getMaChiNhanh());
            System.out.println(n.getTienLuong());
>>>>>>> c11b44922ec8d255a239051fa19971f14971c882
        }
    }
    
}
