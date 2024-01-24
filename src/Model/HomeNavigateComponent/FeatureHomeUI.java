package Model.HomeNavigateComponent;


import Model.Components.ImageDisplayer;

import javax.swing.*;

public class FeatureHomeUI extends JPanel{
    private JPanel FeatureWrapper;
    private JPanel HeaderItem1;
    private JLabel HeaderTitle;
    private JPanel CardBody1;
    private JPanel Item1;
    private JPanel Item1Center;
    private JLabel img1;
    private JLabel ProdTitle;
    private JLabel Price;
    private JLabel PriceDetail;
    private JButton BuyBtn;
    private JPanel Item2;
    private JPanel HeaderItem2;
    private JPanel CardBody2;
    private JLabel HeaderTitle2;
    private JPanel Item2Center;
    private JLabel img2;
    private JLabel ProdTitle2;
    private JPanel FooterCard1;
    private JPanel FooterCard2;
    private JButton BuyBtn2;
    private JPanel Item3;
    private JPanel HeaderItem3;
    private JPanel CardBody3;
    private JLabel HeaderTitle3;
    private JPanel Item3Center;
    private JLabel img3;
    private JLabel ProdTitle3;
    private JPanel FooterCard3;
    private JButton BuyBtn3;
    private JLabel Price2;
    private JLabel PriceDetail2;
    private JLabel PriceDetail3;
    private JLabel Price3;

    public FeatureHomeUI() {
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
        img1 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",250,300,217,30,23);
        img2 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\samsungg.PNG",250,300,217,30,23);
        img3 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\xiaomi.PNG",250,300,217,30,23);


    }

    public JPanel getFeatureWrapper() {
        return FeatureWrapper;
    }
}
