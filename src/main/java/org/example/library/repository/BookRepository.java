package org.example.library.repository;

import org.example.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

// JpaRepository<Book, Long>:
// Book là entity cần thao tác, Long là kiểu dữ liệu của ID.
public interface BookRepository extends JpaRepository<Book, Long> {

    // Tìm sách có tiêu đề hoặc tác giả chứa từ khóa.
    // IgnoreCase giúp tìm kiếm không phân biệt chữ hoa/chữ thường.
    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(
            String title,
            String author
    );

    // Kiểm tra ISBN đã tồn tại chưa.
    boolean existsByIsbn(String isbn);
}
