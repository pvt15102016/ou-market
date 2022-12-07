package com.pvt.oumarket;

import com.pvt.pojo.User;
import com.pvt.services.UserServices;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;

/**
 * JavaFX App
 */
public class App extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
            try{
                scene = new Scene(loadFXML("FLogin"));
                stage.setScene(scene);
                stage.show();
                stage.setScene(scene);
                stage.setTitle("OUMarket - Login page");
                Image image = new Image("/com.pvt.pictures/OUMarket.png");
                stage.getIcons().add(image);
                stage.setOnCloseRequest(event -> {
                    event.consume();
                    try {
                        Exit(stage);
                    } catch (SQLException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } catch (Exception e){
                e.printStackTrace();
            }
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    public void Exit (Stage stage)throws SQLException,  IOException{
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Bạn chuẩn bị thoát chương trình");
        alert.setContentText("Bạn có muốn thoát chương trình?");
        
        if (alert.showAndWait().get() == ButtonType.OK){
//            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            UserServices usv = new UserServices();
            try{
                usv.XoaLoginUser();
            }catch(SQLException ex){
                Logger.getLogger(FHomeController.class.getName()).log(Level.SEVERE, null, ex);      
            }
            stage.close();
        }
    }

}