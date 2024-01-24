package Model.HomeNavigateComponent;

import Model.Components.ImageDisplayer;

import javax.swing.*;
import java.awt.*;

public class ListProdHomeUI {
    private JPanel ListProdWrapper;
    private JPanel ListProdCenter;
    private JLabel ItemImg;
    private JLabel ItemImg2;
    private JLabel ItemImg3;
    private JLabel ItemImg4;
    private JLabel ItemImg5;
    private JLabel ItemImg6;
    private JLabel ItemImg7;
    private JLabel ItemImg8;
    private JLabel ItemImg9;
    private JLabel ItemImg10;

    public ListProdHomeUI() {
    }

    public JPanel getListProdWrapper() {
        return ListProdWrapper;
    }



    private void createUIComponents() {
        // TODO: place custom component creation code here
        ItemImg = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg2 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg3 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg4 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg5 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg6 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg7 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg8 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg9 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ItemImg10 = ImageDisplayer.imageSet("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\iphone155.PNG",70,110,0,0,0);
        ListProdCenter = new JPanel();
        ListProdCenter.setLayout(new GridLayout(2,5));
    }

    public JPanel getListProdCenter() {

        return ListProdCenter;
    }
}
