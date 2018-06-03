/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import Utilities.FildValidator;
import Utilities.Utility;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLCreateAccountController implements Initializable {

    private final String MANAGER = "manager";
    private final String ACCOUNTANT = "accountent";
    
   

    @FXML
    private JFXTextField tfName, tfUserName;

    @FXML
    private JFXPasswordField psPassword;

    @FXML
    private JFXButton btnCreate, btnBack;
    @FXML
    private AnchorPane anchorPane;
    LoginInfo info;

    @FXML
    void back(ActionEvent event) {
        
        new Utility().openWindow(anchorPane, "/login/FXMLLogin.fxml", "Mess Management System");
        Utility.closeWindow(btnBack);
    }

    @FXML
    void createAccount(ActionEvent event) {
        if (Utility.accountFor.equals(ACCOUNTANT)) {
            createAccountantAccount();
        }
        if (Utility.accountFor.equals(MANAGER)) {
            createManagerAccount();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FildValidator.textFildValidator(tfName, "Name Required");
        FildValidator.textFildValidator(tfUserName, "User Name Required");
        FildValidator.passFildValidator(psPassword, "Passwore Required");
    }

    private void createAccountantAccount() {
        info = new LoginInfo();
        info.setName(tfName.getText());
        info.setUserName(tfUserName.getText());
        info.setPass(psPassword.getText());

        try {
            if (db.dbController.addAccountant(info.getName(), info.getUserName(), info.getPass())) {
                Utility.showDialog(AlertType.CONFIRMATION, "Account Created", "", "You have created An Accountent account successfully");
                new Utility().openWindow(anchorPane, "/login/FXMLLogin.fxml", "Mess Management System");
                Utility.closeWindow(btnCreate);
            } else {
                Utility.showDialog(AlertType.ERROR, "Error!", "", "Account Exsist. Try with new User Name");
            }

        } catch (IOException ex) {
            Utility.showDialog(AlertType.WARNING, "Empty Fild!", "", "Required Fild Can't be empty");
        }
    }

    private void createManagerAccount() {
        info = new LoginInfo();
        info.setName(tfName.getText());
        info.setUserName(tfUserName.getText());
        info.setPass(psPassword.getText());
        String date = Utility.systemDate;
        try {
            boolean t=db.dbController.addManager(info.getName(), info.getUserName(), info.getPass(), date);
            System.out.println(t);
            if (!t) {
                Utility.showDialog(AlertType.CONFIRMATION, "Account Created", "", "You have created a Manager account successfully");
                new Utility().openWindow(anchorPane, "/login/FXMLLogin.fxml", "Mess Management System");
                Utility.closeWindow(btnCreate);
            } else {
                Utility.showDialog(AlertType.ERROR, "Error!", "", "Account Exsist. Try with new User Name");
            }
        } catch (IOException ex) {
            Utility.showDialog(AlertType.WARNING, "Empty Fild!", "", "Required Fild Can't be empty");
        }
    }
}
