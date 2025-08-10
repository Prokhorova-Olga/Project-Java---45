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
        List<Product> removedProducts = new ArrayList<>();
        List<Product> matchingProducts = products.getOrDefault(name, Collections.emptyList());
        removedProducts.addAll(matchingProducts);
        products.remove(name);
        return removedProducts;
    }

    public int totalCost() {
        int total = 0;
        for (List<Product> productGroup : products.values()) {
            for (Product product : productGroup) {
                total += product.getPrice();
            }
        }
        return total;
    }


    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
        } else {
            TreeSet<String> sortedNames = new TreeSet<>(products.keySet());
            for (String name : sortedNames) {
                List<Product> sameNameProducts = products.get(name);
                for (Product product : sameNameProducts) {
                    System.out.println(product.getStringRepresentation());
                }
            }

            int specialItemsCount = 0;
            for (List<Product> productGroup : products.values()) {
                for (Product product : productGroup) {
                    if (product.isSpecial()) {
                        specialItemsCount++;
                    }
                }
            }
            System.out.println("Итого: " + totalCost());
            System.out.println("Специальных товаров: " + specialItemsCount);
        }
    }


    public int countSpecialProducts() {
        int count = 0;
        for (List<Product> productGroup : products.values()) {
            for (Product product : productGroup) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }


    public boolean containsByName(String name) {
        return products.containsKey(name);
    }

    public void clear() {
        products.clear();
    }
}
