package Controller;

import Model.AdminComponent.FindOrderUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FindOrderController {

    private static FindOrderUI box ;

    private static DefaultTableModel model;

    private static JTable table;

    private static JScrollPane scroll;

    private static JPanel mainContainer;

    public static FindOrderUI renderUi(){
        box = new FindOrderUI("Find order");
        mainContainer = box.getMaincontainer();
        List<Object[]> initListOrder = OrderListTableController.getListOrder();
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Product ID");
        model.addColumn("Quantity");
        model.addColumn("Name");
        model.addColumn("Adress");
        model.addColumn("Phone");
        model.addColumn("Buy At");
        renderListToTable(initListOrder,model);
        table = new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        scroll = new JScrollPane(table);
        mainContainer.add(scroll,BorderLayout.CENTER);
        mainContainer.revalidate();
        mainContainer.repaint();
        box.setContentPane(mainContainer);
        box.setSize(600,400);
        box.setLocation(200,200);
        box.setDefaultCloseOperation(1);
        return box ;
    }

    public static void renderListToTable(List<Object[]> list, DefaultTableModel model){
        for (int i = 0; i < list.size(); i++) {
            model.addRow(list.get(i));
        }
        model.fireTableDataChanged();
    }

    private static void clearModel(){
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
    }

    public static void findByPhoneAndRender(String phone) {
        List<Object[]> findedList = OrderListTableController.findListByCusPhone(phone);
        System.out.println("Finded size: "+findedList.size());
        clearModel();
        renderListToTable(findedList,model);
        mainContainer.revalidate();
        mainContainer.repaint();
    }

    public static FindOrderUI getBox() {
        return box;
    }

    public static JTable getTable() {
        return table;
    }
}



















