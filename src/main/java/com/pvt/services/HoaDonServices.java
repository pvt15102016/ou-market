/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.oumarket.FHomeController;
import com.pvt.oumarket.FLoginController;
import com.pvt.pojo.HoaDon;
import com.pvt.utils.JDBCUtils;
import com.pvt.utils.Utils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class HoaDonServices {
    public void addHoaDon(HoaDon hd) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("INSERT INTO hoadon(id, ngayxuat, nhanvien_id, khachhang_id, chinhanh_id, tiennhan, giatricuoi)  "
                    + " VALUES(?, CURDATE(), ?, ?, ?) ");
            stm.setInt(1, hd.getId());
            stm.setInt(2, hd.getMaNV());
            stm.setInt(3, hd.getMaKH());
            stm.setInt(4, hd.getMaCN());
            stm.setInt(5, hd.getTienNhan());
            stm.setInt(6, hd.getTienNhan());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không tạo được hóa đơn", Alert.AlertType.ERROR).show();
            }
    }
    public void CapNhatHoaDon(HoaDon hd) throws  SQLException{
            try(Connection conn = JDBCUtils.getConn()){
                PreparedStatement stm= conn.prepareStatement("UPDATE hoadon\n"
                        + "set ngayxuat=CURDATE(), nhanvien_id=?, khachhang_id=?, chinhanh_id=?, tiennhan=?, giatricuoi=? "
                        + "where id=? ");
                stm.setInt(1, hd.getMaNV());
                stm.setInt(2, hd.getMaKH());
                stm.setInt(3, hd.getMaCN());
                stm.setInt(4, hd.getTienNhan());
                stm.setFloat(5, hd.getGiaTriCuoi());
                stm.setInt(6, hd.getId());
                stm.executeUpdate();
            }
             catch (SQLException ex) {
             Utils.showBox("Lỗi không cập nhật được chi tiết hóa đơn", Alert.AlertType.ERROR).show();
            }
     }
    public HoaDon TaoHoaDonTrong() throws SQLException{
        HoaDon newhd = new HoaDon();
        try(Connection conn = JDBCUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("INSERT INTO hoadon(id) "
                    + " VALUES(?) ");
            stm.setInt(1, getMaxHoaDon()+1);
            stm.executeUpdate();    
            newhd.setId(getMaxHoaDon()+1);
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không tạo được hóa đơn", Alert.AlertType.ERROR).show();
            }
        return newhd ;
    }
    public int getMaxHoaDon() throws SQLException{
        int maxID = 0 ;
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT MAX(id) FROM hoadon";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
                maxID = rs.getInt("MAX(id)");  
        }
        catch (SQLException ex){
            Utils.showBox("Lỗi không lấy được mã hóa đơn", Alert.AlertType.ERROR).show();
        }
        return maxID;
    }
    public HoaDon getHoaDon(int id) throws SQLException{
        HoaDon hd = new HoaDon() ;
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM hoadon WHERE id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                hd.setId(rs.getInt("id"));
                hd.setNgayXuatDon(rs.getDate("ngayxuat"));
                hd.setMaNV(rs.getInt("nhanvien_id"));
                hd.setMaKH(rs.getInt("khachhang_id"));
            }
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được hóa đơn", Alert.AlertType.ERROR).show();
            }
        return hd;
    }
    public List<HoaDon> getListHoaDon() throws SQLException
    {
        List<HoaDon> ListHoaDon = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM hoadon ";
            PreparedStatement stm = conn.prepareStatement(sql);      
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt("id"));
                hd.setNgayXuatDon(rs.getDate("ngayxuat"));
                hd.setMaNV(rs.getInt("nhanvien_id"));
                hd.setMaKH(rs.getInt("khachhang_id"));
                ListHoaDon.add(hd);
            }
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được danh sách hóa đơn", Alert.AlertType.ERROR).show();
            }
        return ListHoaDon;
    }
    public float GetTongTien(HoaDon hd) throws SQLException{
        float max = 0;
        try (Connection conn = JDBCUtils.getConn()) {
                String sql = "SELECT hoadon_id,\n" +
                        "SUM(soluong*dongia) AS total\n" +
                        "FROM chitiet_hoadon\n" +
                        "WHERE hoadon_id=?";  
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, hd.getId());
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                max = rs.getFloat("total");
            }         
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không xóa được hóa đơn", Alert.AlertType.ERROR).show();
//                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);     
            }
        return max;
    }
    public void XoaHoaDon (HoaDon hd) throws SQLException{
        try (Connection conn = JDBCUtils.getConn()) {
            String sql = "DELETE FROM hoadon WHERE (id = ?);";  
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, hd.getId());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không xóa được hóa đơn", Alert.AlertType.ERROR).show();
            }
    }
}
