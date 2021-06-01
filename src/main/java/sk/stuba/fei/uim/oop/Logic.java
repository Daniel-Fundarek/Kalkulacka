package sk.stuba.fei.uim.oop;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Logic {
    @Getter
    String operation="";
    String partialNum ="0";
    boolean calculated = true;
    String number ="";

    public String evaluate(String command){
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
        return number+operation+partialNum;
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
