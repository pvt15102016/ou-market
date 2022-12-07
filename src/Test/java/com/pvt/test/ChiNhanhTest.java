package com.pvt.test;

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


public class ChiNhanhTest {
    private static ChiNhanhServices chinhanhSV;
    private static Connection conn;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        chinhanhSV = new ChiNhanhServices();
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testSuccessThemChiNhanh() throws SQLException {
        String idChiNhanh;
        try(Connection conn = JDBCUtils.getConn()) {
            ChiNhanh cn = new ChiNhanh(4, "Chi Nhánh 3", "97 Vo Van Tan");
            chinhanhSV.ThemChiNhanh(cn);
            
            String sql = "SELECT idChiNhanh FROM chinhanh WHERE TenChiNhanh = N?";
            
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(2, "Chi Nhánh 3");
            
            ResultSet rs = stm.executeQuery();
            
            while (rs.next()) {
                Assertions.assertEquals("1", rs.getString("idChiNhanh"));    
            }
        }
    }
}
