package org.example;

public class SmartKitchen {

    private CoffeeMaker brewMaster;
    private DishWasher dishWasher;
    private Refrigerator iceBox;

    public SmartKitchen(CoffeeMaker brewMaster, DishWasher dishWasher, Refrigerator iceBox) {
        this.brewMaster = brewMaster;
        this.dishWasher = dishWasher;
        this.iceBox = iceBox;
    }

    public void addWater() {
        this.getBrewMaster().setHasWorkToDo(true);
    }

    public void pourMilk() {
        this.getIceBox().setHasWorkToDo(true);
    }

    public void loadDishwasher() {
        this.getDishWasher().setHasWorkToDo(true);
    }

    public String doKitchenWork() {
        return brewMaster.brewCoffee() + " " +
                dishWasher.doDishes() + " " +
                iceBox.orderFood();
    }

    public void setKitchenState(boolean coffeeMakerState, boolean dishWasherState, boolean iceBoxState) {
        brewMaster.setHasWorkToDo(coffeeMakerState);
        dishWasher.setHasWorkToDo(dishWasherState);
        iceBox.setHasWorkToDo(iceBoxState);
    }

    public CoffeeMaker getBrewMaster() {
        return brewMaster;
    }

    public void setBrewMaster(CoffeeMaker brewMaster) {
        this.brewMaster = brewMaster;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public void setDishWasher(DishWasher dishWasher) {
        this.dishWasher = dishWasher;
    }

    public Refrigerator getIceBox() {
        return iceBox;
    }

    public void setIceBox(Refrigerator iceBox) {
        this.iceBox = iceBox;
    }
}
