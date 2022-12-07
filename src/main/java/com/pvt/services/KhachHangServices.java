/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.pojo.KhachHang;
import com.pvt.utils.JDBCUtils;
import com.pvt.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;


public class KhachHangServices {
     public List<KhachHang> getListKhachHang(String kw) throws SQLException
    {
        List<KhachHang> KhachHangs = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM khachhang";
            if(kw != null && !kw.isEmpty())
                sql +=  " WHERE id like concat('%', ?, '%') OR tenkhachhang like concat('%', ?, '%') ";
            PreparedStatement stm = conn.prepareStatement(sql);
            if(kw != null && !kw.isEmpty())
            {
                stm.setString(1, kw);
                stm.setString(2, kw);
            }        
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                KhachHang kh = new KhachHang(rs.getInt("id"), rs.getString("tenkhachhang"),rs.getDate("ngaythamgia")
                        , rs.getString("sodienthoai"), rs.getString("cmnd"), rs.getDate("ngaysinh"));
                KhachHangs.add(kh);
            }
        }
        return KhachHangs;
    }
         public int LayMaxKhachHang()throws SQLException{
        int maxID=0;
        try(Connection conn= JDBCUtils.getConn()){
            String sql="SELECT MAX(id) FROM khachhang";
            PreparedStatement stm=conn.prepareStatement(sql); 
            ResultSet rs = stm.executeQuery();
            while(rs.next())
                maxID=rs.getInt(1);
        }return (maxID+1);
    }
    
    public void ThemKhachHang(KhachHang kh) throws SQLException{
        try(Connection conn= JDBCUtils.getConn()){
            PreparedStatement stm =conn.prepareStatement("INSERT INTO khachhang(id, tenkhachhang, ngaythamgia, sodienthoai"
                    + ", cmnd, ngaysinh)"
                    + "VALUES(?, ?, ?, ?,?,?)");
            stm.setInt(1, kh.getId());
            stm.setString(2, kh.getTenKH());
            stm.setDate(3, kh.getNgayThamGia());
            stm.setString(4, kh.getSDT());           
            stm.setString(5, kh.getCmnd());
            stm.setDate(6, kh.getNgaySinh());                       
            stm.executeUpdate();
        }
     }

    public KhachHang ChonKhachHang(int id) throws SQLException{
        KhachHang kh = null;
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM khachhang Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(id));  
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                kh = new KhachHang(rs.getInt("id"), rs.getString("tenkhachhang"),rs.getDate("ngaythamgia")
                        , rs.getString("sodienthoai"), rs.getString("cmnd"), rs.getDate("ngaysinh"));
            }
        }
        return kh;
    }
    public void CapNhatKhachhang (KhachHang kh)throws SQLException{
        try(Connection conn= JDBCUtils.getConn()){
            PreparedStatement stm=conn.prepareStatement("UPDATE khachhang\n"
                    + "tenkhachhang = ?, ngaythamgia = ?, sodienthoai = ?, cmnd = ?, ngaysinh = ?"
                    + "where id = ?" );
            stm.setString(1, kh.getTenKH());       
            stm.setDate(2, kh.getNgayThamGia());
            stm.setString(3, kh.getSDT());
            stm.setString(4, kh.getCmnd());
            stm.setDate(5, kh.getNgaySinh());
            stm.setInt(6, kh.getId());
            stm.executeUpdate();
             }
        }
    public void XoaKhachHang (int maKH) throws SQLException{
        try (Connection cnn = JDBCUtils.getConn()) {
            String sql = "DELETE FROM account WHERE (id = ?);";  
            PreparedStatement stm2 = cnn.prepareStatement(sql);
            stm2.setInt(1, maKH);
            stm2.execute();
        }
    }
    public int getDayOfBirth(int id)throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT day(ngaysinh) AS day_col FROM khachhang WHERE id=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt("day_col");
            }
        }
        catch (SQLException ex){
            Utils.showBox("Không lấy được ngày sinh", Alert.AlertType.ERROR).show();
        }
        return -1;
    }
    public int getMonthOfBirth(int id)throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "select month(ngaysinh) as month_col FROM khachhang WHERE id=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt("month_col");
            }
        }
        catch (SQLException ex){
            Utils.showBox("Không lấy được tháng sinh", Alert.AlertType.ERROR).show();
        }
        return -1;
    }
}
