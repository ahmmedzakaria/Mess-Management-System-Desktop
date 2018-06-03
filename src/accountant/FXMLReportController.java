/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import com.jfoenix.controls.JFXButton;
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
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import db.*;
import Utilities.*;
import java.util.ArrayList;


/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLReportController implements Initializable {

      @FXML
    private Label lblMealRet;

    @FXML
    private Label lblTtlDiposit;

    @FXML
    private Label lblTtlBazar;

    @FXML
    private Label lblRestMony;

    @FXML
    private Label lblTtlExtra;

    @FXML
    private Label lblEachPersonExtra;


    @FXML
    private JFXTreeTableView<ReportTableModel> tbl_report;

    @FXML
    private JFXButton btnPrintPdf;

    @FXML
    private JFXButton btnViewPdf;

    private List<ReportModel> memberDetailList;
    private List<ReportTableModel> reportTableList;
    private List<String> memberNames;
    private String accountId;
    private double totalMeal;
    private double totalBazar;
    private double totalDiposit;
    private double mealRet;
    private double totalCost;
    private double restMony;
    private double totalextra=0;

    @FXML
    void printPdf(ActionEvent event) {

    }

    @FXML
    void viewPdf(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reportTableList = new ArrayList();
        memberNames = dbController.getAllMemberNames();
        accountId = Utility.accountId;
        memberDetailList = MealDbController.getAllAccountDetails(accountId);
        totalMeal = MealDbController.getTotalMeal(accountId);
        totalBazar = BazarDbController.getTotalBazar(accountId);
        totalDiposit = DipositDbController.getTotalDiposit(accountId);
        mealRet = Double.valueOf(String.format("%.2f",totalBazar / totalMeal));
        restMony=totalDiposit-(totalBazar+totalextra);
        //System.out.println(totalDiposit+" "+totalBazar+" "+totalMeal);
        int count = 0;
        for (ReportModel model : memberDetailList) {
            model.setFullName(memberNames.get(count));
            model.setMemberTotalMelCost(makeMealCost(model.getMemberTtlMeal()));
            model.setMemberTotalcost(makeTotalCost(model));
            if (Double.valueOf(model.getMemberTtlDiposit()) > Double.valueOf(model.getMemberTotalcost())) {
                model.setMemberGetMony(memberGetMoney(model));
                model.setAccGetMony("0");
            } else {
                model.setMemberGetMony("0");
                model.setAccGetMony(accGetMoney(model));
            }
            reportTableList.add(new ReportTableModel(model));
            count++;
        }

        generateTableView();

        lblMealRet.setText(lblMealRet.getText() + " " + mealRet);

        lblTtlDiposit.setText(lblTtlDiposit.getText() + " " +totalDiposit);

        lblTtlBazar.setText(lblTtlBazar.getText() + " " + totalBazar);

        lblTtlExtra.setText(lblTtlExtra.getText() + " " + "0");

        lblEachPersonExtra.setText(lblEachPersonExtra.getText() + " " + "0");
        lblRestMony.setText(lblRestMony.getText()+" "+restMony);

    }

    private String makeMealCost(String meal) {
        
        return String.format("%.2f",Double.valueOf(meal) * mealRet);
        //return String.valueOf(Double.valueOf(meal) * mealRet);
    }

    private String makeTotalCost(ReportModel model) {
        //System.out.println(model.getMemberTotalMelCost() + " total " + model.getMemberExtra());
        return String.format("%.2f",Double.valueOf(model.getMemberTotalMelCost()));
        //return String.valueOf(Double.valueOf(model.getMemberTotalMelCost()));
    }

    private String memberGetMoney(ReportModel model) {
        return String.format("%.2f",Double.valueOf(Double.valueOf(model.getMemberTtlDiposit()) - Double.valueOf(model.getMemberTotalcost())));
        //return String.valueOf(Double.valueOf(Double.valueOf(model.getMemberTtlDiposit()) - Double.valueOf(model.getMemberTotalcost())));
    }

    private String accGetMoney(ReportModel model) {
        return String.format("%.2f",Double.valueOf(Double.valueOf(model.getMemberTotalcost()) - Double.valueOf(model.getMemberTtlDiposit())));
        //return String.valueOf(Double.valueOf(Double.valueOf(model.getMemberTotalcost()) - Double.valueOf(model.getMemberTtlDiposit())));
    }

    private void generateTableView() {
        JFXTreeTableColumn<ReportTableModel, String> colName = new JFXTreeTableColumn<>("Name");
        colName.setPrefWidth(150);
        colName.setCellValueFactory((param) -> {
            return param.getValue().getValue().getFullName();
        });

        JFXTreeTableColumn<ReportTableModel, String> colTotalDiposit = new JFXTreeTableColumn<>("Total Diposit");
        colTotalDiposit.setPrefWidth(150);
        colTotalDiposit.setCellValueFactory((param) -> {
            return param.getValue().getValue().getTotalDiposit();
        });

        JFXTreeTableColumn<ReportTableModel, String> colTotalMeal = new JFXTreeTableColumn<>("Total Meal");
        colTotalMeal.setPrefWidth(150);
        colTotalMeal.setCellValueFactory((param) -> {
            return param.getValue().getValue().getTotalMeal();
        });

        JFXTreeTableColumn<ReportTableModel, String> colTtlMealCost = new JFXTreeTableColumn<>("Total Meal Cost");
        colTtlMealCost.setPrefWidth(150);
        colTtlMealCost.setCellValueFactory((param) -> {
            return param.getValue().getValue().getTotalMealCost();
        });
        JFXTreeTableColumn<ReportTableModel, String> colExtras = new JFXTreeTableColumn<>("Extras");
        colExtras.setPrefWidth(150);
        colExtras.setCellValueFactory((param) -> {
            return param.getValue().getValue().getTotalExtras();
        });

        JFXTreeTableColumn<ReportTableModel, String> colTtlCost = new JFXTreeTableColumn<>("Total Cost");
        colTtlCost.setPrefWidth(150);
        colTtlCost.setCellValueFactory((param) -> {
            return param.getValue().getValue().getTotalCost();
        });

        JFXTreeTableColumn<ReportTableModel, String> colAccGet = new JFXTreeTableColumn<>("Accountant Get Mony");
        colAccGet.setPrefWidth(150);
        colAccGet.setCellValueFactory((param) -> {
            return param.getValue().getValue().getAccountentGetMony();
        });

        JFXTreeTableColumn<ReportTableModel, String> colMemGet = new JFXTreeTableColumn<>("Member Get Mony");
        colMemGet.setPrefWidth(150);
        colMemGet.setCellValueFactory((param) -> {
            return param.getValue().getValue().getMemberGetMony();
        });

        ObservableList<ReportTableModel> reportObList = FXCollections.observableArrayList(reportTableList);

        final TreeItem<ReportTableModel> rootx = new RecursiveTreeItem<ReportTableModel>(reportObList, RecursiveTreeObject::getChildren);
        tbl_report.getColumns().setAll(colName, colTotalDiposit, colTotalMeal, colTtlMealCost, colExtras, colTtlCost, colAccGet, colMemGet);
        tbl_report.setRoot(rootx);
        tbl_report.setShowRoot(false);

    }

}
