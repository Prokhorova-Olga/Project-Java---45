package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

import java.util.*;
import java.util.stream.Collectors;

public class SearchEngine {
    private Set<Searchable> elements = new HashSet<>();

    public SearchEngine(Set<Searchable> elements) {
        this.elements = elements;
    }


    public void addSearchable(Searchable element) {
        if (element != null) {
            elements.add(element);
        }
    }

    public Set<Searchable> search(String query) {
        return elements.stream()
                .filter(Objects::nonNull)
                .filter(element -> element.getSearchTerm().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new SearchableComparator())));
    }

    public Searchable findTheMostAppropriateElementMatch(String substring) throws BestResultNotFound {

        int maxCount = 0;
        Searchable bestResult = null;

        for (Searchable element : elements) {
            if (element == null) {
                continue;
            }
            int count = 0;
            int index = 0;
            int foundIndex = element.getSearchTerm().indexOf(substring, index);
            while (foundIndex != -1) {
                count++;
                index = foundIndex + substring.length();
                foundIndex = element.getSearchTerm().indexOf(substring, index);
            }
            if (count > maxCount) {
                maxCount = count;
                bestResult = element;
            }
        }
        if (maxCount == 0) {
            throw new BestResultNotFound("Совпадений по запросу не найдено");
        }
        return bestResult;
    }

}
