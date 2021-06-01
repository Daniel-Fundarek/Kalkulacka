package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class MyFrame extends JFrame implements ActionListener, KeyListener {

    MyTextField result = new MyTextField("0");
    //JLabel result = new JLabel();
    String operation="";
    String expression="";
    double partialResult;
    String partialNum ="0";
    boolean calculated = true;
    String number ="";
    public MyFrame() throws HeadlessException {
        setLayout(new GridLayout(0, 4));
        MyButton comma = new MyButton(".");
        MyButton seven = new MyButton("7");
        MyButton eight = new MyButton("8");
        MyButton nine = new MyButton("9");
        MyButton delete = new MyButton("C");
        MyButton four = new MyButton("4");
        MyButton five = new MyButton("5");
        MyButton six = new MyButton("6");
        MyButton division = new MyButton("/");
        MyButton one = new MyButton("1");
        MyButton two = new MyButton("2");
        MyButton three = new MyButton("3");
        MyButton multiplication = new MyButton("*");
        MyButton zero = new MyButton("0");
        MyButton minus = new MyButton("-");
        MyButton plus = new MyButton("+");
        MyButton equals = new MyButton("=");

        comma.addActionListener(this);
        seven.addActionListener(this);
        eight.addActionListener(this);
        nine.addActionListener(this);
        delete.addActionListener(this);
        four.addActionListener(this);
        five.addActionListener(this);
        six.addActionListener(this);
        division.addActionListener(this);
        one.addActionListener(this);
        two.addActionListener(this);
        three.addActionListener(this);
        multiplication.addActionListener(this);
        zero.addActionListener(this);
        minus.addActionListener(this);
        plus.addActionListener(this);
        equals.addActionListener(this);

        addKeyListener(this);

        add(new JLabel());
        add(new JLabel());
        add(result);
        add(comma);
        add(seven);
        add(eight);
        add(nine);
        add(delete);
        add(four);
        add(five);
        add(six);
        add(division);
        add(one);
        add(two);
        add(three);
        add(multiplication);
        add(zero);
        add(minus);
        add(plus);
        add(equals);


        setSize(600, 600);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        System.out.println(checkForNum(command));
        evaluate(command);

    }
    public void evaluate(String command){
        if(checkForNum(command) || command.equals(".")){
            if(calculated){
                partialNum = command;
                calculated =false;
            }
            else {
                partialNum = partialNum + command;
                System.out.println(partialNum);
            }
        }
        else if (command.equals("C")){
            operation = "";
            partialNum = "0";
            number = "";
            calculated = true;
        }
        else if (command.equals("=")){
            // urbit rovna sa
            if(!partialNum.equals("")) {
                if (!operation.equals("")) {
                    partialNum = calculate();
                    number = "";
                    operation = "";
                    calculated = true;

                }
            }
        }
        else if(Arrays.asList("+","-","*","/").contains(command)){

            if ( number.equals(""))
            {
                number = partialNum;
                partialNum = "";
            }
            else if(!partialNum.equals("")){
                number = calculate(); // number |operation| partialNum
                partialNum = "";

            }
            operation = command;
        }
        result.setText(number+operation+partialNum);
    }
    public boolean checkForNum(String string) {
        try {
            Integer.parseInt(string);
            return true;
        }
            catch(NumberFormatException e){
            return false;
        }
    }
    public String calculate(){
        double x,y;
        x = Double.parseDouble(number);
        y = Double.parseDouble(partialNum);
        if(operation.equals("+")){
            return String.valueOf(x+y);
        }
        else if(operation.equals("-")){
            return String.valueOf(x-y);
        }
        else if(operation.equals("*")){
            return String.valueOf(x*y);
        }else {
            if(y == 0 ){
                return "0";
            }
            return String.valueOf(x/y);
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println(e.getKeyChar());
        String command =  "" + e.getKeyChar();
        evaluate(command);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
