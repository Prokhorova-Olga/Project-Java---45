package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {


        try {
            SimpleProduct wrongProduct = new SimpleProduct(" ", 40);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            SimpleProduct wrongPrice = new SimpleProduct("Ежевика", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            DiscountedProduct wrongDiscountedProduct = new DiscountedProduct("Киви", 100, 100);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


        SimpleProduct apple = new SimpleProduct("Яблоко", 40);
        DiscountedProduct discountedOrange = new DiscountedProduct("Апельсин", 100, 20);
        FixPriceProduct fixedTomato = new FixPriceProduct("Помидор");

        Article articleApple = new Article("Лучшие сорта яблок ", "Яблоки бывают ...");
        Article articleBanana = new Article("Польза бананов  ", "Бананы полезны для здоровья ...");


        SearchEngine engine = new SearchEngine();

        engine.add((apple));
        engine.add((articleApple));
        engine.add(discountedOrange);
        engine.add(fixedTomato);
        engine.add(articleBanana);

        System.out.println("Поиск по запросу 'Яблоко': ");
        Set<Searchable> results = engine.search("Яблоко");
        for (Searchable result : results) {
            System.out.println(result.getStringRepresentation());
        }


        try {
            Searchable best = engine.bestMatch("яблоко");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        SimpleProduct tomato = new SimpleProduct("Помидор", 50);
        SimpleProduct banana = new SimpleProduct("Банан", 30);
        DiscountedProduct discountedPotatoes = new DiscountedProduct("Картошка", 60, 20);

        ProductBasket basket = new ProductBasket();
        basket.add(tomato);
        basket.add(banana);
        basket.add(discountedPotatoes);

        System.out.println("Удаляем товар 'Помидор'");
        List<Product> removedProducts = basket.removeByName("Помидор");
        System.out.println("Удаленные товары: ");
        for (Product product : removedProducts) {
            System.out.println(product.getStringRepresentation());
        }
        System.out.println("\nУдаляем несуществующий товар 'Ананас'");
        removedProducts = basket.removeByName("Ананас");
        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        System.out.println("\nТекущие товары в корзине:");
        basket.printContent();

    }
}
