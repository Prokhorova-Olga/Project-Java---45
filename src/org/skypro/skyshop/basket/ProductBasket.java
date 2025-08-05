package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = new ArrayList<>();
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product currentProduct = iterator.next();
            if (currentProduct.getName().equals(name)) {
                removedProducts.add(currentProduct);
                iterator.remove();
            }
        }
        return removedProducts;
    }

    public int totalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }


    public void printContent() {
        if (products.isEmpty()) {
            System.out.println("Корзина пустая");
        } else {
            for (Product product : products) {
                System.out.println(product.getStringRepresentation());

            }
        }

        int specialItemsCount = 0;
        for (Product product : products) {
            Product item = product;
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
        for (Product product : products) {
            if (product.isSpecial()) {
                count++;
            }
        }
        return count;
    }


    public boolean containsByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        products.clear();
    }

}
