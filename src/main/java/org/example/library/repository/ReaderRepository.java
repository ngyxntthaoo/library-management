package org.example.library.repository;

import org.example.library.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository
        extends JpaRepository<Reader, Long> {

    // Email phải duy nhất, nên cần kiểm tra trước khi tạo Reader.
    boolean existsByEmail(String email);
}
