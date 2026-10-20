package org.example.library.dto;

public class BookResponse {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private int quantity;
    private Long categoryId;
    private String categoryName;

    public BookResponse(
            Long id,
            String title,
            String author,
            String isbn,
            int quantity,
            Long categoryId,
            String categoryName) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }
}
