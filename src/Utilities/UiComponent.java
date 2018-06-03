/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.geometry.Insets;
import javafx.scene.control.Label;

/**
 *
 * @author Zakakaria
 */
public class UiComponent {
    private double lblWidth;
    private double lblHeight;
    
    private double btnWidth;
    private double btnHeight;
    
    private double tfWidth;
    private double tfHeight;
    public UiComponent(){
        lblWidth=200;
        lblHeight=30;
        btnWidth=100;
        btnHeight=30;
        tfWidth=200;
        tfHeight=30;
    }        
    public JFXButton createButton(String name){
       JFXButton btn=new JFXButton(name);
       btn.setPrefSize(btnWidth, btnHeight);
       btn.setPadding(new Insets(10));
       return btn;
   }
    
    public Label createLabel(String name){
       Label lbl=new Label(name);
       lbl.setPrefSize(lblWidth, lblHeight);
       //lbl.setPadding(new Insets(10));
       lbl.setStyle("-fx-text-fill: #0000ff; -fx-font-size: 16; -fx-background-color: #00ff00;"
                + "-fx-border-insets: 5px;"
                + "-fx-background-insets: 20px;");
       return lbl;
   }
    
    public JFXTextField createTextFild() {
        JFXTextField txt1 = new JFXTextField();
        txt1.setPrefSize(tfWidth, tfHeight);
        //txt1.setPadding(new Insets(10));
        txt1.setStyle("-fx-text-fill: green; -fx-font-size: 16; -fx-background-color: #ffffff;"
                + "-fx-border-insets: 5px;"
                + "-fx-background-insets: 20px;");
//        txt1.setStyle("-fx-background-insets: 20px;-fx-background-color:#ffffff;");

        return txt1;

    }
}
