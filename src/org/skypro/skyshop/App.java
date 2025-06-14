package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 40);
        Product banana = new Product("Банан", 50);
        Product orange = new Product("Апельсин", 40);
        Product peach = new Product("Персик", 60);

        ProductBasket basket = new ProductBasket();

        basket.add(apple);
        basket.add(banana);
        basket.add(orange);
        basket.add(peach);

        basket.printContent();
        System.out.println("Сумма покупок: " + basket.totalCost());

        basket.add(new Product("Слива", 40));
        basket.add(new Product("Ананас", 100));

        System.out.println("Есть ли яблоко в корзине? " + basket.containsByName("Яблоко"));
        System.out.println("Есть ли клубника в корзине? " + basket.containsByName("Клубника"));


        basket.clear();

        basket.printContent();

        System.out.println("Сумма пустой корзины: " + basket.totalCost());
        System.out.println("Есть ли виноград в пустой корзине? " + basket.containsByName("Виноград"));

    }
}
