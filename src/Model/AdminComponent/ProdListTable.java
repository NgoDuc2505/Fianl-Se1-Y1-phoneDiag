package Model.AdminComponent;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProdListTable extends JPanel {
    private JPanel MainTblContainer;
    private JTable DataTable;

    private DefaultTableModel model = new DefaultTableModel();

    private JScrollPane scrollTable;

    public ProdListTable() {
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }


    public JPanel getMainTblContainer() {
        model.setColumnCount(0);
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Image");
        model.addColumn("Price");
        model.addColumn("Desc");
        model.addColumn("AmountLeft");
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
