package Controller;

import Model.Adminstrator;
import Model.SignUpUI;
import View.DialogMsgBox;

import java.sql.Statement;
import java.util.List;

public class SignUpController {
    private static SignUpUI signUpBx = new SignUpUI("Sign up");
    private static Statement statement = HomeController.getStatement();
    public static SignUpUI showSignUpUI(){
        signUpBx.setContentPane(signUpBx.getMainContainer());
        signUpBx.setSize(700,500);
        signUpBx.setLocation(300,300);
        signUpBx.setDefaultCloseOperation(1);
        return signUpBx;
    }

    public static void addEmployee(Adminstrator employee){
        boolean isValid = validateAdminSignUp(employee);
        if(isValid){
            Adminstrator adminFinder = findEmployeeByEmail(employee);
            if(adminFinder.getEmail().equalsIgnoreCase("")){
                String query = String.format("INSERT INTO Login(`name`,email,`password`,`role`)" +
                        "VALUES ('%s','%s','%s','%s');",employee.getFullName(),employee.getEmail(),employee.getPassword(),employee.getRole());
                try{
                    statement.executeUpdate(query);
                    HomeController.getListAdmin();
                    AdminController.showTabEmployee();
                    DialogMsgBox.runSuccess("Success add new employee");
                    resetInputText();
                }catch(Exception e){
                    System.out.println(e);
                    System.out.println("Add employee error!");
                }
            }else{
                DialogMsgBox.runWarning("Email is exit !");
            }
        }
    }

    private static boolean validateAdminSignUp(Adminstrator employee){
        boolean isValid = true;
        String error ="";
        String[] errorList = {"Invalid name","Invalid email","Invalid password"};
        String[] valueList = {employee.getFullName(),employee.getEmail(),employee.getPassword()};
        for (int i = 0; i < valueList.length; i++) {
            if(valueList[i].equalsIgnoreCase("")){
                isValid = false;
                error += errorList[i];
            }
        }
        if (!error.equalsIgnoreCase("")){
            DialogMsgBox.runWarning(error);
            error ="";
        }
        return isValid;
    }

    private static Adminstrator findEmployeeByEmail(Adminstrator employee){
        List<Adminstrator> list = MAdminstrator.getListOfAdmin();
        Adminstrator admin = new Adminstrator("",-1,"","","");
        for (int i = 0; i < list.size(); i++) {
            Adminstrator adminCurrent = list.get(i);
            if(employee.getEmail().equals(adminCurrent.getEmail())){
                admin = adminCurrent;
            }
        }
        return admin;
    }

    private static void resetInputText(){
        signUpBx.getPassText().setText("");
        signUpBx.getFirstNameText().setText("");
        signUpBx.getEmailTf().setText("");
    }
}
