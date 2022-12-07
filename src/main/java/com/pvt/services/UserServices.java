/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.services;

import com.pvt.oumarket.FHomeController;
import com.pvt.oumarket.FLoginController;
import com.pvt.pojo.User;
import com.pvt.utils.JDBCUtils;
import com.pvt.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author tien
 */
public class UserServices {
    public List<User> getListUser () throws SQLException{
        List<User> ListUser = new ArrayList<>();
        try(Connection conn= JDBCUtils.getConn()){
            String sql = "SELECT * FROM user";           
            PreparedStatement stm=conn.prepareStatement(sql);           
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                User s = new User();
                s.setId(rs.getInt("id"));
                s.setUserName(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setMaUserRole(rs.getInt("userrole_id"));
                ListUser.add(s);
            }
        }
        
        return ListUser;
    }
    public void addLoginUser(String username, String password)throws SQLException{
        try (Connection conn= JDBCUtils.getConn()) {
            String sql = "INSERT INTO loginuser(id,name,pass) VALUE(?,?,?)";   
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setInt(1, GetIdUser(username, password));
            stm.setString(2, username);
            stm.setString(3, password);
            stm.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            Utils.showBox("Unknown Error!", Alert.AlertType.ERROR).show();      
        }
    }
    public int GetIdLoginUser() throws SQLException{
        try (Connection conn= JDBCUtils.getConn()) {
            String sql = "SELECT id from loginuser ) ";   
            PreparedStatement stm=conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();           
            while(rs.next()){
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
           Utils.showBox("Get idloginuser thất bại!", Alert.AlertType.ERROR).show();      
        }
        return -1;
    }
    public String getUserName(int id) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT username FROM user where id=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
                return rs.getString("username");
            }
        }
        catch (SQLException ex){
            Utils.showBox("Get Username thất bại!", Alert.AlertType.ERROR).show(); 
        }
        return null;
    }
    public int getIdUserRole(int id) throws SQLException{
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT userrole_id FROM user where id=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
               return rs.getInt("userrole_id");
            }
        }
        catch (SQLException ex){
            Utils.showBox("Get IdUserrole thất bại!", Alert.AlertType.ERROR).show();         
        }
        return -1;
    }
    public int GetIdUser(String username, String password) throws SQLException{
        try (Connection conn= JDBCUtils.getConn()) {
            String sql = "SELECT id FROM user WHERE username=? AND password=?";   
            PreparedStatement stm=conn.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                return rs.getInt("id");
            }
        } catch (SQLException ex) {
            Utils.showBox("Get id thất bại!", Alert.AlertType.ERROR).show(); 
        }
        return -1;
    }
    public boolean KiemTraDangNhap(String username ,String password) throws SQLException{
        boolean check = false;
        Connection conn = JDBCUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from user where username = \'"+ username + "\'");
        String thisPassword = "";
        while(rs.next()){
            thisPassword = rs.getString("password");
        }
        if(thisPassword.equals(password))
            check = true;
        conn.close();
        return check;
    }
    
    public int checkAccount(String username ,String password) throws SQLException{
        int check = -1;
        Connection conn = JDBCUtils.getConn();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery("Select * from user where username = "+ username);
        String thisPassword = "";
        while(rs.next()){
            thisPassword = DigestUtils.md5Hex(password).toUpperCase();
        }
        if(thisPassword.equals(rs.getString("password")))
            check = rs.getInt("userrole_id");
        conn.close();
        return check;
    }
    
    public User NapUser(String username) throws SQLException{
        User user = new User();
        try(Connection conn = JDBCUtils.getConn()){
            String sql = "SELECT * FROM user WHERE username = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            if(!rs.next()){
                return null;
            }
            else{
                user.setId(rs.getInt("id"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setMaUserRole(rs.getInt("userrole_id"));
            }
        }
        
        return user;
    }
    public void XoaLoginUser() throws SQLException{
        try (Connection conn = JDBCUtils.getConn()) {
            String sql = "TRUNCATE TABLE loginuser";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.execute();
        }catch (SQLException ex){
            Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
