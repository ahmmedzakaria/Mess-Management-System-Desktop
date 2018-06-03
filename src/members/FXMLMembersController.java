/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package members;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import Utilities.*;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLMembersController implements Initializable {
    List<MemberModel> memList;
    List<MemberTableModel> membersList;
    @FXML
    private JFXTreeTableView<MemberTableModel> tblMembers;
    private JFXTreeTableView<MemberTableModel> listViewAccount;

    @FXML
    private JFXButton btnAddMember;

    @FXML
    private JFXButton btnEditmember;

    @FXML
    private AnchorPane anchorPane;
    private String accountId;

    @FXML
    void addMember(ActionEvent event) {
        new Utility().openWindow(anchorPane, "/members/FXMLAddMember.fxml", "Mess Management System");

    }

    @FXML
    void editMember(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        accountId=Utility.accountId;
        membersList=new ArrayList<>();
        memList=db.dbController.getAllMembers(accountId);
        for(MemberModel member: memList){
            membersList.add(new MemberTableModel(member));
            
        }

        JFXTreeTableColumn<MemberTableModel, String> colName = new JFXTreeTableColumn<>("Name");
        colName.setPrefWidth(150);
        colName.setCellValueFactory((param) -> {
            return param.getValue().getValue().getFullName();
        });

        JFXTreeTableColumn<MemberTableModel, String> colMealName = new JFXTreeTableColumn<>("Meal Name");
        colMealName.setPrefWidth(150);
        colMealName.setCellValueFactory((param) -> {
            return param.getValue().getValue().getMealName();
        });

        JFXTreeTableColumn<MemberTableModel, String> colImage = new JFXTreeTableColumn<>("Image");
        colImage.setPrefWidth(150);
        colImage.setCellValueFactory((param) -> {
            return param.getValue().getValue().getImgPath();
        });
        
        JFXTreeTableColumn<MemberTableModel, String> colDate = new JFXTreeTableColumn<>("Date");
        colDate.setPrefWidth(150);
        colDate.setCellValueFactory((param) -> {
            return param.getValue().getValue().getDate();
        });

 
        ObservableList<MemberTableModel> members = FXCollections.observableArrayList(membersList);
//        for(MemberTableModel member: membersList){
//            members.add(member);
//        }
//        System.out.println(membersList.get(0).getDate());
//        System.out.println(membersList.get(0).getImgPath());
        final TreeItem<MemberTableModel> rootx = new RecursiveTreeItem<MemberTableModel>(members, RecursiveTreeObject::getChildren);
        tblMembers.getColumns().setAll(colName, colMealName, colImage,colDate);
        tblMembers.setRoot(rootx);
        tblMembers.setShowRoot(false);
    }

}
