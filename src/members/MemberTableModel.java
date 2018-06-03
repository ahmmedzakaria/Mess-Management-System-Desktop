/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package members;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.ImageView;

/**
 *
 * @author Zakakaria
 */
public class MemberTableModel  extends RecursiveTreeObject<MemberTableModel>{
    private StringProperty managerId;
    private StringProperty fName;
    private StringProperty lName;
    private StringProperty fullName;
    private StringProperty mealName;
    private StringProperty imgPath;
    private StringProperty date;

    public MemberTableModel(String managerId, String fName, String lName, String imgPath, String date) {
        this.managerId = new SimpleStringProperty(managerId);
        this.fName =  new SimpleStringProperty(fName);
        this.lName =  new SimpleStringProperty(lName);
        this.imgPath =  new SimpleStringProperty(imgPath);
        this.date =  new SimpleStringProperty(date);
    }

    public StringProperty getFullName() {
        return fullName;
    }

    public MemberTableModel(StringProperty managerId, StringProperty fName, StringProperty lName, StringProperty mealName, StringProperty imgPath, StringProperty date) {
        this.managerId = managerId;
        this.fName = fName;
        this.lName = lName;
        this.mealName = mealName;
        this.imgPath = imgPath;
        this.date = date;
    }
    public MemberTableModel(MemberModel member){
        this.fullName=new SimpleStringProperty(member.getfName()+" "+member.getlName());
        this.mealName=new SimpleStringProperty(member.getMealName());
        this.imgPath=new SimpleStringProperty(member.getImgPath());
        this.date=new SimpleStringProperty(member.getDate());
        
    }
    

    public MemberTableModel() {
    }

    public StringProperty getManagerId() {
        return managerId;
    }

    public void setManagerId(StringProperty managerId) {
        this.managerId = managerId;
    }

    public StringProperty getfName() {
        return fName;
    }

    public void setfName(StringProperty fName) {
        this.fName = fName;
    }

    public StringProperty getlName() {
        return lName;
    }

    public void setlName(StringProperty lName) {
        this.lName = lName;
    }

    public StringProperty getMealName() {
        return mealName;
    }

    public void setMealName(StringProperty mealName) {
        this.mealName = mealName;
    }

    public StringProperty getImgPath() {
        return imgPath;
    }

    public void setImgPath(StringProperty imgPath) {
        this.imgPath = imgPath;
    }

    public StringProperty getDate() {
        return date;
    }

    public void setDate(StringProperty date) {
        this.date = date;
    }

    
    
}
