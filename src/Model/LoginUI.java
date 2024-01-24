package Model;

import Controller.AdminController;
import Controller.LoginController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame{

    public LoginUI() {
    }

    public JPanel getMainContainer() {
        return MainContainer;
    }

    private JPanel MainContainer;
    private JPanel SideContainer;
    private JPanel ContentContainer;
    private JTextArea welcomeToAdminTextArea;
    private JButton SubmitBtn;
    private JButton CancelBtn;
    private JPanel BodyContainer;
    private JPanel ButtonContainer;
    private JLabel Padder;
    private JLabel LoginTitile;
    private JPanel LoginAreaContainer;
    private JPanel TextArea;
    private JLabel EmailLbl;
    private JTextField EmailText;
    private JLabel PassLbl;
    private JTextField PassText;
    private JPanel TitleLogin;
    private JButton Icon;

    public LoginUI(String title) throws HeadlessException {
        super(title);
        Icon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.switchToRegister();
            }
        });
        SubmitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginController.checkCanAccess();
                AdminController.showSadminOrAdminUI();
            }
        });

    }


    private void createUIComponents() {
        SubmitBtn = new JButton();
        TextArea = new JPanel();
        TextArea.setLayout(new GridLayout(2,2));
        ImageIcon iconBtn = new ImageIcon("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\btn.png");
        Image img = iconBtn.getImage();
        Image resizedImg = img.getScaledInstance(20,20,java.awt.Image.SCALE_SMOOTH);
        iconBtn.setImage(resizedImg);
        Icon = new JButton(iconBtn);
    }

    public void setVisibleModel(boolean isVisible){
        setVisible(isVisible);
    }


    public static LoginUI getModel(){
        LoginUI LoginUI = new LoginUI("Login");
        LoginUI.setContentPane(LoginUI.getMainContainer());
        LoginUI.setSize(700,500);
        LoginUI.setLocation(300,300);
        LoginUI.setDefaultCloseOperation(1);
        return LoginUI;
    }

    public JTextField getEmailText() {
        return EmailText;
    }

    public JTextField getPassText() {
        return PassText;
    }
}
