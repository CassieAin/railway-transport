package view;

import model.Carriage;
import model.LevelOfComfort;
import model.PassengerTrain;
import model.Transport;
import services.ResourceManager;
import services.TransportManipulator;
import view.exceptions.WrongInputException;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static view.constants.UserInterfaceConstants.InputConstants.*;
import static view.constants.UserInterfaceConstants.MenuConstants.*;

public class UserInterface{
    public ResourceManager manager = ResourceManager.INSTANCE;

    static{
        Carriage[] arr = {
                new Carriage(4, 70, 65, LevelOfComfort.BUSINESS),
                new Carriage(1, 100, 105, LevelOfComfort.ECONOM),
                new Carriage(2, 85, 82, LevelOfComfort.ECONOM),
                new Carriage(3, 100, 95, LevelOfComfort.BUSINESS)
        };
    }

    public void changeLocale(){
        System.out.println(manager.getValue(CHANGE_LOCALE));
        manager.changeResource(new Locale(new Scanner(System.in).nextLine()));
    }


    private ArrayList<Carriage> addCarriage( ){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carriage> carriages = new ArrayList<>();
        System.out.println(manager.getValue(INPUT_LEVEL_OF_COMFORT));
        System.out.println();
        String level = scanner.nextLine();
        LevelOfComfort comfortLevel = LevelOfComfort.valueOf(level.toUpperCase().trim());

        System.out.println(manager.getValue(INPUT_CARRIAGE_NUMBER));
        int carriageNumber = scanner.nextInt();


        System.out.println(manager.getValue(INPUT_LUGGAGE_QUANTITY));
        int luggageQuantity = scanner.nextInt();

        System.out.println(manager.getValue(INPUT_PASSENGERS_QUANTITY));
        int passengersQuantity = scanner.nextInt();

        carriages.add(new Carriage(carriageNumber, luggageQuantity, passengersQuantity, comfortLevel));
        return carriages;
    }

    public void view() throws WrongInputException {
        changeLocale();
        Scanner scanner = new Scanner(System.in);
        System.out.println(manager.getValue(MENU_CASE_0));
        System.out.println(manager.getValue(INPUT_TRAIN_NAME));
        String trainName = scanner.nextLine();
        System.out.println(manager.getValue(MENU_CASE_0_1));
        ArrayList<Carriage> newCarriages = addCarriage();
        Transport transport = new PassengerTrain(trainName, newCarriages);
        TransportManipulator manipulator = new TransportManipulator(transport);

        System.out.println(manager.getValue(TRAIN_CREATED));
        while(true){
            System.out.println();
            System.out.println(manager.getValue(MENU_CASE_1));
            System.out.println(manager.getValue(MENU_CASE_2));
            System.out.println(manager.getValue(MENU_CASE_3));
            System.out.println(manager.getValue(MENU_CASE_4));
            System.out.println(manager.getValue(MENU_CASE_5));
            System.out.println(manager.getValue(MENU_CASE_6));
            System.out.println(manager.getValue(MENU_CASE_7));
            System.out.println(manager.getValue(MENU_CASE_8));
            System.out.println(manager.getValue(MENU_CHOOSE));
            int option = scanner.nextInt();

            if(option > 8 || option < 1)
                throw new WrongInputException();

            switch(option){
                case 1:
                    System.out.println(transport);
                    break;
                case 2:
                    newCarriages.addAll(addCarriage());
                    System.out.println(manager.getValue(CARRIAGE_ADDED));
                    break;
                case 3:
                    System.out.println(manipulator.getLuggageQuantity());
                    break;
                case 4:
                    System.out.println(manipulator.getPassengersQuantity());
                    break;
                case 5:
                    manipulator.sortCarriagesByComfortLevel();
                    System.out.println(transport);
                    break;
                case 6:
                    System.out.println(manager.getValue(INPUT_FIRST_NUMBER));
                    int first = scanner.nextInt();
                    System.out.println(manager.getValue(INPUT_SECOND_NUMBER));
                    int second = scanner.nextInt();
                    ArrayList<Carriage> foundCarriages = manipulator.findCarriagesInRange(first, second);
                    for(Carriage c : foundCarriages){
                        System.out.println(c);
                    }
                    break;
                case 7:
                    changeLocale();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println(manager.getValue(WRONG_INPUT_MESSAGE));
                    break;
            }
        }
    }
}
