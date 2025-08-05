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

    public Searchable bestMatch(String query) throws BestResultNotFound {
        int maxMathes = -1;
        Searchable bestElement = null;
        for (int i = 0; i < size; i++) {
            int mathes = countOccurrences(elements[i].getSearchTerm(), query);
            if (mathes > maxMathes) {
                maxMathes = mathes;
                bestElement = elements[i];
        }
    }
        if (bestElement == null) {
            throw new BestResultNotFound("Лучший результат не найден для запроса '" + query + "'");
        }
        return  bestElement;
        }

    private int countOccurrences(String source, String target) {
        int occurrences = 0;
        int index = 0;
        while ((index = source.indexOf(target, index)) != -1) {
            occurrences++;
            index += target.length();
        }
        return occurrences;
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
