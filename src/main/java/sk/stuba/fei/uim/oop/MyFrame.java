package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JTextField text = new JTextField();
    JLabel result = new JLabel();
    String operation="";
    String expression="";
    double partialResult;
    String partialNum ="";
    boolean calculated = false;
    String number ="";
    public MyFrame() throws HeadlessException {
        setLayout(new GridLayout(0, 4));
        JButton comma = new JButton(".");
        JButton seven = new JButton("7");
        JButton eight = new JButton("8");
        JButton nine = new JButton("9");
        JButton delete = new JButton("C");
        JButton four = new JButton("4");
        JButton five = new JButton("5");
        JButton six = new JButton("6");
        JButton division = new JButton("/");
        JButton one = new JButton("1");
        JButton two = new JButton("2");
        JButton three = new JButton("3");
        JButton multiplication = new JButton("*");
        JButton zero = new JButton("0");
        JButton minus = new JButton("-");
        JButton plus = new JButton("+");
        JButton equals = new JButton("=");

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

        add(text);
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
            partialNum = "";
            number = "";
        }
        else if (command.equals("=")){
            // urbit rovna sa
            if(!operation.equals("")){
                partialNum = calculate();
                number = "";
                operation = "";
                calculated = true;

            }
        }
        else{

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
}
