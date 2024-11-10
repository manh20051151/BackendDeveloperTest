package com.example.book_service.controller;

import com.example.book_service.dto.request.BookCreateRequest;
import com.example.book_service.dto.request.BookUpdateRequest;
import com.example.book_service.entity.Book;
import com.example.book_service.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    Book createBook(@RequestBody @Valid BookCreateRequest request){
        return bookService.createBook(request);
    }

    @GetMapping
    List<Book> getBooks(){
        return bookService.getUsers();
    }

    @GetMapping("/{bookId}")
    Book getBook(@PathVariable String bookId){
        return  bookService.getBook(bookId);
    }

    @PutMapping("/{bookId}")
    Book updateBook(@PathVariable String bookId, @RequestBody BookUpdateRequest request){
        return bookService.updateBook(bookId, request);
    }

    @DeleteMapping("/{bookId}")
    String deleteBook(@PathVariable String bookId){
        bookService.deleteBook(bookId);
        return "Book has been deleted";
    }
}
