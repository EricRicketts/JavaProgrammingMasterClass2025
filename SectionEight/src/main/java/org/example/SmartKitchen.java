package org.example;

public class SmartKitchen {

    private CoffeeMaker coffeeMaker;
    private DishWasher dishWasher;
    private Refrigerator refrigerator;

    public SmartKitchen(
        CoffeeMaker coffeeMaker,
        DishWasher dishWasher,
        Refrigerator refrigerator
    ) {
        this.coffeeMaker = coffeeMaker;
        this.dishWasher = dishWasher;
        this.refrigerator = refrigerator;
    }

    public void addWater() {
        this.coffeeMaker.addWater();
    }

    public void pourMilk() {
        this.refrigerator.pourMilk();
    }

    public void loadDishwasher() {
        this.dishWasher.loadDishwasher();
    }

    public String doKitchenWork() {
        return coffeeMaker.brewCoffee() + " " +
                dishWasher.doDishes() + " " +
                refrigerator.orderFood();
    }

    public void setKitchenState(
        boolean coffeeMakerState,
        boolean dishWasherState,
        boolean refrigeratorState
    ) {
        this.getCoffeeMaker().setHasWorkToDo(coffeeMakerState);
        this.getDishWasher().setHasWorkToDo(dishWasherState);
        this.getRefrigerator().setHasWorkToDo(refrigeratorState);
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }

    public void setCoffeeMaker(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public DishWasher getDishWasher() {
        return dishWasher;
    }

    public void setDishWasher(DishWasher dishWasher) {
        this.dishWasher = dishWasher;
    }

    public Refrigerator getRefrigerator() {
        return refrigerator;
    }

    public void setRefrigerator(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }
}
