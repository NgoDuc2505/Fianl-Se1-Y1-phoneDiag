package Model;

import Controller.SignUpController;
import Model.Components.ImageDisplayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpUI extends JFrame {
    private JPanel MainContainer;
    private JPanel SideBarContainer;
    private JPanel ContentContainer;
    private JTextArea welcomeToAdminTextArea;
    private JPanel ActionBtnContainer;
    private JButton SubmitBtn;
    private JButton cancelButton;
    private JPanel ImgHolder;
    private JLabel ImageShow;
    private JLabel ContactLbl;
    private JPanel ContentHelpContainer;
    private JLabel ImageLblSub;
    private JPanel RightContainer;
    private JPanel RegisterFormContainer;
    private JLabel RegisterTitle;
    private JPanel FormContainerCenter;
    private JLabel FirstNamelbl;
    private JTextField FirstNameText;
    private JLabel EmailLb;
    private JTextField EmailTf;
    private JTextField UserNameText;
    private JTextField PassText;
    private JLabel Passlbl;
    private JButton BackBtn;
    private JLabel RoleSelectionLbl;
    private JComboBox RoleSelection;

    private final String roleList[]={"ADMIN","SADMIN"};

    public SignUpUI(String title) throws HeadlessException {
        super(title);
        SubmitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = FirstNameText.getText();
                String email = EmailTf.getText();
                String pass = PassText.getText();
                String role = RoleSelection.getSelectedItem().toString();
                Adminstrator employee = new Adminstrator(name,1,email,pass,role);
                SignUpController.addEmployee(employee);
            }
        });
    }



    private void createUIComponents() {
        ImageShow = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Help-icon.png",20,20,154,89,181);
        ImageLblSub = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Clients-icon.png",100,90,154,89,181);
        RoleSelection = new JComboBox<>(roleList);
    }

    public JPanel getMainContainer() {
        return MainContainer;
    }

    public void setVisibleModel(boolean isVisible){
        setVisible(isVisible);
    }

    public static SignUpUI getModel(){
        SignUpUI newSignUpUi = new SignUpUI("Sign up");
        newSignUpUi.setContentPane(newSignUpUi.MainContainer);
        newSignUpUi.setSize(700,500);
        newSignUpUi.setLocation(300,300);
        newSignUpUi.setDefaultCloseOperation(1);
        return newSignUpUi;
    }

    public JTextField getFirstNameText() {
        return FirstNameText;
    }

    public JTextField getEmailTf() {
        return EmailTf;
    }

    public JTextField getPassText() {
        return PassText;
    }
}
