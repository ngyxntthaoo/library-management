package org.example.library.repository;

import org.example.library.entity.BorrowRecord;
import org.example.library.entity.BorrowStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BorrowRecordRepository
        extends JpaRepository<BorrowRecord, Long> {

    // Tìm toàn bộ lịch sử mượn của một độc giả.
    // Reader_Id nghĩa là truy cập thuộc tính id của Reader.
    List<BorrowRecord> findByReader_Id(Long readerId);

    // Tìm lịch sử mượn của một cuốn sách.
    List<BorrowRecord> findByBook_Id(Long bookId);

    // Tìm các bản ghi theo trạng thái BORROWED hoặc RETURNED.
    List<BorrowRecord> findByStatus(BorrowStatus status);
}
