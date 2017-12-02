package controller;

import view.UserInterface;

public class MainController {

    public static void run(){
        UserInterface view = new UserInterface();
        view.view();
    }
}
