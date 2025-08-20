package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

import java.util.*;
import java.util.stream.Collectors;

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
        return elements.stream()
                .filter(element -> element.getSearchTerm().contains(query))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));

    }
}
