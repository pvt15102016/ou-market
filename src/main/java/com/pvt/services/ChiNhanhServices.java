    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.pojo.ChiNhanh;
import com.pvt.utils.JDBCUtils;
import com.pvt.utils.Utils;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;


public class ChiNhanhServices {
    public List<ChiNhanh> getChiNhanh() throws SQLException{
        List<ChiNhanh> results = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            Statement stm = conn.createStatement() ;
             ResultSet rs = stm.executeQuery("SELECT * FROM chinhanh");
            while ( rs.next()){
                ChiNhanh c = new ChiNhanh(rs.getInt("id"), rs.getString("tenchinhanh"),rs.getString("diachi"));
                results.add(c);
             }
        }
        catch (SQLException ex){
            Utils.showBox("Lỗi không lấy được danh sách chi nhánh", Alert.AlertType.ERROR).show();
        }
        return results;
    }
    public void ThemChiNhanh(ChiNhanh cn) throws SQLException{
        try(Connection conn= JDBCUtils.getConn()){
            conn.setAutoCommit(false);
            PreparedStatement stm =conn.prepareStatement("INSERT INTO chinhanh(id,tenchinhanh,diachi) VALUES(?,?,?)");
            stm.setInt(1, cn.getId());
            stm.setString(2, cn.getTenChiNhanh());
            stm.setString(3, cn.getDiaChi());                      
            stm.executeUpdate();
            conn.commit();
        }
        catch (SQLException ex){
            Utils.showBox("Lỗi không thêm được chi nhánh", Alert.AlertType.ERROR).show();
        }
    }

    public void addChiNhanh (ChiNhanh cn) throws SQLException{
         try(Connection conn = JDBCUtils.getConn()){
            conn.setAutoCommit(false);
            PreparedStatement stm = conn.prepareStatement("INSERT INTO chinhanh(id,tenchinhanh,diachi) VALUES (?,?,?)");
            stm.setInt(1, cn.getId());
            stm.setString(2, cn.getTenChiNhanh());
            stm.setString(3, cn.getDiaChi());
            stm.executeUpdate();
            conn.commit(); 
         }catch (SQLException ex){
            Utils.showBox("Lỗi không thêm được chi nhánh", Alert.AlertType.ERROR).show();
        }
     }

    public List<ChiNhanh> TimChiNhanh(String kw) throws SQLException{
        List<ChiNhanh> chinhanhs = new ArrayList<>();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM chinhanh";
            if( kw != null && !kw.isEmpty()){
                sql += " WHERE tenchinhanh like concat('%',?,'%')";
            }

            PreparedStatement stm = conn.prepareStatement(sql);
            if( kw != null && !kw.isEmpty()){
                stm.setString(1, kw);
            }

            ResultSet rs = stm.executeQuery();

            while (rs.next()){
                ChiNhanh cn = new ChiNhanh(rs.getInt("id"),rs.getString("tenchinhanh"),rs.getString("diachi"));
                chinhanhs.add(cn);
            }
         }catch (SQLException ex){
            Utils.showBox("Lỗi không tìm được chi nhánh", Alert.AlertType.ERROR).show();
        }
        return chinhanhs;
      }
    public void CapNhatChiNhanh (ChiNhanh cn)throws SQLException{
        try(Connection conn= JDBCUtils.getConn()){
            PreparedStatement stm=conn.prepareStatement("UPDATE chinhanh\n"
                    + "SET tenchinhanh = ?,diachi = ?"
                    + "WHERE id = ?" );
            stm.setString(1, cn.getTenChiNhanh());       
            stm.setString(2, cn.getDiaChi());
            stm.setInt(3, cn.getId());
            stm.executeUpdate();
            }catch (SQLException ex){
            Utils.showBox("Lỗi không cập nhật được chi nhánh", Alert.AlertType.ERROR).show();
        }
        }
    public void XoaChiNhanh (ChiNhanh cn) throws SQLException{
        try (Connection conn = JDBCUtils.getConn()) {
            String sql = "DELETE FROM chinhanh WHERE (id = ?);";  
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, cn.getId());
            stm.executeUpdate();
        }catch (SQLException ex){
            Utils.showBox("Lỗi không xóa được chi nhánh", Alert.AlertType.ERROR).show();
        }
    }
}
