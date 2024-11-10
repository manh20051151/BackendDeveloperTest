package com.example.book_service.service;


import com.example.book_service.dto.request.BookCreateRequest;
import com.example.book_service.dto.request.BookUpdateRequest;
import com.example.book_service.entity.Book;
import com.example.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // đánh dấu lớp này là một service để chứa các logic nghiệp vụ, thường được sử dụng trong lớp này để xử lý dữ liệu từ repository
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    // phương thức tạo sách mới
    public Book createBook(BookCreateRequest request){
        Book book = new Book();
        // kiểm tra nếu isbn đã tồn tại trong cơ sở dữ liệu
        if (bookRepository.existsByIsbn(request.getIsbn()))
            throw new RuntimeException("Isbn existed");
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());

        return bookRepository.save(book);
    }

    // phương thức lấy danh sách tất cả các sách
    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    // phương thức lấy thông tin một cuốn sách theo ID
    public Book getBook(String id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    // phương thức cập nhật thông tin sách
    public Book updateBook(String bookId, BookUpdateRequest request){
        Book book = getBook(bookId);
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setPrice(request.getPrice());

        return bookRepository.save(book);
    }
    // phương thức xóa sách theo ID
    public void deleteBook(String bookId){
        bookRepository.deleteById(bookId);
    }
}
