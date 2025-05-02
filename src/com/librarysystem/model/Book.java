package com.librarysystem.model;

public class Book {
    private int id;
    private String title;
    private String author;
    private String category;
    private boolean available = true;

    public Book(int id, String title, String author, String category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getCategory() {
        return category;
    }

    public String getAuthor() {
        return author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " - " + author + " (" + category + ") " +
                (available ? " Müsait" : " Alınmış");
    }
}
