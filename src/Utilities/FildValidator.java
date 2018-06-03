/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;

/**
 *
 * @author Zakakaria
 */
public class FildValidator {
    public static void  textFildValidator(JFXTextField fild, String massage) {

            RequiredFieldValidator validator = new RequiredFieldValidator();
            fild.getValidators().add(validator);
            validator.setMessage(massage);
            fild.focusedProperty().addListener((newValue) -> {
                fild.validate();
            });
        }
    
    public static void passFildValidator(JFXPasswordField fild, String massage) {

            NumberValidator numValidator =new NumberValidator();
            fild.getValidators().add(numValidator);
            numValidator.setMessage(massage);
            fild.focusedProperty().addListener((newValue) -> {
                fild.validate();
            });
        }
    
    public static void numberValidator(JFXTextField fild, String massage){
    RequiredFieldValidator validator = new RequiredFieldValidator();
            fild.getValidators().add(validator);
            validator.setMessage(massage);
            fild.focusedProperty().addListener((newValue) -> {
                fild.validate();
            });
    
    }
}
