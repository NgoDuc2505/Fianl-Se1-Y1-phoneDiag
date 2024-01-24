package Model.AdminComponent;

import Controller.FindOrderController;
import Controller.OrderListTableController;
import Model.Components.ImageDisplayer;

import javax.swing.*;
import java.awt.event.*;

public class FindOrderUI extends JFrame {
    private JPanel Maincontainer;
    private JPanel HeaderContainer;
    private JLabel IconSearch;
    private JTextField phoneSearchTf;
    private JTextField IdOrderTf;
    private JButton delBtn;
    private JButton findBtn;
    private JButton ReturnBtn;


    public FindOrderUI(String title) {
        super(title);
        findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String phoneText = phoneSearchTf.getText();
                System.out.println(phoneText);
                FindOrderController.findByPhoneAndRender(phoneText);
            }
        });
        delBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IdOrderTf.getText();
                OrderListTableController.deleteOrderInDB(id);
            }
        });
        ReturnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FindOrderController.findByPhoneAndRender("");
            }
        });
    }

    public JPanel getMaincontainer() {
        return Maincontainer;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        IconSearch = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Help-icon.png",30,30,214,230,245);
    }

}
