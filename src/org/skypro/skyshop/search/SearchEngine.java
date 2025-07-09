package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

public class SearchEngine {
    private Searchable[] elements;
    private int size = 0;

    public SearchEngine(int capacity) {
        elements = new Searchable[capacity];
    }

    public void add(Searchable element) {
        if (size < elements.length) {
            elements[size++] = element;
        } else {
            System.out.println("Нельзя добавить новый элемент");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int found = 0;

        for (int i = 0; i < size && found < elements.length; i++) {
            if (elements[i].getSearchTerm().contains(query)) {
                results[found++] = elements[i];

            }
        }
        return results;

    }
}
