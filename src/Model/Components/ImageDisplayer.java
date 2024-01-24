package Model.Components;

import javax.swing.*;
import java.awt.*;

public class ImageDisplayer extends JLabel {

    private ImageDisplayer(ImageIcon imageIcon) {
        super(imageIcon);
    }

    public static JLabel imageSet(String url, int width, int height,int r,int b, int g){
        try{
            ImageIcon imageIcon = new ImageIcon(url);
            Image image = imageIcon.getImage();
            Image resizedImg = image.getScaledInstance(width,height,java.awt.Image.SCALE_SMOOTH);
            imageIcon.setImage(resizedImg);
            JLabel finalImage = new ImageDisplayer(imageIcon);
            Color getHexColor = new Color(r,b,g);
            finalImage.setBackground(getHexColor);
            finalImage.setOpaque(true);
            return finalImage ;
        }catch (Exception e){
            System.out.println("Invalid url !");
            return null;
        }
    }
}
