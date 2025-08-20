package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lenComparison = Integer.compare(s2.getName().length(), s1.getName().length());
        if (lenComparison != 0) {
            return lenComparison;
        }
        return s1.getName().compareTo(s2.getName());
    }

}
