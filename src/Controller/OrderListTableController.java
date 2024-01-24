package Controller;

import Model.AdminComponent.OrderListTable;
import View.DialogMsgBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderListTableController {

    private static Statement statement = HomeController.getStatement();
    private static ResultSet result = HomeController.getResult();

    private static List<Object[]> listOrder = new ArrayList<>();


    private static void fromDBtoList(){
        String query = "SELECT * FROM OrderList";
        ResultSet rs = result;
        try{
            rs = statement.executeQuery(query);
            while (rs.next()){
                Object[] currentObj = {rs.getInt(3),rs.getInt(1),rs.getInt(5),rs.getString(2),rs.getString(4),rs.getString(6),rs.getString(7)};
                listOrder.add(currentObj);
            }
        }catch (Exception e){
            System.out.println(e);
            System.out.println("Error query");
        }
    }

    private static void clearList(){
        listOrder = new ArrayList<>();
    }

    public static List<Object[]> getListOrder() {
        clearList();
        fromDBtoList();
        return listOrder;
    }

    public static List<Object[]> findListByCusPhone(String phone){
        if(phone.equalsIgnoreCase("")){
            return listOrder;
        }
        List<Object[]> listOrderByPhone = new ArrayList<>();
        for (int i = 0; i < listOrder.size(); i++) {
            String currentPhone = listOrder.get(i)[5].toString();
            System.out.println("currentPhone: "+currentPhone);
            if(currentPhone.contains(phone)){
                listOrderByPhone.add(listOrder.get(i));
            }
        }
        return  listOrderByPhone;
    }

    public static int findListById(int id){
        int isExit = 0;
        for (int i = 0; i < listOrder.size(); i++) {
            if((int)listOrder.get(i)[0]==id){
                isExit = 1;
                break;
            }
        }
        return isExit;
    }

    public static void deleteOrderInDB(String id){
        int idInt = Integer.parseInt(id);
        if(findListById(idInt)==1){
            String query = String.format("DELETE FROM OrderList WHERE orderId = %d;",idInt);
            try{
                statement.executeUpdate(query);
                DialogMsgBox.runSuccess("Delete success !");
                clearList();
                fromDBtoList();
                FindOrderController.findByPhoneAndRender("");
                AdminController.showTabOrder();
            }catch (Exception e){
                System.out.println(e);
                DialogMsgBox.runWarning("Invalid id !");
                System.out.println("Error delete !");
            }
        }else {
            DialogMsgBox.runWarning("Invalid id [NOT EXIT] !");
        }

    }
}
