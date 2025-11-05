package com.example.domain;

public class BookProduct extends Product {
    private String author;

    public BookProduct(String name, double price, String author) {
        super(name, price, "Книги");
        this.author = author;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Автор: " + author);
    }
}
