package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 40);
        SimpleProduct banana = new SimpleProduct("Банан", 50);

        DiscountedProduct discountedOrange = new DiscountedProduct("Апельсин", 100, 20);
        FixPriceProduct fixedTomato = new FixPriceProduct("Помидор");

        Article articleApple = new Article("Лучшие сорта яблок ", "Яблоки бывают ...");
        Article articleBanana = new Article("Польза бананов  ", "Бананы полезны для здоровья ...");
        Article articleWatermelon = new Article("Как выбрать арбуз ", "Чтобы выбрать хороший арбуз ...");

        SearchEngine engine = new SearchEngine(6);
        engine.add((apple));
        engine.add((articleWatermelon));
        engine.add((articleApple));
        engine.add((articleBanana));
        engine.add((fixedTomato));
        engine.add(discountedOrange);

        System.out.println("Пoиск по слову 'Яблоки': ");
        Searchable[] elements = engine.search("Яблоки ");
        for (Searchable element : elements) {
            if (element != null) {
                System.out.println(element.getStringRepresentation());
            }
        }
        System.out.println("Поиск по слову 'Бананы': ");
        Searchable[] results = engine.search("Бананы");
        String resultString = Arrays.toString(results);
        System.out.println(resultString);


    }
}
