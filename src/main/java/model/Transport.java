package model;

import java.util.ArrayList;

public abstract class Transport{
    protected String name;
    protected ArrayList<Carriage> carriages;

    public Transport() {
    }

    public Transport(String name, ArrayList<Carriage> carriages) {
        this.name = name;
        this.carriages = carriages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(ArrayList<Carriage> carriages) {
        this.carriages = carriages;
    }

    public int getCarriagesNumber(){
        return carriages.size();
    }

    @Override
    public String toString() {
        return "" + name + '\n' +
                "" + carriages;
    }
}
