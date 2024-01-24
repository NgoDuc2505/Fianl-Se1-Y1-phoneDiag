package Model.AdminComponent;

import Controller.AddprodPopupController;
import Model.HomeNavigateComponent.Product;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.*;

public class AddProdPopup extends JFrame {
    private JPanel Container;
    private JPanel ContentContainer;
    private JLabel Title;
    private JPanel BodyPopup;
    private JTextField nameTf;
    private JButton filrChooseBtn;
    private JPanel buttonWrapper;
    private JLabel nameLbl;
    private JTextArea decsTaf;
    private JLabel priceLbl;
    private JLabel decsLbl;
    private JLabel quantityLbl;
    private JLabel imgLbl;
    private JTextField priceTf;
    private JTextField quantityTf;
    private JButton CancelBtn;
    private JButton OkBtn;
    private JLabel showPathLbl;

    private JFileChooser file = new JFileChooser();


    private String path = "";
    private String fileName = "";
    private String pathAbsoluteAfter = "";;

    public AddProdPopup(String title) throws HeadlessException {
        super(title);
        filrChooseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                fileChooseImgPath();
            }
        });
        OkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readAndWriteFile(path,fileName);
                AddprodPopupController.addProdToDB(pathAbsoluteAfter);
            }
        });
        CancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    private void fileChooseImgPath(){
        int value = file.showSaveDialog(null);
        if (value == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            showPathLbl.setText(path);
            fileName = selectedFile.getName();
        }
    }

    private void readAndWriteFile(String path, String fileName){
        try {
            BufferedImage image = ImageIO.read(new File(path));
            ImageIO.write(image , "png", new File("D:\\VKU\\se1-y1\\OOP-JAVA\\JAVA-PHONE\\Phone\\src\\Public\\"+fileName));
            pathAbsoluteAfter = "D:\\\\VKU\\\\se1-y1\\\\OOP-JAVA\\\\JAVA-PHONE\\\\Phone\\\\src\\\\Public\\\\"+fileName;
            System.out.println("Origin: "+pathAbsoluteAfter);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    private void createUIComponents() {
        // TODO: place custom component creation code here
        showPathLbl = new JLabel();
    }

    public JTextField getNameTf() {
        return nameTf;
    }

    public JTextArea getDecsTaf() {
        return decsTaf;
    }

    public JTextField getPriceTf() {
        return priceTf;
    }

    public JTextField getQuantityTf() {
        return quantityTf;
    }

    public void setVisibleModel(boolean isVisible){
        setVisible(isVisible);
    }

    public JPanel getContainer() {
        return Container;
    }
}
