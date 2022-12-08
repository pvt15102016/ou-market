/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

/**
 *
 * @author DELL
 */
import com.pvt.pojo.ChiNhanh;
import com.pvt.services.ChiNhanhServices;
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


public class ChiNhanhServicesTest {
    private static ChiNhanhServices chiNhanhSV;
    private static Connection conn;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        chiNhanhSV = new ChiNhanhServices();
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testSuccessThemChiNhanh() throws SQLException {

        ChiNhanh cn = new ChiNhanh(23, "Chi Nhánh 1", "97 Vo Van Tan");
        chiNhanhSV.ThemChiNhanh(cn);

        String sql = "SELECT * FROM chinhanh WHERE tenchinhanh = N?";

        PreparedStatement stm = conn.prepareStatement(sql);
        stm.setString(1, "Chi Nhánh 1");

        ResultSet rs = stm.executeQuery();
        boolean kt = false;
        while (rs.next()) {
            if (rs.getInt("id") == 23) {
                kt = true;
                break;
            }
            else{
                kt = false;
            }
        }
        Assertions.assertTrue(kt);
        
    }
    
    @Test
    public void testFailerThemChiNhanh() throws SQLException{ 
        ChiNhanh cn = new ChiNhanh(1, "Chi Nhánh 11", "97 Vo Van Tan");
        try {
            chiNhanhSV.ThemChiNhanh(cn);
        }
        catch (SQLException ex) {
             Assertions.assertNotEquals("Duplicate entry '1' for key 'chinhanh.idChiNhanh_UNIQUE'", ex.getMessage());
        }
    }
    
    
}
