/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

import com.pvt.pojo.HangHoa;
import com.pvt.services.HangHoaServices;
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
public class HangHoaServicesTest {
    
    private static Connection conn;
    private static HangHoaServices hhsv;
    
    @BeforeAll
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(ChiNhanhServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        hhsv = new HangHoaServices();
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
    public void testSuccessThemHangHoa() throws Exception{
        HangHoa hh = new HangHoa(99, "String", "Ho Chi Minh", 50000);
        hhsv.ThemHangHoa(hh);
        
        Assertions.assertEquals(1, hhsv.getListHangHoa().get(0).getId());
    }
    
    @Test
    public void testSuccessTimHangHoa() throws Exception{
        String kw = "Sting";
        List<HangHoa> hanghoa = hhsv.TimHangHoa(kw);
        for(HangHoa h:hanghoa){
            Assertions.assertTrue(h.getTenHangHoa().toLowerCase().contains(kw.toLowerCase()));
        }
    }
    
    @Test
    public void testSuccessXoaHangHoa() throws Exception{
        HangHoa hh = new HangHoa(40, "Sting", "Ho Chi Minh", 50000);
        hhsv.xoaHangHoa(hh);
        
        Assertions.assertEquals(1, hhsv.getListHangHoa().get(0).getId());
    }
    
    
}
