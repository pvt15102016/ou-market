/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

import com.pvt.services.HoaDonServices;
import java.lang.annotation.Target;
import com.pvt.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.Statement;
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
public class HoaDonServicesTest {   
    private static HoaDonServices hd;
    private static Connection conn;
    
     @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        hd = new HoaDonServices();
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
//    public void testSuccessupdateHH_DH() throws SQLException {
//        try {
//            hd.upDateHH_DH("feda63ff-59d8-4130-ba81-912f10928345", "4");
//            try (Connection conn = JDBCutils.getConn()) {
//                Statement stm = conn.createStatement();
//                ResultSet rs = stm.executeQuery("SELECT idHangHoa FROM donhang_hanghoa WHERE idDonHang='feda63ff-59d8-4130-ba81-912f10928345'");
//                String hanghoa = "";
//                while (rs.next()) {
//                    hanghoa = rs.getString("idHangHoa");
//
//                }
//                Assertions.assertEquals("4", hanghoa);
//
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDonServicesTest.class.toString()).log(Level.SEVERE, null, ex);
//
//        }
//    }
    
    
    
}
