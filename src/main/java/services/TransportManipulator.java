package services;

import model.Carriage;
import model.LevelOfComfortComparator;
import model.Transport;

import java.util.ArrayList;

public class TransportManipulator {
    private Transport transport;

    public TransportManipulator() {
    }

    public TransportManipulator(Transport transport) {
        this.transport = transport;
    }

    public int getPassengersQuantity(){
        int passengersNumber = 0;
        for(Carriage carriage : transport.getCarriages()){
            passengersNumber += carriage.getPassengersQuantity();
        }
        return passengersNumber;
    }

    public int getLuggageQuantity(){
        int luggageNumber = 0;
        for(Carriage carriage : transport.getCarriages()){
            luggageNumber += carriage.getLuggageQuantity();
        }
        return luggageNumber;
    }

    public void sortCarriagesByComfortLevel(){
        ArrayList<Carriage> carriages = transport.getCarriages();
        carriages.sort(new LevelOfComfortComparator());
    }

    public ArrayList<Carriage> findCarriagesInRange(int from, int to){
        ArrayList<Carriage> foundCarriages = new ArrayList<>();
        for(Carriage carriage : transport.getCarriages()){
            if(carriage.getPassengersQuantity() > from &&  carriage.getPassengersQuantity() < to){
                foundCarriages.add(carriage);
            }
        }
        return foundCarriages;
    }

    public Transport getTransport() {
        return transport;
    }

    public void setTransport(Transport transport) {
        this.transport = transport;
    }
}
