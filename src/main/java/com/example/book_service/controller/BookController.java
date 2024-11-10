package com.example.book_service.controller;

import com.example.book_service.dto.request.BookCreateRequest;
import com.example.book_service.dto.request.BookUpdateRequest;
import com.example.book_service.entity.Book;
import com.example.book_service.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // đánh dấu lớp này là một REST controller, xử lý các yêu cầu HTTP
@RequestMapping("books") // định nghĩa URL cơ sở cho các endpoint của controller này, tất cả sẽ bắt đầu với '/books'
public class BookController {
    @Autowired
    private BookService bookService;

    // định nghĩa endpoint HTTP POST để tạo sách mới
    // sử dụng @Valid để thực hiện xác thực dữ liệu đầu vào (các yêu cầu trong BookCreateRequest)
    @PostMapping
    Book createBook(@RequestBody @Valid BookCreateRequest request){
        return bookService.createBook(request);
    }

    // định nghĩa endpoint HTTP GET để lấy danh sách tất cả các sách
    @GetMapping
    List<Book> getBooks(){
        return bookService.getBooks();
    }

    // định nghĩa endpoint HTTP GET để lấy thông tin một cuốn sách theo ID
    @GetMapping("/{bookId}")
    Book getBook(@PathVariable String bookId){
        return  bookService.getBook(bookId);
    }

    // định nghĩa endpoint HTTP PUT để cập nhật thông tin một cuốn sách
    // sử dụng @Valid để xác thực dữ liệu đầu vào từ BookUpdateRequest
    @PutMapping("/{bookId}")
    Book updateBook(@PathVariable String bookId, @RequestBody @Valid BookUpdateRequest request){
        return bookService.updateBook(bookId, request);
    }

    // định nghĩa endpoint HTTP DELETE để xóa một cuốn sách
    @DeleteMapping("/{bookId}")
    String deleteBook(@PathVariable String bookId){
        bookService.deleteBook(bookId);
        return "Book has been deleted";
    }
}
