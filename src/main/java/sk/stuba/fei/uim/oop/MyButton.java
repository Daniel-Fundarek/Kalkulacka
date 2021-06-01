package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    public MyButton(String text) {
        super(text);
        setFocusable(false);
        setFont(new Font("Arial",Font.PLAIN,20));
        setPreferredSize( new Dimension( 450, 150 ) );
    }
}
