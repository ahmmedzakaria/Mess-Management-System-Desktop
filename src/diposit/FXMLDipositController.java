/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diposit;

import Utilities.FildValidator;
import Utilities.UiComponent;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import db.*;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import meals.MealModel;
import members.MemberModel;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLDipositController implements Initializable {

    @FXML
    private JFXTreeTableView<DipositTableModel> tblDiposti;

    @FXML
    private VBox vBox;

    @FXML
    private JFXButton btnSave;
    private List<DipositModel> dipositList;
    private List<DipositTableModel> dipositTableModelList;
    private String accountId;
    private List<MemberModel> memberList;
    private UiComponent ui;

    private String date = Utilities.Utility.systemDate;
    private List<DipositModel> dipositModelList;

    double totalDipostit;
    int dipcount = 0;

    

    @FXML
    void saveDiposits(ActionEvent event) {
        dipositModelList = new ArrayList<>();
        //int dipcount=0;
        int count = 0;

        for (Node node : vBox.getChildren()) {
            if (node instanceof JFXTextField) {
                if (!((JFXTextField) node).getText().isEmpty()) {
                    DipositModel model = new DipositModel();
                    model.setAccountId(accountId);
                    model.setMemberId(memberList.get(count).getMemberId());
                    model.setDipositAmt(((JFXTextField) node).getText());
                    model.setDipositDate(date);
                    dipositModelList.add(model);
                    dipcount++;
                    ((JFXTextField) node).setText("");
                }
                //System.out.println(((JFXTextField) node).getText());
                count++;
            }

        }
        DipositDbController.saveDipositBatch(dipositModelList);
        Utilities.Utility.showDialog(Alert.AlertType.CONFIRMATION, "Success", "", dipcount + " Diposit Added");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dipositTableModelList = new ArrayList<>();
        ui = new UiComponent();
        dipositList = new ArrayList<>();
        accountId = Utilities.Utility.accountId;
        dipositList = DipositDbController.getAllDiposits(accountId);
        memberList = dbController.getAllMembers(accountId);
        generateUiComponent();
        genarateDipositTableModel();
        generateTableView();
    }
    
    private void calculateDiposit(String dip) {
        totalDipostit = totalDipostit + Double.valueOf(dip);
    }
    


    private void genarateDipositTableModel() {
        int loopcount=0;
        int countMemList = 0;
        int dipCount = 0;
        String memberId = "";
        String name = "", dipOne = "", dipTwo = "", dipThree = "", dipFour = "", ttlDip = "";
        for (DipositModel dipsoit : dipositList) {
            loopcount++;
            if ((memberId.equals(dipsoit.getMemberId()) && dipCount < 4)) {
                //System.out.println("if: memList " + memberId + " dipList " + dipsoit.getMemberId() + "amt " + dipsoit.getDipositAmt());
                switch (dipCount) {
                    case 1:
                        dipTwo = dipsoit.getDipositAmt();
                        calculateDiposit(dipsoit.getDipositAmt());
                        dipCount++;
                        break;
                    case 2:
                        dipThree = dipsoit.getDipositAmt();
                        calculateDiposit(dipsoit.getDipositAmt());
                        dipCount++;
                        break;
                    case 3:
                        dipFour = dipsoit.getDipositAmt();
                        calculateDiposit(dipsoit.getDipositAmt());
                        dipCount++;
                        break;
                }

            } else {
                System.out.println("else: memList " + memberId + " dipList " + dipsoit.getMemberId() + "amt " + dipsoit.getDipositAmt());
                if (countMemList < memberList.size()) {
                    if (dipCount > 0) {
                        DipositTableModel model = new DipositTableModel(name, dipOne, dipTwo, dipThree, dipFour, String.valueOf(totalDipostit));
                        dipositTableModelList.add(model);
                        name = "";
                        dipOne = "";
                        dipTwo = "";
                        dipThree = "";
                        dipFour = "";
                        ttlDip = "";
                        totalDipostit=0;
                    }
                    memberId = memberList.get(countMemList).getMemberId();
                    dipOne = dipsoit.getDipositAmt();
                    calculateDiposit(dipsoit.getDipositAmt());
                    name = memberList.get(countMemList).getFullName();
                    countMemList++;
                    dipCount = 1;
                }
            }
            System.out.println("dip " + dipsoit.getDipositAmt());
            
            if(loopcount==dipositList.size()){
            
            DipositTableModel model = new DipositTableModel(name, dipOne, dipTwo, dipThree, dipFour, String.valueOf(totalDipostit));
                        dipositTableModelList.add(model);
            }

        }
    }

    private void generateTableView() {
        JFXTreeTableColumn<DipositTableModel, String> colName = new JFXTreeTableColumn<>("Name");
        colName.setPrefWidth(150);
        colName.setCellValueFactory((param) -> {
            return param.getValue().getValue().getMemberName();
        });

        JFXTreeTableColumn<DipositTableModel, String> coldipOne = new JFXTreeTableColumn<>("Diposti One");
        coldipOne.setPrefWidth(150);
        coldipOne.setCellValueFactory((param) -> {
            return param.getValue().getValue().getDipositOne();
        });

        JFXTreeTableColumn<DipositTableModel, String> coldipTwo = new JFXTreeTableColumn<>("Diposti Two");
        coldipTwo.setPrefWidth(150);
        coldipTwo.setCellValueFactory((param) -> {
            return param.getValue().getValue().getDipositTow();
        });

        JFXTreeTableColumn<DipositTableModel, String> coldipThree = new JFXTreeTableColumn<>("Diposti Three");
        coldipThree.setPrefWidth(150);
        coldipThree.setCellValueFactory((param) -> {
            return param.getValue().getValue().getDipositThree();
        });
        JFXTreeTableColumn<DipositTableModel, String> coldipFour = new JFXTreeTableColumn<>("Diposti Four");
        coldipFour.setPrefWidth(150);
        coldipFour.setCellValueFactory((param) -> {
            return param.getValue().getValue().getDipositFour();
        });

        JFXTreeTableColumn<DipositTableModel, String> coldipTotal = new JFXTreeTableColumn<>("Total Diposit");
        coldipTotal.setPrefWidth(150);
        coldipTotal.setCellValueFactory((param) -> {
            return param.getValue().getValue().getTtlDiposti();
        });

        ObservableList<DipositTableModel> dipositObList = FXCollections.observableArrayList(dipositTableModelList);

        final TreeItem<DipositTableModel> rootx = new RecursiveTreeItem<DipositTableModel>(dipositObList, RecursiveTreeObject::getChildren);
        tblDiposti.getColumns().setAll(colName, coldipOne, coldipTwo, coldipThree, coldipFour, coldipTotal);
        tblDiposti.setRoot(rootx);
        tblDiposti.setShowRoot(false);

    }

    private void generateUiComponent() {
        for (int i = 0; i < memberList.size(); i++) {

            //hBox.setHgrow(textField, Priority.ALWAYS);
            JFXTextField tf = ui.createTextFild();
            FildValidator.numberValidator(tf, "Please Insert a Number");
            vBox.getChildren().add(tf);
        }
    }

    private void filterDiposit(int dipCount, DipositModel model, String... arg) {
        switch (dipCount) {
            case 0:
                arg[0] = model.getDipositAmt();
                break;
            case 1:
                arg[1] = model.getDipositAmt();
                break;
            case 2:
                arg[2] = model.getDipositAmt();
                break;
            case 3:
                arg[3] = model.getDipositAmt();
                break;
        }
    }
}
