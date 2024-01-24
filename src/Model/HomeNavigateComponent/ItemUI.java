package Model.HomeNavigateComponent;

import Controller.MProdList;
import Model.Components.Cart;
import Model.Components.ImageDisplayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ItemUI extends JPanel {
    private JPanel Itemprod;
    private JPanel ItemHeader;
    private JPanel ItemBody;
    private JPanel ItemBodyContent;
    private JLabel ItemImg;
    private JPanel ItemDetail;
    private JLabel ItemName;
    private JLabel ItemPrice;
    private JPanel ItemBtnWrapper;
    private JButton ItemBuyBtn;
    private JButton ItemDetailBtn;

    private String imgURL;
    private String itemTitle;
    private String itemPrice;
    private String itemId;

    public ItemUI(String imgURL, String itemTitle, String itemPrice, String itemId) {
        this.imgURL = imgURL;
        this.itemTitle = itemTitle;
        this.itemPrice = itemPrice;
        this.itemId = itemId;
        ItemBuyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("buy: "+itemId);
                Product prod = MProdList.findProdById(itemId);
                System.out.println(prod.toString());
                Cart.addToCart(prod);
            }
        });
        ItemDetailBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("detail: "+itemId);
                Product prod = MProdList.findProdById(itemId);
                System.out.println(prod.toString());
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        Color color = new Color(249,207,130);
        ItemImg = ImageDisplayer.imageSet(this.imgURL,100,150,color.getRed(),color.getGreen(),color.getBlue());
    }

    public JPanel getItemprod() {
        String tileCombineId =this.itemTitle+"|"+this.itemId;
        ItemName.setText(tileCombineId);
        ItemPrice.setText(itemPrice);
        Cursor pointer = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
        ItemBuyBtn.setCursor(pointer);
        ItemDetailBtn.setCursor(pointer);
        return Itemprod;
    }
}
