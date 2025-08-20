package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;


public class ProductBasket {
    private Map<String, List<Product>> products = new HashMap<>();

    public void add(Product product) {
        String name = product.getName();
        products.computeIfAbsent(name, k -> new ArrayList<>()).add(product);
    }

    public List<Product> removeByName(String name) {
        List<Product> removeProducts = products.remove(name);
        if (removeProducts == null) {
            return new ArrayList<>();
        }
        return removeProducts;
    }

    public int totalCost() {
        return products.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }


    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
        } else {
            products.values().stream()
                    .flatMap(List::stream)
                    .forEach(System.out::println);

            long specialItemsCount = countSpecialProducts();
            System.out.println("Итого: " + totalCost());
            System.out.println("Специальных товаров: " + specialItemsCount);

        }
    }

    private long countSpecialProducts() {
        return products.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }


    public boolean containsByName(String name) {
        return products.containsKey(name);
    }

    public void clear() {
        products.clear();
    }
}
