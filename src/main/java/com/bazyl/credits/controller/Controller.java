package com.bazyl.credits.controller;

import com.bazyl.credits.view.Console;

import java.util.Scanner;

public class Controller {
    Console console;

    public Controller(Console console){
        this.console=console;
    }

    public void processUser(){
        Scanner scanner = new Scanner(System.in);
        console.showHelloMessage();
        console.showOptionsBankMessage();
        checkActionAndDo(scanner);
    }

    void checkActionAndDo(Scanner scanner){
        int actionOption;
        while (true){
            actionOption = getActionWithBank(scanner);
            switch (actionOption){
                case 1: {
                    console.showMessage("show bank");
                    break;
                }
                case 2:{
                    console.showMessage("chose credit");
                    break;
                }
                case 3:{
                    return;
                }
                default:{
                    console.showIncorrectMessage();
                }
            }
        }

    }

    int getActionWithBank(Scanner scanner){
        while (!scanner.hasNextInt()){
            console.showIncorrectMessage();
            scanner.next();
        }
        return scanner.nextInt();
    }



}
