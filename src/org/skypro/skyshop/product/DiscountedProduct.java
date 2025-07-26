package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercent;

    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        this.basePrice = basePrice;
        if (basePrice < 0) {
            throw new IllegalArgumentException("Базовая цена должна быть строго больше нуля");
        }

        this.discountPercent = discountPercent;
        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки не может быть меньше 0 или больше 100");
        }
    }

    @Override
    public int getPrice() {
        return (basePrice * (100 - discountPercent)) / 100;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return getName() + " : " + getPrice() + " (" + discountPercent + "%)";
    }
}
