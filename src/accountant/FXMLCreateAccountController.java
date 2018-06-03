/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import Utilities.UiComponent;
import Utilities.Utility;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import members.MemberModel;
import db.AccountDbController;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;



public class FXMLCreateAccountController implements Initializable {

     @FXML
    private BorderPane borderPane;

    @FXML
    private FlowPane topFlowPane;

    @FXML
    private Label lblAccName;

    @FXML
    private JFXTextField tfAccName;


    @FXML
    private JFXButton btnCreateAccount;

    @FXML
    private SplitPane splitPane;

    @FXML
    private AnchorPane leftAnchorPane,rightAnchorPane;

   @FXML
    private JFXListView<Label> listView,listViewAccount;
      private List<MemberModel> membreList;
      private List<AccountModel> accountList;
      private UiComponent ui;
    private String accountId;
    private String accountantId;

    @FXML
    void createAccount(ActionEvent event) {
        System.out.println("clicked");
        AccountDbController.createAccount(accountantId, Utility.systemDate,tfAccName.getText());
        String accountId=String.valueOf(AccountDbController.getLastAccountId());
        if(true){
            AccountDbController.addBatchAccountDetails(accountId, membreList);
            Utility.showDialog(Alert.AlertType.CONFIRMATION, "Success", "", "New Account Created");
        }else{
            Utility.showDialog(Alert.AlertType.WARNING, "Fild!", "", "Account Not Created !");
        }
    }
    
        @FXML
    void displaySelectedAccout(MouseEvent event) {
        int index=listViewAccount.getSelectionModel().getSelectedIndex();
        Utility.accountId=String.valueOf(index+1);
        listView.getItems().clear();
        //accountList=AccountDbController.getAllAccount(accountantId);
            System.out.println(Utility.accountId);
            membreList=db.dbController.getAllMembers(accountId);
            for(MemberModel member : membreList){
           Label lbl=ui.createLabel(member.getFullName());
           listView.getItems().add(lbl);  
       }
    }
        @FXML
    void showAllMembers(ActionEvent event) {
        membreList=db.dbController.getAllMembers();
        List<Label> list=new ArrayList<Label>();
        for(MemberModel member : membreList){
           Label lbl=ui.createLabel(member.getFullName());
           list.add(lbl);
           //listView.getItems().add(lbl);  
           listView.getItems().setAll(list);
       }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Utility.accountId=String.valueOf(db.AccountDbController.getLastAccountId());
        //System.out.println(Utility.accountId);
        accountId=Utility.accountId;
        accountantId=Utility.accountentId;
        tfAccName.setText("Acc_"+(Integer.valueOf(Utility.accountId)+1));
        ui=new UiComponent();
        membreList=db.dbController.getAllMembers();
        accountList=AccountDbController.getAllAccount(accountantId);
        List<Label> list=new ArrayList<Label>();
        for(MemberModel member : membreList){
           Label lbl=ui.createLabel(member.getFullName());
           list.add(lbl);
           //listView.getItems().add(lbl);  
           listView.getItems().setAll(list);
       }
        
         for(AccountModel account : accountList){
           Label lbl=ui.createLabel(account.getAccountName());
           listViewAccount.getItems().add(lbl);  
       }

    }   
    
}
