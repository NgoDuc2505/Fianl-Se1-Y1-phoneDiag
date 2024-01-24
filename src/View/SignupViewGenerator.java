package View;

import Model.SignUpUI;

import javax.swing.*;

public class SignupViewGenerator {

    private static SignUpUI modelSignUp = SignUpUI.getModel();
    public static void runUi(){
        modelSignUp.setVisible(true);
    }

    public static SignUpUI getModelSignUp() {
        return modelSignUp;
    }
}
