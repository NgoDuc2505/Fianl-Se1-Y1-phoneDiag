package Model;

import Controller.OrderController;
import Model.Components.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class OrderFormUI extends JFrame {

    private JPanel MainContainer;
    private JLabel TitleOrder;
    private JPanel OrderFooter;
    private JPanel OrderBody;
    private JLabel TotalBill;
    private JLabel TotalLbl;
    private JPanel OrderContent;
    private JPanel TextAreaCustomer;
    private JTextField NameOrderTf;
    private JLabel NameOrderLbl;
    private JLabel AdressLbl;
    private JTextField AdressTf;
    private JTextField PhoneLbl;
    private JLabel PhoneTf;
    private JComboBox PaymentSelection;
    private JLabel PaymentLbl;
    private JPanel OrderListShow;
    private JButton BuyBtn;
    private JButton clearBtn;

    public OrderFormUI(String title) throws HeadlessException {
        super(title);
        clearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Cart.clearCart();
                OrderController.clearModel();
                OrderController.setVisibleOrder(false);
            }
        });
        BuyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderController.addOrder();
            }
        });
    }

    public static void main(String[] args) {
        OrderController.renderUI().setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        OrderListShow = new JPanel();
        TotalBill = new JLabel();
    }

    public JPanel getOrderListShow() {
        return OrderListShow;
    }

    public JPanel getMainContainer() {
        return MainContainer;
    }

    public JLabel getTotalBill() {
        return TotalBill;
    }

    public JTextField getNameOrderTf() {
        return NameOrderTf;
    }

    public JTextField getAdressTf() {
        return AdressTf;
    }



    public JTextField getPhoneLbl() {
        return PhoneLbl;
    }
}
