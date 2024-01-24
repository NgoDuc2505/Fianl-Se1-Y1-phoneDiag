package Model.AdminComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderListTable extends JPanel{
    private JPanel MainContainer;

    public OrderListTable() {
    }
    private JTable DataTable;

    private DefaultTableModel model = new DefaultTableModel();

    private JScrollPane scrollTable;

    public JPanel getMainContainer() {
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Product ID");
        model.addColumn("Quantity");
        model.addColumn("Name");
        model.addColumn("Adress");
        model.addColumn("Phone");
        model.addColumn("Buy At");
        DataTable = new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        scrollTable = new JScrollPane(DataTable);
        MainContainer.add(scrollTable, BorderLayout.CENTER);
        MainContainer.revalidate();
        MainContainer.repaint();
        return MainContainer;
    }

    public JTable getDataTable() {
        return DataTable;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
