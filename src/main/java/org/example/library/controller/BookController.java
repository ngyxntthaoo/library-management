package org.example.library.controller;

import jakarta.validation.Valid;
import org.example.library.BookService;
import org.example.library.dto.BookRequest;
import org.example.library.dto.BookResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // READ: Get all books
    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    // READ: Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<BookResponse> getBookById(
            @PathVariable Long id ) {
        return ResponseEntity.ok(bookService.getBookById(id));
    }

    // CREATE: Create a new book
    @PostMapping
    public ResponseEntity<BookResponse> createBook(
            @Valid @RequestBody BookRequest request) {
        BookResponse response = bookService.createBook(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    // UPDATE: Update an existing book
    @PutMapping("/{id}")
    public ResponseEntity<BookResponse> updateBook(
            @PathVariable Long id,
            @Valid @RequestBody BookRequest request
    ){
        return ResponseEntity.ok(bookService.updateBook(id, request));
    }

    // DELETE: Delete a book
    public ResponseEntity<Void> deleteBook(
            @PathVariable Long id
    ){
        return ResponseEntity.noContent().build();
    }

}
