package org.example.library;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

// Đăng ký class này là REST Controller.
@RestController
public class DatabaseHealthController {

    private final DataSource dataSource;

    // Spring tự truyền DataSource vào constructor.
    // DataSource được cấu hình từ application.yml.
    public DatabaseHealthController(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Khi truy cập GET /api/health/database,
    // phương thức này sẽ kiểm tra kết nối database.
    @GetMapping("/api/health/database")
    public String checkDatabase() throws SQLException {

        // try-with-resources tự đóng connection sau khi sử dụng.
        try (Connection connection = dataSource.getConnection()) {

            if (connection.isValid(2)) {
                return "Database connection successful!";
            }

            return "Database connection failed!";
        }
    }
}