/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.oumarket.FHomeController;
import com.pvt.utils.JDBCUtils;
import com.pvt.pojo.NhanVien;
import com.pvt.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class NhanVienServices {
    public List<NhanVien> getListNhanVien(String kw) throws SQLException{
        List<NhanVien> nhanViens = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM nhanvien";
            if(kw != null && !kw.isEmpty()){
                sql += " WHERE id like concat('%', ? ,'%') OR hoten like concat('%', ? ,'%')";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if(kw != null && !kw.isEmpty()){
                stm.setString(1, kw);
                stm.setString(2, kw);
            }
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
               NhanVien n = new NhanVien(
                       rs.getInt("id"), 
                       rs.getString("hoten"), 
                       rs.getDate("ngaybatdau"), 
                       rs.getDate("ngayketthuc"), 
                       rs.getString("sodienthoai"), 
                       rs.getString("cmnd"), 
                       rs.getInt("chucvu_id"),
                       rs.getInt("tienluong"),
                        rs.getInt("chinhanh_id"),
                        rs.getInt("user_id"));
               nhanViens.add(n);
           }
       }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được danh sách nhân viên", Alert.AlertType.ERROR).show();
            }
       return nhanViens;
   }
    public void ThemNhanVien(NhanVien nv) throws SQLException, IOException{
        try(Connection conn= JDBCUtils.getConn())
        {
            PreparedStatement stm= conn.prepareStatement("INSERT INTO nhanvien(id,hoten,ngaybatdau,ngayketthuc,sodienthoai,"
                    + "cmnd,chucvu_id,chinhanh_id,tienluong,user_id)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            stm.setInt(1, nv.getId());           
            stm.setString(2, nv.getHoTen());
            stm.setDate(3, (Date)nv.getNgayBatDau());
            stm.setDate(4, (Date)nv.getNgayKetThuc());
            stm.setString(5, nv.getSdt());
            stm.setString(6, nv.getCmnd());
            stm.setInt(7, nv.getMaChucVu());
            stm.setInt(8, nv.getMaChiNhanh());
            stm.setInt(9, nv.getTienLuong());
            stm.setInt(10, nv.getMaTK());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không thêm được nhân viên", Alert.AlertType.ERROR).show();
            }
    }
    public void updateNhanVien(NhanVien nv) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("UPDATE NhanVien\n"
                 + "SET hoten=? ,ngaybatdau=? ,ngayketthuc=? , "
                    + "sodienthoai=? ,cmnd=? ,chucvu_id=? ,chinhanh_id=? ,tienluong=? ,user_id=? "
                 + "where id=? ");
            stm.setInt(10, nv.getId());           
            stm.setString(1, nv.getHoTen());
            stm.setDate(2, (Date)nv.getNgayBatDau());
            stm.setDate(3, (Date)nv.getNgayKetThuc());
            stm.setString(4, nv.getSdt());
            stm.setString(5, nv.getCmnd());
            stm.setInt(6, nv.getMaChucVu());
            stm.setInt(7, nv.getMaChiNhanh());
            stm.setInt(8, nv.getTienLuong());
            stm.setInt(9, nv.getMaTK());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không cập nhật được nhân viên", Alert.AlertType.ERROR).show();
            }
    }
    public void XoaNhanVien (NhanVien nv) throws SQLException{
        try (Connection cnn = JDBCUtils.getConn()) {
            String sql = "DELETE FROM nhanvien WHERE (id = ?);";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, nv.getId());
            stm.execute();
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không xóa được nhân viên", Alert.AlertType.ERROR).show();
            }
    }
    public NhanVien getNhanVien(int maNV) throws SQLException{
        NhanVien nv;
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM nhanvien Where id = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, Integer.toString(maNV));  
            ResultSet rs = stm.executeQuery();
            if(!rs.next()){
                return null;
            }else{
                nv = new NhanVien(
                       rs.getInt("id"), 
                       rs.getString("hoten"), 
                       rs.getDate("ngaybatdau"), 
                       rs.getDate("ngayketthuc"), 
                       rs.getString("sodienthoai"), 
                       rs.getString("cmnd"), 
                       rs.getInt("chucvu_id"),
                        rs.getInt("chinhanh_id"),
                       rs.getInt("tienluong"),
                        rs.getInt("user_id"));
            }
        }           
        return nv;
    }
    public List<NhanVien> TimNhanVien(String kw) throws SQLException{
        List<NhanVien> nhanviens = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM nhanvien";
            if(kw != null && !kw.isEmpty()){
                sql += " WHERE hoten like concat('%',?,'%')";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if( kw != null && !kw.isEmpty()){
                stm.setString(1, kw);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                NhanVien nv = new NhanVien(rs.getInt("id"),rs.getString("hoten"),rs.getDate("ngaybatdau"),
                rs.getDate("ngayketthuc"), rs.getString("sodienthoai"), 
                       rs.getString("cmnd"), 
                       rs.getInt("chucvu_id"),
                        rs.getInt("chinhanh_id"),
                        rs.getInt("tienluong"),
                        rs.getInt("user_id"));
                nhanviens.add(nv);
            }
         }catch (SQLException ex) {
             Utils.showBox("Lỗi không tìm được nhân viên", Alert.AlertType.ERROR).show();
            }
        return nhanviens;
      }
}   
