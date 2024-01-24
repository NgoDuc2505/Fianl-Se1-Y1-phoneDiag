package View;

import Model.LoginUI;

import javax.swing.*;

public class LoginViewGenerator {

    private static LoginUI LoginUI = Model.LoginUI.getModel();
    public static void runUI(){
        LoginUI.setVisible(true);
    }


    public static LoginUI getLoginUI() {
        return LoginUI;
    }
}
