package Controller;

import Model.AdminComponent.AddProdPopup;
import Model.HomeNavigateComponent.Product;
import View.DialogMsgBox;

import javax.swing.*;
import java.sql.*;


public class AddprodPopupController {
    private static AddProdPopup addProd = new AddProdPopup("Add new");

    private static Statement statement = HomeController.getStatement();
    private static ResultSet result = HomeController.getResult();

    public static AddProdPopup renderUI(){
        addProd.setContentPane(addProd.getContainer());
        addProd.setSize(600,500);
        addProd.setLocation(200,200);
        addProd.setDefaultCloseOperation(1);
        return addProd;
    }

    public static void addProdToDB(String pathAbsoluteAfter){
        System.out.println(pathAbsoluteAfter);
        Product prod = addProdInPopup(pathAbsoluteAfter);
//        System.out.println("here: "+pathAbsoluteAfter);
        String query = String.format("INSERT INTO Product(prodName,prodPrice,quantityStorage,prodImg,prodDecs) VALUES('%s','%s','%d','%s','%s')",prod.getProdName(),prod.getProdPrice(),prod.getQuantity(),pathAbsoluteAfter,prod.getProdDecs());
//        System.out.println("query: "+query);
        try{
            int indexOfRs;
            indexOfRs = statement.executeUpdate(query);
//            System.out.println("Index check: "+indexOfRs);
            HomeController.getListItem();
            AdminController.showTabView();
            DialogMsgBox.runSuccess("Add success !");
            addProd.setVisibleModel(false);
            addProd.dispose();
        }catch (Exception ex){
            System.out.println("Failed to add !");
            System.out.println(ex);
        }
    }

    private static Product addProdInPopup(String pathAbsoluteAfter){
        String nameprod = addProd.getNameTf().getText();
        String desc = addProd.getDecsTaf().getText();
        String price = addProd.getPriceTf().getText();
        String quantity = addProd.getQuantityTf().getText();
        int quantityInt = (int)Double.parseDouble(quantity.replaceAll(",", ".").replaceAll(" ", "")) ;
        Product currentProd = new Product(null,nameprod,price,desc,pathAbsoluteAfter,quantityInt);
        return currentProd;
    }
}
