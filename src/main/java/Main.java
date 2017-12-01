import model.Carriage;
import model.LevelOfComfort;
import model.PassengerTrain;
import model.Transport;
import services.TransportManipulator;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Carriage[] arr = {
                new Carriage(4, 70, 65, LevelOfComfort.BUSINESS),
                new Carriage(1, 100, 105, LevelOfComfort.ECONOM),
                new Carriage(2, 85, 82, LevelOfComfort.ECONOM),
                new Carriage(3, 100, 95, LevelOfComfort.BUSINESS)
        };
        ArrayList<Carriage> carriages = new ArrayList<>();
        carriages.addAll(Arrays.asList(arr));

        Transport transport = new PassengerTrain("new train", carriages);
        System.out.println("Output smth");
        System.out.println(transport);
        TransportManipulator manipulator = new TransportManipulator(transport);
        System.out.println("Luggage Quantity:" + manipulator.getLuggageQuantity());
        System.out.println("Passengers Quantity" + manipulator.getPassengersQuantity());
        manipulator.sortCarriagesByComfortLevel();
        System.out.println("Output sorted");
        System.out.println(transport);
        System.out.println("foundCarriages");
        ArrayList<Carriage> foundCarriages = manipulator.findCarriagesInRange(90, 92);
        for(Carriage c : foundCarriages){
            System.out.println(c);
        }
    }
}
