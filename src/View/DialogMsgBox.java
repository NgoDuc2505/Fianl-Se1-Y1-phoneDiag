package View;

import javax.swing.*;

public class DialogMsgBox {

    public static void runWarning(String msg){
        JOptionPane.showMessageDialog(new JFrame(),msg,"Warning",JOptionPane.WARNING_MESSAGE);
    }

    public static void runSuccess(String msg){
        JOptionPane.showMessageDialog(new JFrame(),msg,"Success",JOptionPane.INFORMATION_MESSAGE);
    }

    public static int optionBox(String msg){
        int input = JOptionPane.showConfirmDialog(null,
                msg, "Select an Option...",JOptionPane.YES_NO_CANCEL_OPTION);
        return input;
    }
}
