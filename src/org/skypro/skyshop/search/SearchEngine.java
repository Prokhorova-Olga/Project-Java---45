package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private List<Searchable> elements = new ArrayList<>();


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

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new LinkedHashMap<>();
        for (Searchable element : elements) {
            if (element.getSearchTerm().contains(query)) {
                results.put(element.getName(), element);

            }
        }
        return results;

    }
}
