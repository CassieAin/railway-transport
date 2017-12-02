package controller;

import view.UserInterface;
import view.exceptions.WrongInputException;

public class MainController {

    public static void run() throws WrongInputException {
        UserInterface view = new UserInterface();
        view.view();
    }
}
