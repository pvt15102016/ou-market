/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.servicesTest;

import com.pvt.pojo.User;
import com.pvt.services.UserServices;
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
public class UserServicesTest {
    
    private static UserServices user;
    private static Connection conn;
    
    public static void beforeAll() {
        try {
            conn = JDBCUtils.getConn();
        } catch (SQLException ex) {
            Logger.getLogger(UserServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        user = new UserServices();
    }
    
    @AfterAll
    public static void afterAll() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserServicesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}
