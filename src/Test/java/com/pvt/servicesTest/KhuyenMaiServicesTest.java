/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

import com.pvt.pojo.KhuyenMai;
import com.pvt.services.KhuyenMaiServices;
import com.pvt.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class KhuyenMaiServicesTest {
    private static KhuyenMaiServices khuyenmai;
    private static Connection conn;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        khuyenmai= new KhuyenMaiServices();
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMaiServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void testGetListKhuyenMai() throws SQLException {
        String kw = "2";
        List<KhuyenMai> km = khuyenmai.getListKhuyenMai(kw);
        
        for (KhuyenMai h: km){
            System.out.println(h.getId());
            System.out.println(h.getNgayBatDau());
            System.out.println(h.getNgayKetThuc());
            System.out.println(h.getGiaKhuyenMai());
 
        }
    }
    
    
}
