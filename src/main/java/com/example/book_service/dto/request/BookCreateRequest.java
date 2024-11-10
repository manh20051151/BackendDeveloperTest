package com.example.book_service.dto.request;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.sql.Date;

public class BookCreateRequest {
    @NotNull(message = "title cannot be null")
    @Size(min = 3, message = "title must be at least 3 characters")
    private String title;
    @NotNull(message = "author cannot be null")
    @Size(min = 3, message = "author must be at least 3 characters")
    private String author;
    @NotNull(message = "publishedDate cannot be null")

    private Date publishedDate;
    @NotNull(message = "isbn cannot be null")
    @Size(min = 3, message = "isbn must be at least 3 characters")
    private String isbn;
    @NotNull(message = "price cannot be null")
    @Positive(message = "price must be greater than 0")
    private BigDecimal price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
