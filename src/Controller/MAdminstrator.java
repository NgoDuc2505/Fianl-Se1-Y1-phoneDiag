package Controller;

import Model.Adminstrator;
import View.DialogMsgBox;

import java.util.ArrayList;
import java.util.List;

public class MAdminstrator {
    private static List<Adminstrator> adminList = new ArrayList<>();

    public static List<Adminstrator> getListOfAdmin(){
        return adminList;
    }

    private static boolean isSadmin = false;

    public static List<Object[]> getListOfAdminObject(){
        List<Object[]> listRs = new ArrayList<>();
        for (int i = 0; i < adminList.size(); i++) {
            Adminstrator currentAdmin = adminList.get(i);
            Object[] object = {currentAdmin.getAdId(),currentAdmin.getFullName(),currentAdmin.getEmail(),currentAdmin.getPassword(),currentAdmin.getRole()};
            listRs.add(object);
        }
        return listRs;
    }
    public static List<Object[]> getListOfAdminObject(List<Adminstrator> adminList){
        List<Object[]> listRs = new ArrayList<>();
        for (int i = 0; i < adminList.size(); i++) {
            Adminstrator currentAdmin = adminList.get(i);
            Object[] object = {currentAdmin.getAdId(),currentAdmin.getFullName(),currentAdmin.getEmail(),currentAdmin.getPassword(),currentAdmin.getRole()};
            listRs.add(object);
        }
        return listRs;
    }
    private static boolean isVarifiedEmail = false;
    //DEV-ENV
    public static void printAdminList(){
        System.out.println("====PRINT LIST ADMIN ====");
        for (int i = 0; i < adminList.size(); i++) {
            System.out.println(adminList.get(i).toString());
        }
    }

    public static Adminstrator findAdminByEmail(String email){
        Adminstrator admin = new Adminstrator("",-1,"","","");
        for (int i = 0; i < adminList.size(); i++) {
            if(email.equalsIgnoreCase(adminList.get(i).getEmail())){
                admin = adminList.get(i);
            }
        }
        return admin;
    }

    public static List<Adminstrator> findAdminListByEmail(String email){
        List<Adminstrator> list = new ArrayList<>();
        if(email.equalsIgnoreCase("")){
            return adminList;
        }
        for (int i = 0; i < adminList.size(); i++) {
            Adminstrator currentAdmin = adminList.get(i);
            if(email.equalsIgnoreCase(currentAdmin.getEmail())){
                list.add(currentAdmin);
            }
        }
        System.out.println("findAdminListByEmail: "+list.size());
        return list;
    }

    public static boolean isWrongEmail(){
        return isVarifiedEmail;
    }

    public static boolean isVerified(String password, String email){
        boolean isVerify = false;
        Adminstrator adminFind = findAdminByEmail(email);
        if(adminFind.getAdId() == -1){
            DialogMsgBox.runWarning("Wrong email!");
            isVarifiedEmail = true;
            return isVerify;
        }else {
            isVarifiedEmail = false;
        }
        if(password.equalsIgnoreCase(adminFind.getPassword())){
            isVerify = true;
        }
        return isVerify;
    }

    public static List<Adminstrator> add(Adminstrator admin){
        adminList.add(admin);
        return adminList;
    }

    public static void setIsSadmin(String email){
        Adminstrator admin = findAdminByEmail(email);
        String pattern = "SADMIN";
        if(admin.getRole().equals(pattern)){
            isSadmin = true;
        }else{
            isSadmin = false;
        }
        System.out.println("Check here: "+isSadmin);
    }

    public static void resetListEmpty(){
        adminList = new ArrayList<>();
    }

    public static boolean getIsIsSadmin() {
        return isSadmin;
    }
}
