/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.oumarket.FHomeController;
import com.pvt.pojo.KhuyenMai;
import com.pvt.utils.JDBCUtils;
import com.pvt.utils.Utils;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class KhuyenMaiServices {
    public List<KhuyenMai> getListKhuyenMai(String kw) throws SQLException
    {
        List<KhuyenMai> ListKhuyenMai = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM khuyenmai";
            if(kw != null && !kw.isEmpty())
                sql +=  " WHERE (id like concat('%', ?, '%')) ";
            PreparedStatement stm = conn.prepareStatement(sql);
            if(kw != null && !kw.isEmpty())
            {
                stm.setString(1, kw);
                stm.setString(2, kw);
            }        
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                KhuyenMai km = new KhuyenMai();
                km.setId(rs.getInt("hanghoa_id"));
                km.setNgayBatDau(rs.getDate("ngaybatdau"));
                km.setNgayKetThuc(rs.getDate("ngayketthuc"));
                km.setGiaKhuyenMai(rs.getInt("giakhuyenmai"));
                ListKhuyenMai.add(km);
            }
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được danh sách khuyến mãi", Alert.AlertType.ERROR).show();
            }
        return ListKhuyenMai;
    }
     public List<KhuyenMai> TimKhuyenMai(String kw) throws SQLException{
        List<KhuyenMai> kms = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM khuyenmai";
            if( kw != null && !kw.isEmpty()){
                sql += " WHERE hanghoa_id like concat('%',?,'%')";
            }

            PreparedStatement stm = conn.prepareStatement(sql);
            if( kw != null && !kw.isEmpty()){
                stm.setString(1, kw);
            }

            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                KhuyenMai km = new KhuyenMai(rs.getInt("hanghoa_id"),rs.getDate("ngaybatdau"),rs.getDate("ngayketthuc"),rs.getInt("giakhuyenmai"));
                kms.add(km);
            }
         }catch (SQLException ex) {
             Utils.showBox("Lỗi không tìm được khuyến mãi", Alert.AlertType.ERROR).show();
            }
        return kms;
      }
    public void ThemKhuyenMai(KhuyenMai km) throws  SQLException{
            try(Connection conn = JDBCUtils.getConn()){
              
                PreparedStatement stm= conn.prepareStatement("INSERT INTO khuyenmai(hanghoa_id, ngaybatdau, ngayketthuc, giakhuyenmai)" 
                        + " VALUES (?,?,?,?) ");
                stm.setInt(1, km.getId());
                stm.setDate(2,(Date) km.getNgayBatDau());
                stm.setDate(3,(Date) km.getNgayKetThuc());
                stm.setInt(4, km.getGiaKhuyenMai());
                stm.executeUpdate();
            }
            catch (SQLException ex) {
             Utils.showBox("Lỗi không thêm được khuyến mãi", Alert.AlertType.ERROR).show();
            }
        }
    public void CapNhatKhuyenMai(KhuyenMai km) throws  SQLException{
            try(Connection conn = JDBCUtils.getConn()){
                PreparedStatement stm= conn.prepareStatement("UPDATE khuyenmai\n"
                        + "set ngaybatdau=?, ngayketthuc=?, giakhuyenmai=? "
                        + "where hanghoa_id =?");
                stm.setDate(1, km.getNgayBatDau());
                stm.setDate(2, km.getNgayKetThuc());
                stm.setInt(3, km.getGiaKhuyenMai());
                stm.setInt(4, km.getId());
                stm.executeUpdate();       
            }
             catch (SQLException ex) {
             Utils.showBox("Lỗi không cập nhật được khuyến mãi", Alert.AlertType.ERROR).show();
            }
     }
    public void XoaKhuyenMai(KhuyenMai km) throws SQLException{
            try(Connection conn = JDBCUtils.getConn()){
                String sql = "DELETE FROM khuyenmai WHERE (hanghoa_id=? AND ngaybatdau=? ) ";
                PreparedStatement stm = conn.prepareStatement(sql);
                stm.setInt(1, km.getId());
                stm.setDate(2, km.getNgayBatDau());
                stm.executeUpdate();
            }catch (SQLException ex) {
             Utils.showBox("Lỗi không xóa được khuyến mãi", Alert.AlertType.ERROR).show();
            }
        }
    
    public boolean checkIdKM (KhuyenMai km){
       try(Connection conn = JDBCUtils.getConn()){
                PreparedStatement stm= conn.prepareStatement("SELECT id FROM hanghoa where id=? ");             
                stm.setInt(1, km.getId());              
                ResultSet rs = stm.executeQuery();
                if(rs.next())
                    return true;           
            }
            catch (SQLException ex) {
             Utils.showBox("Lỗi không kiểm tra được khuyến mãi", Alert.AlertType.ERROR).show();
            }
        return false;
       }
}
