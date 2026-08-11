package org.example;

public class Burger {

    private BurgerMeatType meatType;
    private BurgerSize size;
    public Burger(BurgerMeatType meatType, BurgerSize size) {
        this.meatType = meatType;
        this.size = size;
    }

    public BurgerMeatType getMeatType() {
        return meatType;
    }

    public void setMeatType(BurgerMeatType meatType) {
        this.meatType = meatType;
    }

    public BurgerSize getSize() {
        return size;
    }

    public void setSize(BurgerSize size) {
        this.size = size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb = sb.append("Burger Meat Type: ").append(this.getMeatType().name())
            .append(", Burger Size: ").append(this.getSize().name());

        return sb.toString();
    }
}
