package org.example.library.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="categories")
public class Category {
    // @Id đánh dầu khoá chính của bảng
    // @GeneratedValue cho phép database tự sinh ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // KO cho phep ten the loai bi null
    @Column(nullable = false, unique = true, length = 100)
    private String name;

    // @Column: cấu hình các ràng buộc của cột.
    @Column(length = 500)
    private String description;

    // mot Category co the chua nhieu Book
    // mappedBy = "category" nghi la khoa ngoai
    // mappedBy = "category" tham chiếu đến tên thuộc tính Java trong class Book
    // duoc quan ly o thuoc tinh category cua Book
    // @OneToMany: khai báo quan hệ một-nhiều.
    //
    @OneToMany(mappedBy = "category")
    private List<Book> books = new ArrayList<>();

    // JPA can constructor ko tham so de tao Object
    public Category(){

    }
    public Category(String name, String description){
        this.name=name;
        this.description=description;
    }
    public Long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description=description;
    }

    public List<Book> getBooks() {
        return books;
    }

    // Giu hai phia cua quan he dong bo trong bo nho
    public void addBook(Book book){
        books.add(book);
        book.setCategory(this);
    }
}
