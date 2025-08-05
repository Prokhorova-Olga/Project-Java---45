package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.Arrays;

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


        SearchEngine engine = new SearchEngine(6);

        engine.add((apple));
        engine.add((articleApple));
        engine.add(discountedOrange);

        try {
            Searchable best = engine.bestMatch("яблоко");
            System.out.println("Лучший результат: " + best.getStringRepresentation());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }
}
