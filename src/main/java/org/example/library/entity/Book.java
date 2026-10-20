package org.example.library.entity;

import jakarta.persistence.*;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 150)
    private String author;

    // Moi cuon sach co IBSN duy nhat
    @Column(nullable = false, unique = true, length = 20)
    private String isbn;

    // So luong sach hien co tron kho
    @Column(nullable = false)
    private int quantity;

    // Nhieu Book thuoc ve mot Category
    // category_id se la khoa ngoai trong bang books
    // FetchType.LAZY trì hoãn việc tải Category cho đến khi cần truy cập. Đây là lựa chọn phổ biến, giúp tránh tải dữ liệu liên quan không cần thiết.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id", nullable = false)
    private Category category;

    public Book(){
    }

    public Book(
            String title,
            String author,
            String isbn,
            int quality,
            Category category
    ){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.quantity = quality;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
