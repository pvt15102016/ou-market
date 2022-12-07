/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pvt.oumarket;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 * @author tien
 */
public class FMainPageController implements Initializable {
    @FXML
    private Pane paneNhanVien, paneChiNhanh, paneHangHoa, paneThanhToan, paneKhachHang;
    
    @FXML
    private Button btnNhanVien, btnChiNhanh, btnHangHoa, btnThanhToan, btnKhachHang;
    
    @FXML
    private void handleButtonAction (ActionEvent event){
        if (event.getSource() == btnNhanVien){
            paneNhanVien.toFront();
        }
        else if (event.getSource() == btnChiNhanh){
            paneChiNhanh.toFront();
        }
        else if (event.getSource() == btnHangHoa){
            paneHangHoa.toFront();
        }
        else if (event.getSource() == btnThanhToan){
            paneThanhToan.toFront();
        }
        else if (event.getSource() == btnKhachHang){
            paneKhachHang.toFront();
        }
        else {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
