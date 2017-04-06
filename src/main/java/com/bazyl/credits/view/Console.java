package com.bazyl.credits.view;

import com.bazyl.credits.model.Bank;

import java.util.Locale;
import java.util.ResourceBundle;

public class Console {
    ResourceBundle resourceBundle;
    String helloMessage;
    String optionsBankMessage;
    String optionsCreditMessage;
    String incorrectOptionMessage;
    public Console(){
        resourceBundle = ResourceBundle.getBundle("MyResource",new Locale("uk","UA"));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(resourceBundle.getString("OPTIONS_MESSAGE")).append("\n")
                .append(resourceBundle.getString("OPT_SHOW_CREDITS")).append("\n")
                .append(resourceBundle.getString("OPT_PICK_CREDIT")).append("\n")
                .append(resourceBundle.getString("OPT_EXIT")).append("\n");
        optionsBankMessage = stringBuilder.toString();
        helloMessage = resourceBundle.getString("HELLO_MESSAGE");
        incorrectOptionMessage = resourceBundle.getString("OPT_INCORRECT");
    }
    public void showBank(Bank bank){
        System.out.println(bank);
    }

    public void showMessage(String msg){
        System.out.println(msg);
    }

    public void showHelloMessage(){
        System.out.println(helloMessage);
    }

    public void showIncorrectMessage(){
        System.out.println(incorrectOptionMessage);
    }

    public void showOptionsBankMessage(){
        System.out.println(optionsBankMessage);
    }
}
