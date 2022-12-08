/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pvt.oumarket;


//import com.pvt.utils.HashP;
import com.pvt.pojo.ChucVu;
import com.pvt.utils.Utils;
import com.pvt.pojo.User;
import com.pvt.services.ChucVuServices;
import com.pvt.utils.JDBCUtils;
import com.pvt.services.UserServices;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


//Controller cho Login
public class FLoginController implements Initializable {
    @FXML private ComboBox<ChucVu> cbChucVu ;
    @FXML private AnchorPane myPane;
    @FXML public TextField txtUsername;
    @FXML public TextField txtPassword;
    @FXML public Button btnDangNhap;
    @FXML public Tab NhanVienTab;
    @FXML public Tab ChiNhanhTab;
    public static String username;
    public static String password;
    public static boolean login = false;
    public static int thisId;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        List<ChucVu> cv;
        ChucVuServices s = new ChucVuServices();
        try{
            cv = s.getChucVu();
               this.cbChucVu.setItems(FXCollections.observableList(cv));
               cbChucVu.setValue(cv.get(0));
               
        }catch(Exception ex){
                    Logger.getLogger(FLoginController.class.getName()).log(Level.SEVERE, null, ex);      
        }
    }
    public void showInfo(ActionEvent event)throws Exception{
        Utils.showBox("OUMarket Project\n PhanVanTien\n TuanTiep\n Thach\n ThachThiMyDung\n "
                + "End date: 09/12/2022", Alert.AlertType.INFORMATION).show();
    }
    
    public void btnDangNhap (ActionEvent event)throws SQLException,  IOException{
//        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(getClass().getResource("FHome.fxml"));
//        Parent d = loader.load();
//        Scene scene = new Scene(d);
//        stage.setScene(scene);
        boolean check = false;
        String option = this.cbChucVu.getSelectionModel().getSelectedItem().toString();
        
         if (this.txtUsername.getText().equals("") ||
            this.txtPassword.getText().equals("") || option.equals("Chon chuc vu")){
            Utils.showBox("Vui long dien day du thong tin!", Alert.AlertType.WARNING).show();
            
         }
         else if (txtUsername.getText().contains(" ") || txtPassword.getText().contains(" "))
         {
             Utils.showBox("Username or password does not contain white space!", Alert.AlertType.WARNING).show();
         }
         else {
              try(Connection conn = JDBCUtils.getConn()){
                   PreparedStatement pr = conn.prepareStatement("SELECT * FROM user\n"
                           + "WHERE username=? AND password = ? ");
                   
                   pr.setString(1, this.txtUsername.getText());
                   pr.setString(2, this.txtPassword.getText());
                   ResultSet rs = pr.executeQuery();
                  
                   if (rs.next()){
                        
                    String s1 = rs.getString("userrole_id");
                    if (option.equalsIgnoreCase("Quản lý") &&  s1.equalsIgnoreCase("1")){
                            Utils.showBox("admin successfull!", Alert.AlertType.INFORMATION).show();
                            check = true;
                    }                     
                    if (option.equalsIgnoreCase("Nhân Viên") &&  s1.equalsIgnoreCase("2") && check != true ){
                            Utils.showBox("user successfull!", Alert.AlertType.INFORMATION).show(); 
                            check = true;                 
                    }
                        
                    if (check == true){
                        btnDangNhap.setOnAction(e ->{
                        username =txtUsername.getText();
                        password =txtPassword.getText();
                    });
                          Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
                          FXMLLoader loader = new FXMLLoader();
                          loader.setLocation(getClass().getResource("FHome.fxml"));
                          Parent d = loader.load();
                          Scene scene = new Scene(d,1036,640);
                          stage.setMaxHeight(640);
                          stage.setMaxWidth(1036);
                          stage.setScene(scene);
                          stage.setTitle("OUMarket");
                          UserServices usv = new UserServices();
                          FHomeController controller = loader.getController();
                          controller.getThisId(usv.GetIdUser(txtUsername.getText(), txtPassword.getText()));
                    }
                    else{
                            Utils.showBox("Sai chuc vu", Alert.AlertType.WARNING).show();                      
                        }                        
                   }
                   else{
                         Utils.showBox("Sai pass hoac ten tk", Alert.AlertType.WARNING).show();                      
                         }
               }           
         }
    }
}


