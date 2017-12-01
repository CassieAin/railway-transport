package model;

import java.util.Comparator;

public class LevelOfComfortComparator implements Comparator<Carriage> {

    public int compare(Carriage carriage1, Carriage carriage2) {
        return carriage1.getLevelOfComfort().compareTo(carriage2.getLevelOfComfort());
    }
}
