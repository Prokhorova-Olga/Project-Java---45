package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Searchable;
import org.skypro.skyshop.search.SearchableComparator;

import java.util.Objects;

public class Article extends SearchableComparator implements Searchable {
    private final String title;
    private final String text;


    public Article(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "Название статьи: " + title + "\n " +
                "Текст статьи: " + text;
    }

    @Override
    public String getSearchTerm() {
        return toString() + " ARTICLE";
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getSearchableName() {
        return title;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Article article)) return false;
        return Objects.equals(title, article.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

}
