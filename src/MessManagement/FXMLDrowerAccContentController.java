/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessManagement;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLDrowerAccContentController implements Initializable {

          @FXML
    private JFXButton btnAccount;

    @FXML
    void showAccount(ActionEvent event) {
        System.out.println("Controller Account clicked");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //vbox.getStylesheets().add(getClass().getResource("myStyle.css").toExternalForm());
        
    }    
    
}
