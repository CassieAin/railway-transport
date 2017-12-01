package model;

import java.util.ArrayList;

public class PassengerTrain extends Transport {

    public PassengerTrain() {
    }

    public PassengerTrain(String name, ArrayList<Carriage> carriages) {
        super(name, carriages);
    }
}
