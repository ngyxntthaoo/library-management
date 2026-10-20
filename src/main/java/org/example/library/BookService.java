package org.example.library;


import org.example.library.dto.BookRequest;
import org.example.library.dto.BookResponse;
import org.example.library.entity.Book;
import org.example.library.entity.Category;
import org.example.library.exception.ResourceNotFoundException;
import org.example.library.repository.BookRepository;
import org.example.library.repository.CategoryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;

    public BookService(
            BookRepository bookRepository,
            CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
    }

   @Transactional(readOnly = true)
    public List<BookResponse> getAllBooks(){
       return bookRepository.findAll()
               .stream()
               .map(this::toResponse)
               .toList();
   }

   @Transactional(readOnly = true)
    public BookResponse getBookById(Long id){
        Book book = findBookById(id);
        return toResponse(book);
   }

   @Transactional
    public BookResponse createBook(BookRequest request){
        if (bookRepository.existsByIsbn(request.getIsbn())){
            throw new IllegalArgumentException("ISBN already exists");
        }
       Category category = findCategoryById(request.getCategoryId());

        Book book = new Book();
        applyRequest(book, request, category);

        Book saveBook = bookRepository.save(book);

        return toResponse(saveBook);
   }

    @Transactional
    public BookResponse updateBook(Long id, BookRequest request) {
        Book book = findBookById(id);

        boolean isbnChanged =
                !book.getIsbn().equals(request.getIsbn());

        if (isbnChanged
                && bookRepository.existsByIsbn(request.getIsbn())) {
            throw new IllegalArgumentException("ISBN already exists");
        }

        Category category = findCategoryById(request.getCategoryId());

        applyRequest(book, request, category);

        Book updatedBook = bookRepository.save(book);

        return toResponse(updatedBook);
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = findBookById(id);
        bookRepository.delete(book);
    }

    private Book findBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Book not found with id: " + id));
    }

    private Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Category not found with id: " + categoryId));
    }

    private void applyRequest(
            Book book,
            BookRequest request,
            Category category) {
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setIsbn(request.getIsbn());
        book.setQuantity(request.getQuantity());
        book.setCategory(category);
    }

    private BookResponse toResponse(Book book) {
        return new BookResponse(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getQuantity(),
                book.getCategory().getId(),
                book.getCategory().getName()
        );
    }


}
