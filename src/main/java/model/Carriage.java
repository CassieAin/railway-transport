package model;

public class Carriage {
    private int carriageNumber;
    private int luggageQuantity;
    private int passengersQuantity;
    private LevelOfComfort levelOfComfort;

    public Carriage(){

    }

    public Carriage(int carriageNumber, int luggageQuantity, int passengersQuantity, LevelOfComfort levelOfComfort) {
        this.carriageNumber = carriageNumber;
        this.luggageQuantity = luggageQuantity;
        this.passengersQuantity = passengersQuantity;
        this.levelOfComfort = levelOfComfort;
    }

    public int getCarriageNumber() {
        return carriageNumber;
    }

    public void setCarriageNumber(int carriageNumber) {
        this.carriageNumber = carriageNumber;
    }

    public int getLuggageQuantity() {
        return luggageQuantity;
    }

    public void setLuggageQuantity(int luggageQuantity) {
        this.luggageQuantity = luggageQuantity;
    }

    public int getPassengersQuantity() {
        return passengersQuantity;
    }

    public void setPassengersQuantity(int passengersQuantity) {
        this.passengersQuantity = passengersQuantity;
    }

    public LevelOfComfort getLevelOfComfort() {
        return levelOfComfort;
    }

    public void setLevelOfComfort(LevelOfComfort levelOfComfort) {
        this.levelOfComfort = levelOfComfort;
    }

    @Override
    public String toString() {
        return "{" + carriageNumber +
                ", " + luggageQuantity +
                ", " + passengersQuantity +
                ", " + levelOfComfort +
                '}';
    }
}
