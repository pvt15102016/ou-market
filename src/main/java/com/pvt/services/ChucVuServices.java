/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.utils.JDBCUtils;
import com.pvt.pojo.ChucVu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ChucVuServices {
    public List<ChucVu> getListChucVu() throws SQLException {
//       List<ChucVu> ChucVus = new ArrayList<>();
//       try(Connection conn = JDBCUtils.getConn()){
//           String sql = "SELECT * FROM chucvu";
//           PreparedStatement stm = conn.prepareStatement(sql);
//           ResultSet rs = stm.executeQuery();
//           while(rs.next()){
//               ChucVu a = new ChucVu(
//                       rs.getInt("id"), 
//                       rs.getString("tenChucVu"));
//               ChucVus.add(a);
//           }
//       }
//       return ChucVus;
        List<ChucVu> results = new ArrayList<>();
                try(Connection conn = JDBCUtils.getConn()){
                    Statement stm = conn.createStatement() ;
                     ResultSet rs = stm.executeQuery("SELECT * FROM chucvu");
                    while ( rs.next()){
                        ChucVu c = new ChucVu(rs.getInt("id"), rs.getString("tenchucvu"));
                        results.add(c);

                     }
                }
                return results;
}
    public ChucVu getChucVu(String tenChucVu) throws SQLException{
        ChucVu cv = new ChucVu();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM chucvu Where tenchucvu = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, tenChucVu);  
            ResultSet rs = stm.executeQuery();
            if(!rs.next()){
                return null;
            }else{
                cv.setId(rs.getInt("id"));
                cv.setTenChucVu(rs.getString("tenchucvu"));
            }
        }
        return cv;
    }
        public List<ChucVu> getChucVu() throws SQLException{
            List<ChucVu> results = new ArrayList<>();
            try(Connection conn = JDBCUtils.getConn()){
                Statement stm = conn.createStatement() ;
                 ResultSet rs = stm.executeQuery("SELECT * FROM chucvu");
                while ( rs.next()){
                    ChucVu c = new ChucVu(rs.getInt("id"), rs.getString("tenchucvu"));
                    results.add(c);

                 }
            }
            return results;
        }

}
