/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diposit;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *
 * @author Zakakaria
 */
public class DipositTableModel   extends RecursiveTreeObject<DipositTableModel>{
    private StringProperty memberName;
    private StringProperty dipositOne; 
    private StringProperty dipositTow; 
    private StringProperty dipositThree; 
    private StringProperty dipositFour; 
    private StringProperty ttlDiposti;

    public DipositTableModel(String memberName, String dipositOne, String dipositTow, String dipositThree, String dipositFour,String ttlDiposti) {
        this.memberName = new SimpleStringProperty(memberName);
        this.dipositOne =  new SimpleStringProperty(dipositOne);
        this.dipositTow =  new SimpleStringProperty(dipositTow);
        this.dipositThree =  new SimpleStringProperty(dipositThree);
        this.dipositFour =  new SimpleStringProperty(dipositFour);
        this.ttlDiposti =  new SimpleStringProperty(ttlDiposti);
    }
    
    public DipositTableModel(DipositModel model) {
        this.memberName = new SimpleStringProperty();
        this.dipositOne =  new SimpleStringProperty(model.getDipositAmt());
        this.dipositTow =  new SimpleStringProperty(model.getDipositAmt());
        this.dipositThree =  new SimpleStringProperty(model.getDipositAmt());
        this.dipositFour =  new SimpleStringProperty(model.getDipositAmt());
        this.ttlDiposti =  new SimpleStringProperty(model.getTtlDiposit());
    }

    public StringProperty getMemberName() {
        return memberName;
    }

    public StringProperty getDipositOne() {
        return dipositOne;
    }

    public StringProperty getDipositTow() {
        return dipositTow;
    }

    public StringProperty getDipositThree() {
        return dipositThree;
    }

    public StringProperty getDipositFour() {
        return dipositFour;
    }

    public StringProperty getTtlDiposti() {
        return ttlDiposti;
    }

    
}
