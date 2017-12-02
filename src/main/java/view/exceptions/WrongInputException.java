package view.exceptions;

public class WrongInputException extends Exception {

    @Override
    public String getMessage() {
        return "Wrong input";
    }
}
