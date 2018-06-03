/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessManagement;

import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import Utilities.Utility;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Zakakaria
 */
public class FXMLMessManagementController implements Initializable {

    @FXML
    private AnchorPane ancTop, ancBottom;

    @FXML
    private JFXHamburger fxHamburger;

    @FXML
    private JFXDrawer fxDrawer;

    @FXML
    private Label lblLogin, lblUser;

    HamburgerBackArrowBasicTransition basicTransition;

    VBox box;
    @FXML
    private HBox hBoxContainer;

    Screen screen;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addDrawer();
        controlHamburgerTransection();
        controlDrawerOnAnchorPanClick();
//        setDrawerSize();
        if (Utility.accountFor.equals(Utility.MANAGER)) {
            new Utility().loadFXML(hBoxContainer, "/members/FXMLMembers.fxml");
        } else if (Utility.accountFor.equals(Utility.ACCOUNTANT)) {
            new Utility().loadFXML(hBoxContainer, "/meals/FXMLDailyMeal.fxml");
        }

        for (Node node : box.getChildren()) {
            if (node.getAccessibleText() != null) {
                node.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
                    switch (node.getAccessibleText()) {
                        case "account":
                            new Utility().loadFXML(hBoxContainer, "/accountant/FXMLCreateAccount.fxml");
                            break;
                        case "daily_update":
                            new Utility().loadFXML(hBoxContainer, "/meals/FXMLDailyMeal.fxml");

                            break;
                        case "deposit":
                            new Utility().loadFXML(hBoxContainer, "/diposit/FXMLDiposit.fxml");
                            break;

                        case "bazar":
                            new Utility().loadFXML(hBoxContainer, "/bazars/FXMLBazar.fxml");
                            break;
                        case "meal":
                              new Utility().loadFXML(hBoxContainer, "/meals/FXMLMealChart.fxml");   
                            break;
                        
                        case "extra":
                            new Utility().loadFXML(hBoxContainer, "/extra/FXMLExtra.fxml");

                            break;
                        case "report":
                             new Utility().loadFXML(hBoxContainer, "/accountant/FXMLReport.fxml");
                            break;
                        case "logout":

                            break;

                        case "mess_members":
                            new Utility().loadFXML(hBoxContainer, "/members/FXMLMembers.fxml");
                            break;
                    }
                });
            }
        }
    }

    private void addDrawer() {
        fxDrawer = new JFXDrawer();
        fxDrawer.setDefaultDrawerSize(190);
        HBox hBox = new HBox(fxDrawer);
        fxDrawer.setPrefSize(100, ancBottom.getHeight());
        // hBox.setHgrow(fxDrawer, Priority.ALWAYS);
        //hBox.setHgrow(ancBottom, Priority.ALWAYS);
        //hBox.prefWidthProperty().bind(ancBottom.widthProperty());
        hBox.prefHeightProperty().bind(ancBottom.heightProperty());
        ancBottom.getChildren().add(hBox);

        try {
            if (Utility.accountFor.equals(Utility.ACCOUNTANT)) {
                box = FXMLLoader.load(getClass().getResource("FXMLDrowerAccContent.fxml"));
            }
            if (Utility.accountFor.equals(Utility.MANAGER)) {
                box = FXMLLoader.load(getClass().getResource("FXMLDrowerManContent.fxml"));
            }
            System.out.println(Utility.accountFor);
            fxDrawer.setSidePane(box);
            fxDrawer.toFront();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void setDrawerSize() {

        javafx.geometry.Rectangle2D bounds = screen.getVisualBounds();
        fxDrawer.setPrefSize(100, bounds.getHeight() - 100);
    }

    private void controlHamburgerTransection() {
        basicTransition = new HamburgerBackArrowBasicTransition(fxHamburger);
        basicTransition.setRate(-1);
        fxHamburger.addEventHandler(MouseEvent.MOUSE_CLICKED, (e) -> {
            if (fxDrawer.isHidden()) {
                fxDrawer.open();
                playHambargerTransection();

            } else {
                fxDrawer.close();

            }
        });
    }

    private void playHambargerTransection() {
        basicTransition.setRate(basicTransition.getRate() * -1);
        basicTransition.play();
    }

    private void controlDrawerOnAnchorPanClick() {
        ancBottom.addEventHandler(MouseEvent.MOUSE_PRESSED, (e) -> {
            if (!fxDrawer.isHidden()) {
                fxDrawer.close();
                playHambargerTransection();
            }
        });
    }
}
