package Controller;

import Model.AdminComponent.EmployeeListTable;
import Model.AdminComponent.OrderListTable;
import Model.AdminComponent.ProdListTable;
import Model.AdminUI;
import Model.Adminstrator;
import Model.HomeNavigateComponent.Product;
import Model.SignUpUI;
import View.DialogMsgBox;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

public class AdminController {

    private static AdminUI adminModel = new AdminUI("Admin-Diag");

    private static ProdListTable table = new ProdListTable();
    private static EmployeeListTable tableEmployee = new EmployeeListTable();

    private static OrderListTable tableOrder = new OrderListTable();

    private static Statement statement = HomeController.getStatement();


    public static AdminUI getModel(){
        adminModel.setContentPane(adminModel.getMainContainer());
        adminModel.setLocation(50,50);
        adminModel.setSize(1400,800);
        adminModel.setDefaultCloseOperation(1);
        return adminModel;
    }

    public static void showSadminOrAdminUI(){
        boolean isSadmin = MAdminstrator.getIsIsSadmin();
        adminModel.getEmployeeTab().setVisible(isSadmin);
    }

    public static void showTabView(){
        JPanel AdminHolder = adminModel.getAdminHolder();
        JPanel getMain = table.getMainTblContainer();
        adminModel.getAddAdminBtn().setVisible(false);
        adminModel.getAddProdBtn().setVisible(true);
        adminModel.getResetBtn().setVisible(false);
        adminModel.getFindOrderBtn().setVisible(false);
        adminModel.getFindProdBtn().setVisible(true);
        adminModel.getResetFindProdBtn().setVisible(true);
        adminModel.getDelprodBtn().setVisible(true);
        adminModel.getDelEmployeeBtn().setVisible(false);
        adminModel.getFindEmployeeBtn().setVisible(false);
        adminModel.getSearchEmployeeTf().setVisible(false);
        adminModel.getSearchProdTf().setVisible(true);
        renderListToTable();
        AdminHolder.removeAll();
        AdminHolder.add(getMain,BorderLayout.CENTER);
        AdminHolder.revalidate();
        AdminHolder.repaint();
    }

    public static void showTabEmployee(){
        HomeController.getListItem();
        JPanel AdminHolder = adminModel.getAdminHolder();
        JPanel container = tableEmployee.getMainTblContainer();
        adminModel.getAddAdminBtn().setVisible(true);
        adminModel.getAddProdBtn().setVisible(false);
        adminModel.getResetBtn().setVisible(false);
        adminModel.getFindOrderBtn().setVisible(false);
        adminModel.getFindProdBtn().setVisible(false);
        adminModel.getResetFindProdBtn().setVisible(false);
        adminModel.getDelprodBtn().setVisible(false);
        adminModel.getDelEmployeeBtn().setVisible(true);
        adminModel.getFindEmployeeBtn().setVisible(true);
        adminModel.getSearchEmployeeTf().setVisible(true);
        adminModel.getSearchProdTf().setVisible(false);
        DefaultTableModel model = tableEmployee.getModel();
        List<Object[]> listEmployee = MAdminstrator.getListOfAdminObject();
        renderListToTable(model,listEmployee);
        AdminHolder.removeAll();
        AdminHolder.add(container,BorderLayout.CENTER);
        AdminHolder.revalidate();
        AdminHolder.repaint();
    }

    public static void showTabOrder(){
        JPanel container = tableOrder.getMainContainer();
        JPanel AdminHolder = adminModel.getAdminHolder();
        DefaultTableModel model = tableOrder.getModel();
        adminModel.getAddAdminBtn().setVisible(false);
        adminModel.getAddProdBtn().setVisible(false);
        adminModel.getResetBtn().setVisible(true);
        adminModel.getFindOrderBtn().setVisible(true);
        adminModel.getFindProdBtn().setVisible(false);
        adminModel.getResetFindProdBtn().setVisible(false);
        adminModel.getDelprodBtn().setVisible(false);
        adminModel.getDelEmployeeBtn().setVisible(false);
        adminModel.getFindEmployeeBtn().setVisible(false);
        adminModel.getSearchEmployeeTf().setVisible(false);
        adminModel.getSearchProdTf().setVisible(false);
        List<Object[]> listOrder = OrderListTableController.getListOrder();
        renderListToTable(model,listOrder);
        AdminHolder.removeAll();
        AdminHolder.add(container,BorderLayout.CENTER);
        AdminHolder.revalidate();
        AdminHolder.repaint();
    }

    public static void showOrderFindBox(){
        FindOrderController.renderUi().setVisible(true);
    }



    private static void renderListToTable(){
        List<Object[]> listProd = MProdList.getList();
        DefaultTableModel model = table.getModel();
        resetRowDatainModel(model);
        for (int i = 0; i < listProd.size(); i++) {
            model.addRow(listProd.get(i));
        }
        model.fireTableDataChanged();
    }

    public static void renderFindedListByIDToTable(String id){
        if(id.equals("")){
            showTabView();
        }else {
            List<Object[]> listProd = MProdList.findProdListById(id);
            System.out.println("renderFindedListByIDToTable: "+listProd.size());
            DefaultTableModel model = table.getModel();
            resetRowDatainModel(model);
            for (int i = 0; i < listProd.size(); i++) {
                model.addRow(listProd.get(i));
            }
            model.fireTableDataChanged();
        }
    }

    private static void renderListToTable(DefaultTableModel model, List<Object[]> list){
        resetRowDatainModel(model);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(list.get(i));
        }
        model.fireTableDataChanged();
    }

    private static void resetRowDatainModel(DefaultTableModel model){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    public static int deleteProdInDB(String id){
        int actionStatus = -1;
        try{
            int idInt = Integer.parseInt(id);
            List<Object[]> listOfFinded = MProdList.findProdListById(id);
            if(listOfFinded.size() == 0){
                DialogMsgBox.runWarning("Invalid id !");
                actionStatus = 0;
            }else{
                String query = String.format("DELETE FROM Product WHERE prodId = %d",idInt);
                statement.executeUpdate(query);
                HomeController.getListItem();
                AdminController.showTabView();
                actionStatus = 1;
            }
        }catch(Exception e){
            System.out.println(e);
            DialogMsgBox.runWarning("Invalid id !");
            actionStatus = 0;
        }
        return actionStatus;
    }

    public static void showSignUpUI(){
        SignUpController.showSignUpUI().setVisible(true);
    }

    public static void findEmployee(String email){
        JPanel AdminHolder = adminModel.getAdminHolder();
        List<Adminstrator> findedList = MAdminstrator.findAdminListByEmail(email);
        DefaultTableModel model = tableEmployee.getModel();
        List<Object[]> listObj = MAdminstrator.getListOfAdminObject(findedList);
        renderListToTable(model,listObj);
        AdminHolder.revalidate();
        AdminHolder.repaint();
    }

    public static void deleteEmployeeByEmail(String email){
        Adminstrator admin = MAdminstrator.findAdminByEmail(email);
        if(admin.getEmail().equalsIgnoreCase("") || email.equalsIgnoreCase("")){
            DialogMsgBox.runWarning("Email not exits");
        }else{
            String query = String.format("DELETE FROM Login WHERE email = '%s'",email);
            try{
                statement.executeUpdate(query);
                HomeController.getListAdmin();
                AdminController.showTabEmployee();
                DialogMsgBox.runSuccess("Delete success");
            }catch (Exception e){
                System.out.println(e);
                DialogMsgBox.runWarning("Error when delete");
            }
        }
    }
}
