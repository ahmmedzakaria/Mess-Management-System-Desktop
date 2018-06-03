/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bazars;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Zakakaria
 */
public class BazarTableModel extends RecursiveTreeObject<BazarTableModel>{
    
    private StringProperty fullName;
    private StringProperty bazarAmt;
    private StringProperty bazarDate;

    public BazarTableModel(BazarModel model) {
        this.fullName=new SimpleStringProperty(model.getFname()+" "+model.getlName());
        this.bazarAmt=new SimpleStringProperty(model.getBazarAmt());
        this.bazarDate=new SimpleStringProperty(model.getBazarDate());
    }
    
    

    public StringProperty getFullName() {
        return fullName;
    }

    public void setFullName(StringProperty fullName) {
        this.fullName = fullName;
    }

    public StringProperty getBazarAmt() {
        return bazarAmt;
    }

    public void setBazarAmt(StringProperty bazarAmt) {
        this.bazarAmt = bazarAmt;
    }

    public StringProperty getBazarDate() {
        return bazarDate;
    }

    public void setBazarDate(StringProperty bazarDate) {
        this.bazarDate = bazarDate;
    }
    
    
}
