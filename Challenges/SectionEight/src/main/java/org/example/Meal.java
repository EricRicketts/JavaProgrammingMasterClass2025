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

    /*
        At the top level a Meal Class "Has A" Item and "Has A" Burger, and the Burger "IS A" Item
        instructor solution: attributes: side: Item, drink: Item, burger: Burger
        methods: addToppings(), setDrinkSize(), printItemizedList(), printTotal()

        Item (used for both Drink and Side Items): attributes: name: String, Type: String, price: double, size: String
        methods: getBasePrice():double, getAdjustedPrice():double, printItem(), getName():string, setSize():void

        Burger: attributes: extra1: Item, extra2: Item, extra3: Item
        methods: addToppings()

        In the Item constructor the instructor suggested adding validity checks for the type.

        In the Item getName() method for Item if the type "SIDE" or "DRINK" then return size + " " + name
        the default return for the getName() method is name

        The getAdjustedPrice() method adjusts the price based on the size of the item, he adjusted small as
        getBasePrice() - 0.50 and adjusted large as getBasePrice() - 1.00, the default was just getBasePrice()

        In Item the setSize() method allows you to change the size of the Item

        He defined a public static void printItem(String name, double price) method to standardize how all
        items are printed "%20s:%6.2f%n", name, price => reserving 20 characters for the name and 6 characters
        with 2 decimal places for the price.

        Another method public void printItem() called the static method printItem(getName(), getAdjustedPrice())

        Burger extends Item and adds three additional fields extra1, extra2, and extra3 all type Item.

        In the Burger constructor public Burger(String name, double price) { super("Burger", name, price) }

        In the Burger class, the getName() method was overridden => return super.getName() + " BURGER"
        getAdjustedPrice() => getBasePrice() + ((extra1 == null) ? 0 : extra1.getAdjustedPrice()) +
        (extra2 == null) ? 0 : extra2.getAdjustedPrice() + (extra3 == null) ? 0 : extra3.getAdjustedPrice());

        Also added to Burger public double getExtraPrice(String toppingName) used a switch statement, passing
        in toppingName.toUpperCase() and has options AVOCADO, CHEESE -> 1.0, BACON, HAM, SALAMI -> 1.5
        default -> 0

        public void addToppings(String extra1, String extra2, String extra3) this.extra1 =
        new Item("TOPPING", extra1, getExtraPrice(extra1)), this exact pattern is repeated for extra2 and extra3.

        In the Burger class printItemizedList() => printItem("BASE BURGER", getBasePrice()) if (extra1 != null)
        extra1.printItem(), this pattern is repeated for extra2 and extra3.

        public void printItem() => printItemizedList(), super.printItem()

        For the MealOrder => MealOrder(String burgerType, String drinkType, String sideType)
        this.burger = new Burger(burgerType, 4.0), this.drink = new Item("drink", drinkType, 1.00).
        this.side = new Item("side", sideType, 1.50) the author used strings as arguments to hide any details
        about the Item class from the constructor call.  The string were used to create Burger, Drink, and Side
        in the constructor call.

        public double getTotalPrice() => side.getAdjustedPrice() + drink.getAdjustedPrice() +
        burger.getAdjustedPrice().  There is a need to check for an instance of DeluxeBurger.  If (burger instanceof DeluxeBurger)
        return burger.getAdjustedPrice()

        printItemizedList() => burger.printItem(); drink.printItem(); side.printItem()
        Item.printItem("TOTAL PRICE", getTotalPrice()).  if(burger instanceof DeluxeBurger) Item.printItem(drink.getName(), 0)
        Item.printItem(side.getName(), 0) else drink.printItem() and side.printItem()

        public void addBurgerToppings(String extra1, String extra2, String extra3) =>
        burger.addToppings(extra1, extra2, extra3)
        Add this overloaded method public void addBurgerToppings(String extra1 ... String extra5) => if (burger instanceof
        DeluxeBurger db) => db.addToppings(extra1 ... extra5) else burger.addToppings(extra1, extra2, extra3)

        public void setDrinkSize(String size) => drink.setSize(size)

        When you print out the total bill, at the top include the base burger adjustments, base burger price,
        and a price for each topping.  As an example topping prices for bacon, cheese, and mayonnaise.  Then in
        the lower part of the receipt print out the Burger type and the accumulated price for the burger, which
        should be seen above from the burger information from the order.

        For the deluxe burger challenge fields are deluxe1: Item, deluxe2: Item, and method is addToppings().

        public class DeluxeBurger extends Burger {}.  Constructor public DeluxeBurger(String name, double price)
        { super(name, price); }

        The addToppings method is redefined.  public void addToppings(String extra1 ... String extra5)
        super.addToppings(extra1, extra2, extra3).  deluxe1 = new Item("TOPPING", extra4, 0),
        deluxe2 = new Item("TOPPING", extra5, 0)

        public void printItemizedList() => super.printItemizedList() if fields deluxe1 and deluxe2 are not null,
        then call printItem() on both fields.  Override public double getExtraPrice(String toppingName) return 0;

        Within the MealOrder constructor run a conditional => if(burgerType.equalsIgnoreCase("deluxe")) {
        this.burger = new Deluxe Burger(burgerType, 8.50) else this.burger = new Burger(burgerType, 4.0)
    */
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
        receipt += "Total Price: " + Scale.setScale(this.getMealPrice(), 2);
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
