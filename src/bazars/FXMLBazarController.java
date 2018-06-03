/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazars;

import Utilities.Utility;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import db.BazarDbController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import members.MemberModel;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLBazarController implements Initializable {

    @FXML
    private JFXTextField tfBazarAmt;

    @FXML
    private JFXButton btnSave;
    
        @FXML
    private ComboBox<String> cmbMembers;

    @FXML
    private JFXTreeTableView<BazarTableModel> bazarTable;
    
    private String accountId=Utility.accountId;
    private List<BazarModel> bazarList;
    private List<BazarTableModel> bazarTableList;
    private int cmbSelectIndex;
    private List<String> memberNames;
    private List<MemberModel> memberList;
    private String date = Utility.systemDate;
    private ObservableList<BazarTableModel> bazarObList;
    private List<JFXTreeTableColumn<BazarTableModel, String>> colList;
    

    @FXML
    void saveBazar(ActionEvent event) {
        //System.out.println(cmbSelectIndex);
        if(cmbMembers.getSelectionModel().getSelectedIndex()!=-1){
            try {
                //System.out.println("if "+cmbSelectIndex);
                BazarModel model=new BazarModel();
                model.setAccountId(accountId);
                model.setMemberId(memberList.get(cmbSelectIndex).getMemberId());
                //System.out.println("id"+memberList.get(cmbSelectIndex).getMemberId());
                model.setBazarAmt(tfBazarAmt.getText());
                model.setBazarDate(date);
                BazarDbController.addBazar(model);
                
               // bazarTable=new JFXTreeTableView<>();
                bazarList=new ArrayList<>();
                bazarList=BazarDbController.getAllBazars(accountId);
                //System.out.println(bazarList.get(bazarList.size()-1).getBazarAmt());
                
                bazarObList.clear();
                bazarTableList=new ArrayList();
        bazarList=BazarDbController.getAllBazars(accountId);
        for(BazarModel bmodel: bazarList){
            bazarTableList.add(new BazarTableModel(bmodel));
        }
        generateTableView();
//                for(BazarModel bmodel: bazarList){
//                    bazarTableList.add(new BazarTableModel(bmodel));
//                }
//                bazarObList.clear();
//                bazarObList = FXCollections.observableArrayList(bazarTableList);
//                
//                bazarTable.refresh();
//               final TreeItem<BazarTableModel> rootx = new RecursiveTreeItem<BazarTableModel>(bazarObList, RecursiveTreeObject::getChildren);
//        
//         bazarTable.getColumns().setAll(colList);
//        bazarTable.setRoot(rootx);
//        bazarTable.setShowRoot(false);
                //generateTableView();
        
        
        
                Utility.showDialog(Alert.AlertType.CONFIRMATION, "Success", "", "Bazar Saved Successfully");
            } catch (IOException ex) {
                Utility.showDialog(Alert.AlertType.WARNING, "Empty Fild!", "", "Please Add Bazar Amount");
            }
        }else{
            Utility.showDialog(Alert.AlertType.WARNING, "Fild Required", "", "Please Select Member");
        }
    }
    
        @FXML
    void getSelectedItemId(ActionEvent event) {
        cmbSelectIndex=cmbMembers.getSelectionModel().getSelectedIndex();
            System.out.println(cmbMembers.getSelectionModel().getSelectedIndex());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //cmbMembers.getSelectionModel().getSelectedIndex();
       // System.out.println(cmbMembers.getSelectionModel().getSelectedIndex());
         memberNames = new ArrayList();
         colList=new ArrayList();

        memberList = db.dbController.getAllMembers(accountId);
        createMemberNameList();
        loadCombo();
        bazarTableList=new ArrayList();
        bazarList=BazarDbController.getAllBazars(accountId);
        for(BazarModel model: bazarList){
            bazarTableList.add(new BazarTableModel(model));
        }
        generateTableView();
        
    }    
    
    private void generateTableView() {
        JFXTreeTableColumn<BazarTableModel, String> colName = new JFXTreeTableColumn<>("Name");
        colName.setPrefWidth(150);
        colName.setCellValueFactory((param) -> {
            return param.getValue().getValue().getFullName();
        });
        colList.add(colName);

        JFXTreeTableColumn<BazarTableModel, String> colBazar = new JFXTreeTableColumn<>("Bazar Amount");
        colBazar.setPrefWidth(150);
        colBazar.setCellValueFactory((param) -> {
            return param.getValue().getValue().getBazarAmt();
        });
        colList.add(colBazar);

        JFXTreeTableColumn<BazarTableModel, String> colDate = new JFXTreeTableColumn<>("Date");
        colDate.setPrefWidth(150);
        colDate.setCellValueFactory((param) -> {
            return param.getValue().getValue().getBazarDate();
        });
         colList.add(colDate);


        bazarObList = FXCollections.observableArrayList(bazarTableList);

        final TreeItem<BazarTableModel> rootx = new RecursiveTreeItem<BazarTableModel>(bazarObList, RecursiveTreeObject::getChildren);
        //bazarTable.getColumns().setAll(colName, colBazar, colDate);
         bazarTable.getColumns().setAll(colList);
        bazarTable.setRoot(rootx);
        bazarTable.setShowRoot(false);

    }
    
    private void createMemberNameList() {
        for (MemberModel member : memberList) {
            memberNames.add(member.getFullName());
        }
    }

    private void loadCombo() {
        ObservableList<String> observableMembers = FXCollections.observableArrayList(memberNames);
        cmbMembers.setItems(observableMembers);
    }
    
}
