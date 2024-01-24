package View;

import Controller.HomeController;
import Model.HomeUI;

public class IndexView {

    private static boolean loginView = false;
    private static boolean signupView = false;

    private static boolean homeView = true;


    public static void setLoginView(boolean isSgow) {
        loginView = isSgow;
        LoginViewGenerator.getLoginUI().setVisible(isSgow);
    }

    public static void setSignupView(boolean isSgow) {
        signupView = isSgow;
        SignupViewGenerator.getModelSignUp().setVisible(isSgow);
    }

    public static void setHomeView(boolean isSgow) {
        homeView = isSgow;
        HomeController.renderUI().setVisible(true);
    }

    public static void initView(){
        setHomeView(true);
    }

    public static void main(String[] args) {
        initView();
    }
}
