package com.library.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleBooksApiResponse {

    private String kind;
    private int totalItems;
    private GoogleBook[] items;

    // Getters y Setters

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public GoogleBook[] getItems() {
        return items;
    }

    public void setItems(GoogleBook[] items) {
        this.items = items;
    }
}