/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Utilities.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import db.dbController;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;


/**
 *
 * @author Zakakaria
 */
public class FXMLLoginController implements Initializable {
    private final String MANAGER="manager";
    private final String ACCOUNTANT="accountent";
    @FXML
    private JFXTextField accUserName, manUserName;

    @FXML
    private JFXPasswordField accPass, manPass;

    @FXML
    private JFXButton btnAccLogin, btnAccCreateAccount, btnManLogin, btnManCreateAcc;

        @FXML
    private JFXTabPane tabPane;
    AnchorPane anchorPane;
    LoginInfo info=new LoginInfo();
    // Utility utility=new Utility();
    
  

    @FXML
    void accountentLogin(ActionEvent event) {
        // new Utility().openWindow(anchorPane, "/members/FXMLAddMember.fxml", "Mess Management System");
        try {
            info.setUserName(accUserName.getText());
            info.setPass(accPass.getText());
            if(true || dbController.validateAccountentLogin(info.getUserName(), info.getPass())){
               Utility.accountFor=ACCOUNTANT;
                new Utility().openWindow(anchorPane, "/MessManagement/FXMLMessManagement.fxml", "Mess Management System");
            Utility.closeWindow(btnAccLogin);
            
                System.out.println(Utility.accountFor);
            }else{
                Utility.showDialog(Alert.AlertType.ERROR, "Login Error!", "", "User name or Password is not valid");
            }
        } catch (IOException ex) {
            Utility.showDialog(Alert.AlertType.WARNING, "Empty Fild!", "", "Required Fild Can't be empty");
        }
    }

    @FXML
    void createAccAccount(ActionEvent event) {
        new Utility().openWindow(anchorPane, "/login/FXMLCreateAccount.fxml", "Cerate Accountant Account");
        Utility.closeWindow(btnAccCreateAccount);
        Utility.accountFor=ACCOUNTANT;
        Utility.tabIndex=tabPane.getSelectionModel().getSelectedIndex();
       
    }

    @FXML
    void createManAccount(ActionEvent event) {
        new Utility().openWindow(anchorPane, "/login/FXMLCreateAccount.fxml", "Cerate Manager Account");
        Utility.closeWindow(btnManCreateAcc);
        Utility.accountFor=MANAGER;
        Utility.tabIndex=tabPane.getSelectionModel().getSelectedIndex();
    }

    @FXML
    void managerLogin(ActionEvent event) {
         try {
            info.setUserName(manUserName.getText());
            info.setPass(manPass.getText());
            if(dbController.validateManagertLogin(info.getUserName(), info.getPass())){
               Utility.accountFor=MANAGER;
                new Utility().openWindow(anchorPane, "/MessManagement/FXMLMessManagement.fxml", "Mess Management System");
            Utility.closeWindow(btnAccLogin);
            
            
            }else{
                Utility.showDialog(Alert.AlertType.ERROR, "Login Error!", "", "User name or Password is not valid");
            }
        } catch (IOException ex) {
            Utility.showDialog(Alert.AlertType.WARNING, "Empty Fild!", "", "Required Fild Can't be empty");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(Utility.tabIndex); //select by index starting with 0
       
        FildValidator.textFildValidator(accUserName, "User Name Required");
        FildValidator.passFildValidator(accPass, "Passwore Required");

        FildValidator.textFildValidator(manUserName, "User Name Required");
        FildValidator.passFildValidator(manPass, "Passwore Required");
        tabPane.setBackground(Background.EMPTY);

    }

}
