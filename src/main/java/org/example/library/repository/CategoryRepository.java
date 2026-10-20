package org.example.library.repository;

import org.example.library.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository
        extends JpaRepository<Category, Long> {

    // Kiểm tra tên thể loại đã tồn tại chưa.
    boolean existsByNameIgnoreCase(String name);
}
