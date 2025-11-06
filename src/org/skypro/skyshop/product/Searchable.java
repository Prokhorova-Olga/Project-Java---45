package org.skypro.skyshop.product;

public interface Searchable {
    String getSearchTerm();

    String getContentType();

    String getSearchableName();

    default void getStringRepresentation() {
        System.out.println("Имя " + getSearchableName() + " - тип " + getContentType());
    }

}
