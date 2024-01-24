package Model.AdminComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmployeeListTable extends JPanel  {
    private JPanel MainTblContainer;
    private JTable DataTable;

    private DefaultTableModel model = new DefaultTableModel();

    private JScrollPane scrollTable;

    public JPanel getMainTblContainer() {
        model.setColumnCount(0);
        model.addColumn("Id");
        model.addColumn("Name");
        model.addColumn("Email");
        model.addColumn("Password");
        model.addColumn("Role");
        DataTable = new JTable(model){
            public boolean isCellEditable(int row, int column) {
                return false;
            };
        };
        scrollTable = new JScrollPane(DataTable);
        MainTblContainer.add(scrollTable, BorderLayout.CENTER);
        MainTblContainer.revalidate();
        MainTblContainer.repaint();
        return MainTblContainer;
    }

    public JTable getDataTable() {
        return DataTable;
    }

    public DefaultTableModel getModel() {
        return model;
    }
}
