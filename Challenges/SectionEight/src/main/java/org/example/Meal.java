package org.example;

public class Meal {

    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public Meal(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem, String topping) {
        this(burger, drink, sideItem);
        this.burger.addTopping(topping);
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem,
                String firstTopping, String secondTopping) {
        this(burger, drink, sideItem, firstTopping);
        this.burger.addTopping(secondTopping);
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem,
                String firstTopping, String secondTopping, String thirdTopping) {
        this(burger, drink, sideItem, firstTopping, secondTopping);
        this.burger.addTopping(thirdTopping);
    }

    public void updateDrinkSize(String size) {
        this.getDrink().setSize(size);
    }

    private double getMealPrice() {
        double toppingsPrice = 0;
        for (int i = 0; i < this.getBurger().getToppings().length; i++) {
            Topping topping = this.getBurger().getToppings()[i];
            if (topping != null) {
                toppingsPrice += topping.getPrice();
            }
        }
        return this.getBurger().getPrice() + this.getDrink().getPrice()
                + this.getSideItem().getPrice() + toppingsPrice;
    }

    private String getToppingsString() {
        String toppingsString = "";
        String toppingsStringHeader = "Toppings:\n";
        for (int i = 0; i < this.getBurger().getToppings().length; i++) {
            Topping topping = this.getBurger().getToppings()[i];
            if (topping != null) {
                toppingsString.concat("type: ").concat(topping.getType()).concat(" ").
                    concat("price: ").concat(String.valueOf(topping.getPrice())).concat("\n");
            }
        }
        return toppingsStringHeader + toppingsString;
    }

    public String getReceipt() {
        String toppingsString = this.getToppingsString();
        String receipt = String.format(
                "Burger: type: %s, price: %4.2f", this.getBurger().getType(),
                this.getBurger().getPrice()
        ) + "\n" + String.format(
                "Drink: type: %s, price: %4.2f", this.getDrink().getType(),
                this.getDrink().getPrice()
        ) + "\n" + String.format(
                "Side: type: %s, price: %4.2f", this.getSideItem().getType(),
                this.getSideItem().getPrice()
        ) + "\n";
        receipt += toppingsString;
        return receipt;
    }

    public Burger getBurger() {
        return burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public SideItem getSideItem() {
        return sideItem;
    }
}
