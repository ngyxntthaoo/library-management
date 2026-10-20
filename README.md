
## 2. Kết nối PostgresSQL
### Kiểm tra PostgreSQL
Chạy docker 
```
docker compose up -d
```
Kiểm tra container:
```
docker compose ps
docker compose exec postgres pg_isready -U library_user -d library_db
```
### Kiểm tra Gradle dependencies
Trong `build.gradle`, điền các lib cần thiết.Chạy
```
./gradlew build
./gradlew --stop
./gradlew clean build --refresh-dependencies
```
## 3. Viết Entity và Repository
Sẽ tạo 4 Entity và 4 Repository: Book, Category, Reader, BorrowRecord
Entity là một class Java được ánh xạ với một bảng trong database. Ví dụ, class Book tương ứng với bảng books.
Repository là thành phần truy cập dữ liệu. Khi một interface kế thừa JpaRepository, Spring Data JPA tự cung cấp những method cơ bản như:
- save(entity): thêm mới hoặc cập nhật.
- findById(id): tìm theo ID.
- findAll(): lấy danh sách.
- deleteById(id): xóa theo ID.
- existsById(id): kiểm tra ID có tồn tại.

Tạo package repository bên cạnh package entity: Các repository dưới đây đều kế thừa JpaRepository

### Checklist
- [x] Khởi tạo project Gradle
- [ ] Kết nối PostgresSQL: Cấu hình application.yml và kiểm tra kết nối database.
- [ ] Viết Entity và Repository: Tạo 4 entity, enum trạng thái và các quan hệ JPA.
- [ ] Hoàn thiện CRUD cho Book: Viết Controller, Service, DTO và xử lý lỗi.
- [ ] Mở rộng CRUD: Thêm Reader và Category, kiểm tra các quan hệ khóa ngoại.
- [ ] Xây dựng nghiệp vụ mượn/trả: Thêm transaction, kiểm tra số lượng và trạng thái.
- [ ] Áp dụng Strategy và Factory: Tách quy tắc mượn và logic khởi tạo BorrowRecord.
- [ ] Kiểm thử và viết tài liệu: Test API, kiểm tra database và bổ sung comment tiếng Việt.