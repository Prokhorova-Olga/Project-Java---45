package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] products = new Product[5];
    private int size = 0;

    public void add(Product product) {
        if (size < products.length) {
            products[size++] = product;
        } else {
            System.out.println("Невозможно добавить товар");
        }
    }

    public int totalCost() {
        int total = 0;
        for (int i = 0; i < size; i++) {
            total += products[i].getPrice();
        }
        return total;
    }


    public void printContent() {
        if (size <= 0) {
            System.out.println("Корзина пустая");
            return;
        }

        int specialItemsCount = 0;
        for (int i = 0; i < size; i++) {
            Product item = products[i];
            System.out.println(item.toString());
            if (item.isSpecial()) {
                specialItemsCount++;
            }
        }
        System.out.println("Итого: " + totalCost());
        System.out.println("Специальных товаров: " + specialItemsCount);
    }


    public int countSpecialProducts() {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (products[i].isSpecial()) {
                count++;
            }
        }
        return count;
    }


    public boolean containsByName(String name) {
        for (int i = 0; i < size; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            products[i] = null;
        }
        size = 0;
    }

}
