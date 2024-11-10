# Book Service

## Yêu cầu hệ thống

1. **IntelliJ IDEA**: Cài đặt IntelliJ IDEA để chạy ứng dụng.
   - Tải về và cài đặt từ: [JetBrains IntelliJ IDEA](https://www.jetbrains.com/idea/download/)

2. **MySQL**: Cài đặt MySQL để chạy cơ sở dữ liệu.
   - Tạo một cơ sở dữ liệu với tên `book_service`.
   - Cấu hình MySQL với tài khoản người dùng:
     - Username: `root`
     - Password: `root`

## Cài đặt và chạy ứng dụng
- Đảm bảo MySQL đã chạy và có cơ sở dữ liệu `book_service`.
- Mở dự án trong IntelliJ IDEA và chạy

## Api

### CRUD `http://localhost:8080/book/`

-   `[POST] /books`: add book.
    -   body: {title: String, author: String, publishedDate: Date, isbn: String, price :BigDecimal}.
    -   result: {title: String, author: String, publishedDate: Date, isbn: String, price :BigDecimal}.
    -   error: {String}
-   `[GET] /books`: get books.
    -   result: [{title: String, author: String, publishedDate: Date, isbn: String, price :BigDecimal}].
-   `[GET] /books/{id}`: get book by id.
    -   result: {title: String, author: String, publishedDate: Date, isbn: String, price :BigDecimal}.
    -   error: {String}
-   `[PUT] /books/{id}`: update book.
    -   body: {username: String, otp: String}.
    -   error: {String}
-   `[DELETE] /books/{id}`: delete book.
    -   result: {String}.
    -   error: {String}
 
Example body: 
{
    "title": "Spring Boot in Action 2",
    "author": "Craig Walls",
    "publishedDate": "2023-10-10",
    "isbn": "1234567890124",
    "price": 29.99
}
