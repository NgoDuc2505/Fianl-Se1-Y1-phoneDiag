package Model;

import Controller.HomeController;
import Controller.OrderController;
import Model.Components.Cart;
import Model.Components.ImageDisplayer;
import Model.HomeNavigateComponent.FeatureHomeUI;
import Model.HomeNavigateComponent.ListProdHomeUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeUI extends JFrame {
    private JPanel MainContainer;
    private JPanel SideContainer;
    private JTextArea TitleSide;
    private JPanel SideHeaderContainer;
    private JLabel LogoImg;
    private JPanel SideContentContainer;
    private JPanel ContainerContent;
    private JButton ProductListBtn;
    private JButton FeaturesButton;
    private JButton AdminLoginBtn;
    private JPanel ProductListBtnWrapper;
    private JPanel featuresButtonWrapper;
    private JPanel AdminLoginBtnWrapper;
    private JLabel IconList;
    private JLabel IconFeat;
    private JLabel IconAdmin;
    private JPanel CopyRight;
    private JLabel CopyRightContent;
    private JPanel RightContainer;
    private JPanel HeaderContentContainer;
    private JPanel HeaderSplitContainer;
    private JPanel CurrentTab;
    private JPanel SearchBar;
    private JLabel ArrowIcon;
    private JLabel TabTitle;
    private JButton SearchBtn;
    private JLabel SearchIcon;
    private JTextField SearchText;
    private JPanel SearchContainer;
    private JScrollPane BodyContainer;
    private JPanel ScrollBody;
    private JPanel BodyMainWrapper;
    private JPanel NavidateHolder;
    private FeatureHomeUI TabFeatUI ;
    private JComboBox PageSelection;
    private JLabel IconPage;
    private JPanel PageSection;
    private JButton CartBtn;

    private JPanel contentPanel = new FeatureHomeUI().getFeatureWrapper();
    private JPanel contentListPanel = new ListProdHomeUI().getListProdWrapper();

    private JPanel contentListProdCenterPanel = new ListProdHomeUI().getListProdCenter();
    public HomeUI(String title) throws HeadlessException {
        super(title);
        ProductListBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeController.switchTab("Product List");
            }
        });
        FeaturesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeController.switchTab("Feature Products");
            }
        });
        AdminLoginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomeController.adminBtnClick();
            }
        });
        PageSelection.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(PageSelection.getSelectedIndex()+1);
                HomeController.renderItemProd(PageSelection.getSelectedIndex() + 1);
            }
        });
        CartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderFormUI orderUi = OrderController.renderUI();
                orderUi.setVisible(true);
                orderUi.getTotalBill().setText(Cart.showTotalBill());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        LogoImg = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Mobile-Smartphone-icon.png",50,50,30,139,195);
        IconAdmin = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Administrator-icon.png",30,30,68,108,178);
        IconFeat = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\feat.png",30,30,68,108,178);
        IconList = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\list.png",30,30,68,108,178);
        ArrowIcon = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Arrow-Right-icon.png",30,30,235,209,194);
        SearchIcon = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Zoom-icon.png",20,20,235,209,194);
        IconPage = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\Zoom-icon.png",30,30,68,108,178);
        NavidateHolder = new JPanel();
        TabTitle = new JLabel("Feature products");
        TabTitle.paintImmediately(TabTitle.getVisibleRect());
    }



    public static void setVisibleModel(boolean isVisible){
        setVisibleModel(isVisible);
    }


    public JButton getProductListBtn() {
        return ProductListBtn;
    }

    public JButton getFeaturesButton() {
        return FeaturesButton;
    }

    public JButton getAdminLoginBtn() {
        return AdminLoginBtn;
    }

    public JPanel getNavidateHolder() {
        return NavidateHolder;
    }

    public JPanel getContentPanel() {
        return contentPanel;
    }

    public JLabel getTabTitle() {
        return TabTitle;
    }

    public JPanel getMainContainer() {
        return MainContainer;
    }

    public JPanel getContentListPanel() {
        return contentListPanel;
    }

    public JPanel getContentListProdCenterPanel() {
        return contentListProdCenterPanel;
    }

    public JPanel getPageSection() {
        return PageSection;
    }

    public JComboBox getPageSelection() {
        return PageSelection;
    }
}
