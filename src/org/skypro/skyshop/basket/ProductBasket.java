package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void addProduct(Product product) {
        String productName = product.getName();
        products.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
    }

    public List<Product> deleteProductsByName(String name) {
        List<Product> deletedProducts = new ArrayList<>();
        if (products.containsKey(name)) {
            List<Product> productList = products.get(name);
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName() != null && product.getName().equalsIgnoreCase(name)) {
                    deletedProducts.add(product);
                    iterator.remove();
                }
            }
            if (deletedProducts.isEmpty()) {
                products.remove(name);
                System.out.println("Список пуст");
            }
        }
        if (deletedProducts.isEmpty()) {
            System.out.println("Продукты с именем " + name + " не найдены");
        }
        return deletedProducts;
    }


    public int calculateTheTotalCostOfTheBasket() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }


    public void printTheContentsOfTheBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
            return;
        }
        products.entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .filter(entry -> !entry.getValue().isEmpty())
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue().stream()
                            .filter(Objects::nonNull)
                            .forEach(product -> {
                                System.out.println(product.getSearchTerm() + " - Цена " + product.getPrice());
                            });
                    System.out.println();
                });

        System.out.println("Итого: общая стоимость корзины " + calculateTheTotalCostOfTheBasket());
        System.out.println("Количество специальных товаров " + countSpecialProducts());

    }


    private int countSpecialProducts() {
        return (int) products.values().stream()
                .flatMap(Collection::stream)
                .filter(Objects::nonNull)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean checkTheProductName(String name) {
        return products.containsKey(name);
    }

    public void clearTheBasket() {
        products.clear();
    }
}
