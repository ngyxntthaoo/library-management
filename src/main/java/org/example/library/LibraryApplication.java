
package org.example.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Đánh dấu class này là điểm khởi động của ứng dụng Spring Boot.
@SpringBootApplication
public class LibraryApplication {

    public static void main(String[] args) {
        // Khởi động ứng dụng và các thành phần Spring.
        SpringApplication.run(LibraryApplication.class, args);
    }
}
