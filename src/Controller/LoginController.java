package Controller;

import Model.LoginUI;
import Model.SignUpUI;
import View.DialogMsgBox;
import View.IndexView;

public class LoginController {

    private static SignUpUI modelSignUp = SignUpUI.getModel();
    private static LoginUI modelLogin = new LoginUI("Login");


    public static void switchToRegister(){
        IndexView.setSignupView(true);
    }

    public static LoginUI renderUI(){
        modelLogin.setContentPane(modelLogin.getMainContainer());
        modelLogin.setSize(700,500);
        modelLogin.setLocation(300,300);
        modelLogin.setDefaultCloseOperation(1);
        return modelLogin;
    }
    private static void adminAcess(){
        AdminController.getModel().setVisibleModel(true);
        modelLogin.setVisibleModel(false);
    }



    public static void checkCanAccess(){
        String emailInput = modelLogin.getEmailText().getText();
        String passInput = modelLogin.getPassText().getText();
        MAdminstrator.setIsSadmin(emailInput);
        boolean canAccess = MAdminstrator.isVerified(passInput,emailInput);
        boolean isWrongEmail = MAdminstrator.isWrongEmail();
        System.out.println(isWrongEmail);
        if(canAccess){
            adminAcess();
        }else if(!isWrongEmail) {
            DialogMsgBox.runWarning("Wrong password!");
        }
    }
}
