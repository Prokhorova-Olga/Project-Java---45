package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 40);
        SimpleProduct banana = new SimpleProduct("Банан", 50);

        DiscountedProduct discountedOrange = new DiscountedProduct("Апельсин", 100, 20);
        FixPriceProduct fixedTomato = new FixPriceProduct("Помидор");

        ProductBasket basket = new ProductBasket();

        basket.add(apple);
        basket.add(discountedOrange);
        basket.add(fixedTomato);


        basket.printContent();
        System.out.println("Количество специальных товаров: " + basket.countSpecialProducts());
        System.out.println("Итоговая сумма: " + basket.totalCost());

    }
}
