/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meals;

import Utilities.UiComponent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import db.*;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Priority;
import members.MemberModel;
import Utilities.*;
import bazars.BazarModel;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLDailyMealController implements Initializable {

    @FXML
    private VBox vBoxLbl;

    @FXML
    private Label lblMealRet;

    @FXML
    private Label lblDiposit;

    @FXML
    private Label lblAvilMony;

    @FXML
    private Label lblDate;

    @FXML
    private JFXButton btnSave;

    @FXML
    private ComboBox<String> cmbNames;
    ;

    @FXML
    private VBox vBoxLabels;

    @FXML
    private VBox vBoxTf;

    @FXML
    private JFXTextField tfBazarAmt;
    private int cmbSelectIndex;

    private List<String> memberNames;
    private UiComponent ui;
    private String accountId;
    private List<MemberModel> memberList;
    private List<MealModel> mealModelList;
    private String date = Utility.systemDate;
    private double totalMeal;
    private double totalBazar;
    private double totalDiposit;
    private double mealRet;

    @FXML
    void saveMealInfo(ActionEvent event) {
        mealModelList = new ArrayList();
       
        int count = 0;
        for (Node node : vBoxTf.getChildren()) {
            if (node instanceof JFXTextField) {
                try {
                    MealModel model = new MealModel();
                    model.setAccountId(accountId);
                    model.setMemberId(memberList.get(count).getMemberId());
                    model.setMeal(((JFXTextField) node).getText());
                    model.setMealDate(date);
                    mealModelList.add(model);
                    //System.out.println(((JFXTextField) node).getText());
                    count++;
                } catch (IOException ex) {
                    Utility.showDialog(Alert.AlertType.WARNING, "Empty Fild!", "", "Required Fild Can't be empty");
                    return;
                }
            }  
        }
        MealDbController.saveAllMeals(mealModelList);
        
        if(cmbNames.getSelectionModel().getSelectedIndex()!=-1){
            
            try {
                BazarModel model=new BazarModel();
                model.setAccountId(accountId);
                model.setMemberId(memberList.get(cmbSelectIndex).getMemberId());
                model.setBazarAmt(tfBazarAmt.getText());
                model.setBazarDate(date);
                BazarDbController.addBazar(model);
                Utility.showDialog(Alert.AlertType.CONFIRMATION, "Success", "", "Bazar Saved Successfully");
            } catch (IOException ex) {
                Utility.showDialog(Alert.AlertType.WARNING, "Fild Required", "", "Please Select Member");
            }
        }else{
            Utility.showDialog(Alert.AlertType.WARNING, "Fild Required", "", "Please Select Member");
        }
    }

    @FXML
    void getSelectedItemId(ActionEvent event) {
        cmbSelectIndex=cmbNames.getSelectionModel().getSelectedIndex();        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         accountId =Utility.accountId;
        //System.out.println("accId "+accountId);
        memberNames = new ArrayList();
        ui = new UiComponent();
        memberList = dbController.getAllMembers(accountId);
        totalMeal = MealDbController.getTotalMeal(accountId);
        totalBazar = BazarDbController.getTotalBazar(accountId);
        totalDiposit = DipositDbController.getTotalDiposit(accountId);
        mealRet = Double.valueOf(String.format("%.2f",totalBazar / totalMeal));
        createMemberNameList();
        loadCombo();
        generateUiComponent();
        
        lblDate.setText(lblDate.getText()+" "+date);
        
        lblMealRet.setText(lblMealRet.getText()+" "+String.valueOf(mealRet));

    
    lblDiposit.setText(lblDiposit.getText()+" "+String.valueOf(totalDiposit));


   lblAvilMony.setText(lblAvilMony.getText()+" "+String.valueOf(totalDiposit-totalBazar));;
        //System.out.println(cmbSelectIndex=cmbNames.getSelectionModel().getSelectedIndex());

    }

    private void createMemberNameList() {
        for (MemberModel member : memberList) {
            memberNames.add(member.getFullName());
        }
    }

    private void loadCombo() {
        ObservableList<String> observableMembers = FXCollections.observableArrayList(memberNames);
        cmbNames.setItems(observableMembers);
    }

    private void generateUiComponent() {
        for (String name : memberNames) {
            Label lbl = ui.createLabel(name);
            vBoxLabels.getChildren().add(lbl);
            vBoxLabels.setSpacing(20);
            JFXTextField tf = ui.createTextFild();
            FildValidator.numberValidator(tf, "Please Insert a Number");
            vBoxTf.getChildren().add(tf);
            vBoxTf.setSpacing(20);
        }
    }

}
