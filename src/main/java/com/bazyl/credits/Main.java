package com.bazyl.credits;

import com.bazyl.credits.controller.Controller;
import com.bazyl.credits.view.Console;

public class Main {

    public static void main(String[] args) {
        Console console = new Console();
        Controller controller = new Controller(console);
        controller.processUser();
    }
}
