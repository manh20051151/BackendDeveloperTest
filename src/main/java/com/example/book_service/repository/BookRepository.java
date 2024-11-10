package com.example.book_service.repository;

import com.example.book_service.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // đánh dấu lớp này là một repository để làm việc với cơ sở dữ liệu, chứa các phương thức CRUD
public interface BookRepository extends JpaRepository<Book, String> {
    // phương thức kiểm tra xem sách có tồn tại trong cơ sở dữ liệu với ISBN đã cho không
    boolean existsByIsbn(String isbn);
}
