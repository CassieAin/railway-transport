package view;

import model.Carriage;
import model.LevelOfComfort;
import model.PassengerTrain;
import model.Transport;
import services.TransportManipulator;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    static{
        Carriage[] arr = {
                new Carriage(4, 70, 65, LevelOfComfort.BUSINESS),
                new Carriage(1, 100, 105, LevelOfComfort.ECONOM),
                new Carriage(2, 85, 82, LevelOfComfort.ECONOM),
                new Carriage(3, 100, 95, LevelOfComfort.BUSINESS)
        };
    }

    private ArrayList<Carriage>  addCarriage( ){
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carriage> carriages = new ArrayList<>();
        System.out.println("Input Level of comfort");
        System.out.println();
        String level = scanner.nextLine();
        LevelOfComfort x = LevelOfComfort.valueOf(level.toUpperCase().trim());

        System.out.println("Input carriage number");
        int carnum = scanner.nextInt();


        System.out.println("Input Luggage Quantity");
        int lugq = scanner.nextInt();

        System.out.println("Input Passengers Quantity");
        int pass = scanner.nextInt();

        carriages.add(new Carriage(carnum, lugq, pass, x));
        return carriages;
    }

    public void view(){
        //ArrayList<Carriage> newCarriages = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello user! Create passenger train, please!");
        System.out.println("Input train name, please:");
        String trainName = scanner.nextLine();
        System.out.println("Create your first carriage, please:");
        ArrayList<Carriage> newCarriages = addCarriage();
        Transport transport = new PassengerTrain("new train", newCarriages);
        TransportManipulator manipulator = new TransportManipulator(transport);

        System.out.println("Train " + trainName + " was successfully created");
        while(true){
            System.out.println("\n1 - Display the train information");
            System.out.println("2 - Add carriage");
            System.out.println("3 - Display the quantity of luggage");
            System.out.println("4 - Display the quantity of passengers");
            System.out.println("5 - Display train carriages sorted by comfort level");
            System.out.println("6 - Find carriages for a range of passengers");
            System.out.println("7 - Exit");
            System.out.println("Choose option, please:");
            int option = scanner.nextInt();
            switch(option){
                case 1:
                    System.out.println(transport);
                    break;
                case 2:
                    newCarriages.addAll(addCarriage());
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
                    System.out.println("Input the first number of the range");
                    int first = scanner.nextInt();
                    System.out.println("Input the second number of the range");
                    int second = scanner.nextInt();
                    ArrayList<Carriage> foundCarriages = manipulator.findCarriagesInRange(first, second);
                    for(Carriage c : foundCarriages){
                        System.out.println(c);
                    }
                    break;
                case 7:
                    System.exit(0);
                    break;


            }
        }


    }
}
