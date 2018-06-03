/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountant;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Zakakaria
 */
public class ReportTableModel extends RecursiveTreeObject<ReportTableModel>{
    private StringProperty fullName;
    private StringProperty totalDiposit;
    private StringProperty totalMeal;
    private StringProperty totalMealCost;
    private StringProperty totalExtras;
    private StringProperty totalCost;
    private StringProperty memberGetMony;
    private StringProperty accountentGetMony;

    public ReportTableModel(ReportModel model) {
        this.fullName =new SimpleStringProperty(model.getFullName());
        this.totalDiposit = new SimpleStringProperty(model.getMemberTtlDiposit());
        this.totalMeal = new SimpleStringProperty(model.getMemberTtlMeal());;
        this.totalMealCost = new SimpleStringProperty(model.getMemberTotalMelCost());;
        this.totalExtras = new SimpleStringProperty(model.getMemberExtra());;
        this.totalCost = new SimpleStringProperty(model.getMemberTotalcost());;
        this.memberGetMony = new SimpleStringProperty(model.getMemberGetMony());;
        this.accountentGetMony = new SimpleStringProperty(model.getAccGetMony());;
    }
    
    

    public StringProperty getFullName() {
        return fullName;
    }

    public void setFullName(StringProperty fullName) {
        this.fullName = fullName;
    }

    public StringProperty getTotalDiposit() {
        return totalDiposit;
    }

    public void setTotalDiposit(StringProperty totalDiposit) {
        this.totalDiposit = totalDiposit;
    }

    public StringProperty getTotalMeal() {
        return totalMeal;
    }

    public void setTotalMeal(StringProperty totalMeal) {
        this.totalMeal = totalMeal;
    }

    public StringProperty getTotalMealCost() {
        return totalMealCost;
    }

    public void setTotalMealCost(StringProperty totalMealCost) {
        this.totalMealCost = totalMealCost;
    }

    public StringProperty getTotalExtras() {
        return totalExtras;
    }

    public void setTotalExtras(StringProperty totalExtras) {
        this.totalExtras = totalExtras;
    }

    public StringProperty getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(StringProperty totalCost) {
        this.totalCost = totalCost;
    }

    public StringProperty getMemberGetMony() {
        return memberGetMony;
    }

    public void setMemberGetMony(StringProperty memberGetMony) {
        this.memberGetMony = memberGetMony;
    }

    public StringProperty getAccountentGetMony() {
        return accountentGetMony;
    }

    public void setAccountentGetMony(StringProperty accountentGetMony) {
        this.accountentGetMony = accountentGetMony;
    }
  
}
