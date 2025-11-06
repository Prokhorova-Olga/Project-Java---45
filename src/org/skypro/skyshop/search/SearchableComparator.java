package org.skypro.skyshop.search;

import org.skypro.skyshop.product.Searchable;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {

    @Override
    public int compare(Searchable s1, Searchable s2) {
        int lengthCompare = Integer.compare(s2.getSearchableName().length(), s1.getSearchableName().length());
        if (lengthCompare != 0) {
            return lengthCompare;
        }
        return s1.getSearchableName().compareTo(s2.getSearchableName());
    }

}
