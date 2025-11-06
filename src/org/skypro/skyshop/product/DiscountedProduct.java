package org.skypro.skyshop.product;

import java.util.Objects;

public class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discountPercentage;


    public DiscountedProduct(String name, int basePrice, int discountPercent) {
        super(name);
        if (basePrice < 1) {
            throw new IllegalArgumentException("Базовая цена должна быть больше нуля");
        } else if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Процент скидки не может быть меньше 0 или больше 100");
        }
        this.basePrice = basePrice;
        this.discountPercentage = discountPercent;

    }

    @Override
    public int getPrice() {
        return basePrice - ((basePrice * discountPercentage) / 100);
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public String toString() {
        return "имя продукта со скидкой: " + getName() + " стоимость: " + getPrice() + " скидка " + discountPercentage + "%)";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DiscountedProduct that = (DiscountedProduct) o;
        return basePrice == that.basePrice && discountPercentage == that.discountPercentage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(basePrice, discountPercentage);
    }


}
