package Controller;

import Model.Components.Cart;
import Model.Customer;
import Model.HomeNavigateComponent.Product;
import Model.OrderFormUI;
import View.DialogMsgBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private static OrderFormUI orderUI;

    private static JTable tableOrder;
    private static JScrollPane tableOrderScrool;

    private static DefaultTableModel model;

    private static Statement statement = HomeController.getStatement();
    private static ResultSet result = HomeController.getResult();
    public static OrderFormUI renderUI(){
        orderUI = new OrderFormUI("Order");
        orderUI.setContentPane(orderUI.getMainContainer());
        orderUI.setSize(500,600);
        orderUI.setLocation(200,200);
        orderUI.setDefaultCloseOperation(1);
        model = new DefaultTableModel();
        model.addColumn("Product name");
        model.addColumn("Product price");
        model.addColumn("Product quantity");
        System.out.println("Row count: "+model.getRowCount());
        tableOrder = new JTable(model);
        tableOrderScrool = new JScrollPane(tableOrder);
        orderUI.getOrderListShow().add(tableOrderScrool);
        cartListToTable();
        return orderUI;
    }

    private static void modelAddRow(List<Object[]> cartList){
        for (int i = 0; i < cartList.size(); i++) {
            Object[] currentObj = cartList.get(i);
            Object[] mappedObj = {currentObj[1], currentObj[2], currentObj[3]};
            model.addRow(mappedObj);
        }
        model.fireTableDataChanged();
    }

    public static void clearModel(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        tableOrder.revalidate();
        tableOrder.repaint();
    }

    public static void cartListToTable(){
        List<Object[]> cartList = Cart.getListCartObject();
        System.out.println("Size: "+cartList.size());
        clearModel();
        modelAddRow(cartList);
        tableOrder.revalidate();
        tableOrder.repaint();
    }

    public static void setVisibleOrder(boolean isVisible){
        orderUI.setVisible(false);
    }

    private static boolean isValidCusInformation(Customer customer){
        boolean isValid = true;
        String infor[] = {customer.getNameCus(),customer.getAdressCus(),customer.getPhoneCus()};
        String error[] = {"Invalid name! ","Invalid adress! ","Invalid phone!"};
        String errorShow = "";
        for (int i = 0; i < infor.length; i++) {
            if(infor[i].equals("")){
                errorShow += error[i];
                isValid = false;
            }
        }
        if(!errorShow.equals("")){
            DialogMsgBox.runWarning(errorShow);
        }
        return  isValid;
    }

    private static boolean isCartEmpty(){
        List<Product> cartList = Cart.getCartList();
        if(cartList.isEmpty()){
            DialogMsgBox.runWarning("Cart is empty !");
        }
        return !cartList.isEmpty();
    }

    public static void addOrder(){
        List<Product> cartList = Cart.getCartList();
        String nameCus = orderUI.getNameOrderTf().getText();
        String adressCus = orderUI.getAdressTf().getText();
        String phoneCus = orderUI.getPhoneLbl().getText();
        DateTimeFormatter datePattern = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Customer customer = new Customer(nameCus,adressCus,phoneCus,datePattern.format(now));
        if(isValidCusInformation(customer) && isCartEmpty()){
            for (int i = 0; i < cartList.size(); i++) {
                Product currentProd = cartList.get(i);
                String query = String.format("INSERT INTO OrderList(prodId,quantity,customerName,address,phone,orderAt)" +
                        "VALUES (%d,%d,'%s','%s','%s','%s');",currentProd.getProdIdInt(),currentProd.getQuantity(),customer.getNameCus(),customer.getAdressCus(),customer.getPhoneCus(),customer.getOrderdate());
                ResultSet rs = result;
                try{
                    statement.executeUpdate(query);
                }catch(Exception ex){
                    System.out.println(ex);
                    System.out.println("Error add order");
                    DialogMsgBox.runWarning("Server error !");
                }
            }
            DialogMsgBox.runSuccess("Success !");
        }

    }


}
