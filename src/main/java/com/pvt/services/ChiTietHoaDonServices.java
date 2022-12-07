/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.oumarket.FHomeController;
import com.pvt.pojo.ChiTietHoaDon;
import com.pvt.pojo.HangHoa;
import com.pvt.pojo.HoaDon;
import com.pvt.pojo.KhuyenMai;
import com.pvt.utils.JDBCUtils;
import com.pvt.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;


public class ChiTietHoaDonServices {
    public void ThemChiTietHoaDon(ChiTietHoaDon cthd) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            PreparedStatement stm = conn.prepareStatement("INSERT INTO chitiet_hoadon"
                    + " (soluong, dongia, hanghoa_id, hoadon_id) "
                    + " VALUES(?,?,?,?) ");
            PreparedStatement stm1 = conn.prepareStatement("SELECT hanghoa.id,hanghoa.tenhanghoa,khuyenmai.giakhuyenmai, hanghoa.dongia\n" +
                            "FROM hanghoa\n" +
                            "INNER JOIN khuyenmai\n" +
                            "on hanghoa.id = khuyenmai.hanghoa_id\n"
                            + "WHERE hanghoa.id=?");
            PreparedStatement stm2 = conn.prepareStatement("SELECT hanghoa.dongia\n" +
                            "FROM hanghoa\n"
                            + "WHERE hanghoa.id=?");
            stm1.setInt(1, cthd.getMaHangHoa());
            stm2.setInt(1, cthd.getMaHangHoa());
            ResultSet rs = stm1.executeQuery();
            ResultSet rs2 = stm2.executeQuery();
            if (rs2.next())
            {
                stm.setInt(2, rs2.getInt("dongia"));
            }
            if (rs.next()){
                stm.setInt(2, rs.getInt("giakhuyenmai"));
            }
            else
            {
                stm.setInt(2, rs2.getInt("dongia"));
            }
            
            
            stm.setFloat(1, cthd.getSoLuong());
            stm.setInt(3, cthd.getMaHangHoa());
            stm.setInt(4, cthd.getMaHoaDon());
            stm.executeUpdate();
        }catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được chi tiết hóa đơn", Alert.AlertType.ERROR).show();
            }
    }
    public void CapNhatChiTietHoaDon(ChiTietHoaDon cthd) throws  SQLException{
            try(Connection conn = JDBCUtils.getConn()){
                PreparedStatement stm= conn.prepareStatement("UPDATE chitiet_hoadon\n"
                        + "set soluong=?, dongia=? "
                        + "where hanghoa_id=? and hoadon_id=? ");
                stm.setFloat(1, cthd.getSoLuong());
                stm.setInt(2, cthd.getDonGia());
                stm.setInt(3, cthd.getMaHangHoa());
                stm.setInt(4, cthd.getMaHoaDon());
                stm.executeUpdate();
            }
             catch (SQLException ex) {
             Utils.showBox("Lỗi không cập nhật được chi tiết hóa đơn", Alert.AlertType.ERROR).show();
            }
     }
    public void XoaChiTietHoaDon (ChiTietHoaDon cthd) throws SQLException{
        try (Connection conn = JDBCUtils.getConn()) {
            String sql = "DELETE FROM chitiet_hoadon WHERE (hanghoa_id=? and hoadon_id=? ) ";  
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, cthd.getMaHangHoa());
            stm.setInt(2, cthd.getMaHoaDon());
            stm.executeUpdate();
        }
        catch (SQLException ex) {
             Utils.showBox("Lỗi không xóa được chi tiết hóa đơn", Alert.AlertType.ERROR).show();
            } 
        }
    public List<ChiTietHoaDon> TimCTHD(String kw) throws SQLException{
        List<ChiTietHoaDon> cts = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM chitiet_hoadon";
            if(kw != null && !kw.isEmpty()){
                sql += " WHERE hoadon_id like concat('%',?,'%')";
            }
            PreparedStatement stm = conn.prepareStatement(sql);
            if( kw != null && !kw.isEmpty()){
                stm.setString(1, kw);
            }
            ResultSet rs = stm.executeQuery();
            while (rs.next()){
                ChiTietHoaDon cthd = new ChiTietHoaDon((Float)rs.getFloat("soluong"),rs.getInt("dongia"),rs.getInt("hanghoa_id"),rs.getInt("hoadon_id"));
                cts.add(cthd);
            }
         }catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được chi tiết hóa đơn", Alert.AlertType.ERROR).show();
            }
        return cts;
      }
    
    
}
