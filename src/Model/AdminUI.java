package Model;

import Controller.AddprodPopupController;
import Controller.AdminController;
import Model.Components.ImageDisplayer;
import View.DialogMsgBox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminUI extends JFrame {
    private JPanel MainContainer;
    private JPanel AdminSideBar;
    private JPanel Header;
    private JLabel Title;
    private JLabel TitleSub;
    private JPanel HeaderWrapper;
    private JPanel SideBarBody;
    private JPanel SideBody;
    private JButton prodListBtn;
    private JLabel IconProd;
    private JPanel ListTab;
    private JLabel IconProd2;
    private JLabel IconProd3;
    private JPanel EmployeeTab;
    private JButton employeeBtn;
    private JPanel ProdSellTab;
    private JButton prodSellBtn;
    private JPanel IconHolder;
    private JLabel IconPlace;
    private JPanel LogoutContainer;
    private JButton logOutButton;
    private JPanel AminMain;
    private JPanel AdminBodyHeader;
    private JLabel TitleHeader;
    private JPanel DynamicHeader;
    private JPanel FirstContainer;
    private JLabel CurentLocationPage;
    private JLabel AdminBodyTitle;
    private JPanel SecondContainer;
    private JPanel SearchAddWrapper;
    private JPanel SearchAddContent;
    private JLabel IconSearch;
    private JTextField SearchProdTf;
    private JButton AddProdBtn;
    private JPanel AdminHolder;
    private JButton AddAdminBtn;
    private JLabel ResetBtn;
    private JButton findOrderBtn;
    private JButton findProdBtn;
    private JButton ResetFindProdBtn;
    private JButton DelprodBtn;
    private JButton findEmployeeBtn;
    private JButton delEmployeeBtn;
    private JTextField SearchEmployeeTf;

    public AdminUI(String title) throws HeadlessException {
        super(title);
        prodListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.showTabView();
            }
        });
        employeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("employee tab");
                AdminController.showTabEmployee();
                SearchProdTf.setText("");
            }
        });
        prodSellBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.showTabOrder();
                SearchProdTf.setText("");
            }
        });
        AddProdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddprodPopupController.renderUI().setVisibleModel(true);
            }
        });
        ResetBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                AdminController.showTabOrder();
            }
        });
        findOrderBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.showOrderFindBox();
            }
        });
        findProdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = SearchProdTf.getText();
                AdminController.renderFindedListByIDToTable(id);
            }
        });
        ResetFindProdBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.showTabView();
                SearchProdTf.setText("");
            }
        });
        DelprodBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = SearchProdTf.getText();
                int output = DialogMsgBox.optionBox("Do you want to delete ?");
                if(output == 0){
                    int statusCode = AdminController.deleteProdInDB(id);
                    SearchProdTf.setText("");
                    if(statusCode == 1){
                        DialogMsgBox.runSuccess("Success delete !");
                    }
                }else {
                    DialogMsgBox.runSuccess("No action affected!");
                }
            }
        });
        findEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = SearchEmployeeTf.getText();
                System.out.println(email);
                AdminController.findEmployee(email);

            }
        });
        delEmployeeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = SearchEmployeeTf.getText();
                AdminController.deleteEmployeeByEmail(email);
                SearchEmployeeTf.setText("");
            }
        });

        AddAdminBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminController.showSignUpUI();
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        IconProd = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\FolderHomeIcon.png",30,30,54,33,89);
        IconProd2 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Folder-printers-icon.png",30,30,54,33,89);
        IconProd3 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Folder-Package-Folder-icon.png",30,30,54,33,89);
        IconPlace = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\guard-icon.png",150,150,54,33,89);
        Cursor cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        IconSearch = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Zoom-icon.png",30,30,241,243,247);
        ResetBtn = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\reset-dns-zone-icon.png",30,30,232,234,238);
    }

    public JPanel getMainContainer() {
        return MainContainer;
    }


    public void setVisibleModel(boolean isVisible){
        AdminController.showTabView();
        setVisible(isVisible);
    }

    public JPanel getAdminHolder() {
        return AdminHolder;
    }

    public JPanel getEmployeeTab() {
        return EmployeeTab;
    }

    public JButton getAddAdminBtn() {
        return AddAdminBtn;
    }

    public JButton getAddProdBtn() {
        return AddProdBtn;
    }

    public JLabel getResetBtn() {
        return ResetBtn;
    }

    public JButton getFindOrderBtn() {
        return findOrderBtn;
    }

    public JButton getFindProdBtn() {
        return findProdBtn;
    }

    public JTextField getSearchProdTf() {
        return SearchProdTf;
    }

    public JButton getResetFindProdBtn() {
        return ResetFindProdBtn;
    }

    public JButton getDelprodBtn() {
        return DelprodBtn;
    }

    public JButton getFindEmployeeBtn() {
        return findEmployeeBtn;
    }

    public JButton getDelEmployeeBtn() {
        return delEmployeeBtn;
    }

    public JTextField getSearchEmployeeTf() {
        return SearchEmployeeTf;
    }
}
