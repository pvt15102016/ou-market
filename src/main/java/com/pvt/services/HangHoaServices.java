/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.oumarket.FHomeController;
import com.pvt.pojo.HangHoa;
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


public class HangHoaServices {
    public List<HangHoa> getListHangHoa() throws SQLException {
       List<HangHoa> listHangHoa = new ArrayList<>();
       try(Connection conn = JDBCUtils.getConn()){
           String sql = "SELECT * FROM hanghoa";
           PreparedStatement stm = conn.prepareStatement(sql);
           ResultSet rs = stm.executeQuery();
           while(rs.next()){
               HangHoa ha = new HangHoa(
                       rs.getInt("id"), 
                       rs.getString("tenhanghoa"),
                       rs.getString("xuatxu"),
                       rs.getInt("dongia"));
               listHangHoa.add(ha);
           }
       }
       catch (SQLException ex) {
             Utils.showBox("Lỗi không lấy được danh sách hàng hóa", Alert.AlertType.ERROR).show();
            }
       return listHangHoa;
   }
    public void ThemHangHoa(HangHoa ha) throws  SQLException{
            try(Connection conn = JDBCUtils.getConn()){
                conn.setAutoCommit(false);
                PreparedStatement stm= conn.prepareStatement("INSERT INTO hanghoa(tenhanghoa,xuatxu,dongia)" + "VALUES(?,?,?)");
//                stm.setInt(1, ha.getId());
                stm.setString(1, ha.getTenHangHoa());
                stm.setString(2, ha.getXuatXu());
                stm.setInt(3, ha.getDonGia());
                stm.executeUpdate();
                conn.commit();
            }
            catch (SQLException ex){
            Utils.showBox("Lỗi không thêm được hàng hóa", Alert.AlertType.ERROR).show();
        }
        }
    public void suaHangHoa(HangHoa ha) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
          
            PreparedStatement stm = conn.prepareStatement("UPDATE hanghoa\n"
                   + "SET tenhanghoa =?,xuatxu =?,dongia =? "
                   + "WHERE id=?" );      
            
//            UPDATE hanghoa SET tenhanghoa=?,xuatxu=?,dongia=? WHERE id=?
            stm.setString(1, ha.getTenHangHoa());
            stm.setString(2, ha.getXuatXu());
            stm.setInt(3, ha.getDonGia());           
            stm.setInt(4, ha.getId());
            stm.executeUpdate();
        }
        catch (SQLException ex){
            Utils.showBox("Lỗi không sửa được hàng hóa", Alert.AlertType.ERROR).show();
        }
    }
    public void xoaHangHoa (HangHoa ha) throws SQLException{
        try (Connection cnn = JDBCUtils.getConn()) {
            String sql = "DELETE FROM hanghoa WHERE id=?;";
            PreparedStatement stm = cnn.prepareStatement(sql);
            stm.setInt(1, ha.getId());
            stm.executeUpdate();
        }
        catch (SQLException ex){
          Utils.showBox("Lỗi không xóa được hàng hóa", Alert.AlertType.ERROR).show();
        }
    }
   
    public List<HangHoa> TimHangHoa(String kw) throws SQLException{
        List<HangHoa> hanghoas = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM hanghoa";
            if( kw != null && !kw.isEmpty()){
                sql += " WHERE tenhanghoa like concat('%',?,'%')";
            }

            PreparedStatement stm = conn.prepareStatement(sql);
            if( kw != null && !kw.isEmpty()){
                stm.setString(1, kw);
            }

            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                HangHoa hh = new HangHoa(rs.getInt("id"),rs.getString("tenhanghoa"),rs.getString("xuatxu"),rs.getInt("dongia"));
                hanghoas.add(hh);
            }
         }
        catch (SQLException ex){
            Utils.showBox("Lỗi không tìm được hàng hóa", Alert.AlertType.ERROR).show();
        }
        return hanghoas;
      }
}
