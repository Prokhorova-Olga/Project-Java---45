package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    protected final String name;


    public Product(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getType() {
        return "PRODUCT";
    }
}
