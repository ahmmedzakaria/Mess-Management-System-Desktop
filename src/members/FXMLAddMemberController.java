/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package members;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import Utilities.Utility;
import db.dbController;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLAddMemberController implements Initializable {

    @FXML
    private JFXTextField tfFirstName;

    @FXML
    private Label lblCaption;

    @FXML
    private JFXTextField tfLastName;

    @FXML
    private JFXButton btnChoose, btnSave;

    @FXML
    private FlowPane flowPane;
    

    @FXML
    private ImageView imgView;

    File path;
    String fileName;
    String managerId="1";
    MemberModel model;

    @FXML
    void chooseImage(ActionEvent event) {
        path=Utility.openFileChooser(path);
        fileName = path.getName();
        //currentFile=path.getAbsoluteFile();
        Image image = new Image(path.toURI().toString());
        imgView.setImage(image);
    }

    @FXML
    void saveMember(ActionEvent event) {       
        File dir = new File("images");
        if (!dir.exists()) {
            dir.mkdir();
        }
        File distination = new File("images\\" + Utility.sysDateTime+ fileName);
        MemberModel member=new MemberModel(managerId,tfFirstName.getText(), tfLastName.getText(),
                path.toString(),Utility.systemDate);
       dbController.addMember(member);
       Utility.copyFileToDirectory(path, distination);
       Utility.showDialog(Alert.AlertType.CONFIRMATION, "Success", "", "Member Saved Succesfully");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
