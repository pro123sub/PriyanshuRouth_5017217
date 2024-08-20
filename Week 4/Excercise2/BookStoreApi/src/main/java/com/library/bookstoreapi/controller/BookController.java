package com.library.bookstoreapi.controller;


import com.library.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController
{
    Book book = new Book();
    private List<Book> bookList = new ArrayList<>();
    public List<Book> getAllBooks() {
        return bookList;
    }
    @PostMapping
    public Book addBook(@RequestBody Book book) {

        bookList.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book book) {
        for (Book b : bookList) {
            if (b.getId().equals(id)) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setPrice(book.getPrice());
                b.setIsbn(book.getIsbn());
                return b;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookList.removeIf(book -> book.getId().equals(id));
        return "Book with ID " + id + " has been deleted.";
    }
}
