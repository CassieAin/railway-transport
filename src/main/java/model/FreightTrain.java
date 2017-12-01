package model;

import java.util.ArrayList;

public class FreightTrain extends Transport {

    public FreightTrain() {
    }

    public FreightTrain(String name, ArrayList<Carriage> carriages) {
        super(name, carriages);
    }
}
