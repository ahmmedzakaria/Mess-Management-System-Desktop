/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import com.jfoenix.controls.JFXButton;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Zakakaria
 */
public class Utility {
    public static String mealRet;
    public static String ttlDiposit;
    public static String avilableMony;
    public static String accountentId="1";
    public static String accountId=String.valueOf(db.AccountDbController.getLastAccountId());
    public static int tabIndex=0;
    public static String accountFor;
    public static final String MANAGER = "manager";
    public static final String ACCOUNTANT = "accountent";
    public static String systemDate = new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
    public static String sysDateTime = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    public static void closeWindow(JFXButton btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }
    
    public  void openWindow(Pane pane, String resource, String title){
         try {
            pane=FXMLLoader.load(getClass().getResource(resource));
            Stage stage=new Stage();
            stage.setTitle(title);
            stage.setScene(new Scene(pane));
            stage.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void showDialog(Alert.AlertType alertType,String title,String headerText,String massage){
        Alert alert = new Alert(alertType);
            alert.setTitle(title);
            alert.setHeaderText(headerText);
            alert.setContentText(massage);
            alert.showAndWait();
    }
    public void loadFXML(HBox hBoxContainer,String fxmlFileName){
        try {
            Pane pane = FXMLLoader.load(getClass().getResource(fxmlFileName));
            hBoxContainer.getChildren().setAll(pane);
                                hBoxContainer.setAlignment(Pos.CENTER);
                                hBoxContainer.setHgrow(pane, Priority.ALWAYS);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public static void copyFileToDirectory(File source, File distination){
         try {
            if(source!=null){
                Files.copy(source.toPath(), distination.toPath());
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static File openFileChooser(File path){
        FileChooser chooser = new FileChooser();
        chooser.setInitialDirectory(path);
        File file = chooser.showOpenDialog(null);

        path = new File(file.getParent());
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Image", "*.png")
        );
        return file;
    }
}
