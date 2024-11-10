package com.example.book_service.service;


import com.example.book_service.dto.request.BookCreateRequest;
import com.example.book_service.dto.request.BookUpdateRequest;
import com.example.book_service.entity.Book;
import com.example.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public Book createBook(BookCreateRequest request){
        Book book = new Book();
        if (bookRepository.existsByIsbn(request.getIsbn()))
            throw new RuntimeException("Isbn existed");
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setIsbn(request.getIsbn());
        book.setPrice(request.getPrice());

        return bookRepository.save(book);
    }

    public List<Book> getUsers(){
        return bookRepository.findAll();
    }

    public Book getBook(String id){
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book updateBook(String bookId, BookUpdateRequest request){
        Book book = getBook(bookId);
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setPublishedDate(request.getPublishedDate());
        book.setPrice(request.getPrice());

        return bookRepository.save(book);
    }

    public void deleteBook(String bookId){
        bookRepository.deleteById(bookId);
    }
}
