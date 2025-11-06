package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.*;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.BestResultNotFound;

import java.util.HashSet;


public class App {
    public static void main(String[] args) {

        ProductBasket productBasket = new ProductBasket();

        Product apple = new SimpleProduct("яблоко", 100);
        Product orange = new DiscountedProduct("апельсин", 150, 10);
        Product lemon = new FixPriceProduct("лимон");
        Product strasberry = new SimpleProduct("клубника", 600);

        productBasket.printTheContentsOfTheBasket();

        productBasket.addProduct(apple);
        productBasket.addProduct(orange);
        productBasket.addProduct(lemon);
        productBasket.addProduct(strasberry);

        productBasket.calculateTheTotalCostOfTheBasket();

        Product watermelon = new SimpleProduct("арбуз", 50);

        System.out.println("Итого: общая стоимость корзины " + productBasket.calculateTheTotalCostOfTheBasket());
        System.out.println("Поиск товара " + apple.getName() + " в корзине " + productBasket.checkTheProductName("яблоко"));
        System.out.println("Поиск товара " + watermelon.getName() + " в корзине " + productBasket.checkTheProductName("арбуз"));
        System.out.println("Удаленные товары " + productBasket.deleteProductsByName("лимон"));
        System.out.println("Удаленные товары " + productBasket.deleteProductsByName("макароны"));

        productBasket.printTheContentsOfTheBasket();
        productBasket.calculateTheTotalCostOfTheBasket();
        productBasket.clearTheBasket();
        productBasket.printTheContentsOfTheBasket();

        System.out.println("Итого: общая стоимость корзины " + productBasket.calculateTheTotalCostOfTheBasket());
        System.out.println("Поиск товара " + apple.getName() + " в корзине " + productBasket.checkTheProductName("яблоко"));

        SearchEngine searchEngine = new SearchEngine(new HashSet<>());

        Article cherry = new Article("Польза вишни", "Bишня - очень полезна");
        Article mango = new Article("Вкус манго", "Mанго или вишня?");

        searchEngine.addSearchable(cherry);
        searchEngine.addSearchable(mango);
        searchEngine.addSearchable(watermelon);

        System.out.println("Поиск товара " + searchEngine.search("вишня"));
        System.out.println("Поиск товара " + searchEngine.search("манго"));


        try {
            Product wrongProduct = new SimpleProduct(" ", 40);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product wrongPrice = new SimpleProduct("Ежевика", 0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Product wrongDiscountedProduct = new DiscountedProduct("Киви", 100, 110);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Поиск по запросу яблоко" +
                    searchEngine.findTheMostAppropriateElementMatch("яблоко"));
        } catch (BestResultNotFound e) {
            System.out.println("Совпадений по запросу не найдено");
        }

        try {
            System.out.println("Поиск по запросу вишня " +
                    searchEngine.findTheMostAppropriateElementMatch("вишня"));
        } catch (BestResultNotFound e) {
            System.out.println();
        }

    }
}
