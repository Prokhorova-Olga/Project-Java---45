package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> elements = new HashSet<>();


    public void add(Searchable element) {
        elements.add(element);
    }

    public Searchable bestMatch(String query) throws BestResultNotFound {
        int maxMathes = -1;
        Searchable bestElement = null;
        for (Searchable element : elements) {
            int matches = countOccurrences(element.getSearchTerm(), query);
            if (matches > maxMathes) {
                maxMathes = matches;
                bestElement = element;
            }
        }
        if (bestElement == null) {
            throw new BestResultNotFound("Лучший результат не найден для запроса '" + query + "'");
        }
        return bestElement;
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

    public Set<Searchable> search(String query) {
        Comparator<Searchable> comparator = new Comparator<>() {

            @Override
            public int compare(Searchable s1, Searchable s2) {
                int lenCompare = Integer.compare(s2.getName().length(), s1.getName().length());
                if (lenCompare != 0) {
                    return lenCompare;
                }
                return s1.getName().compareTo(s2.getName());
            }
        };

        Set<Searchable> results = new TreeSet<>(comparator);
        for (Searchable element : elements) {
            if (element.getSearchTerm().contains(query)) {
                results.add(element);

            }
        }
        return results;

    }
}
