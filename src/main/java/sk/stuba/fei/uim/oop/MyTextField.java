package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    public MyTextField(String text) {
        super(text);
        setEditable(false);
        setFont(new Font("Arial",Font.PLAIN,20));
    }
}
