package com.library.bookstoreapi.controller;


import com.library.bookstoreapi.model.Book;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book book) {
        Book updatedBook = bookList.stream()
                .filter(b -> b.getId().equals(id))
                .findFirst()
                .map(existingBook -> {
                    existingBook.setTitle(book.getTitle());
                    existingBook.setAuthor(book.getAuthor());
                    existingBook.setPrice(book.getPrice());
                    existingBook.setIsbn(book.getIsbn());
                    return existingBook;
                })
                .orElseThrow(() -> new IllegalArgumentException("Book not found"));

        return new ResponseEntity<>(updatedBook, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteBook(@PathVariable Long id) {
        bookList.removeIf(book -> book.getId().equals(id));
        return "Book with ID " + id + " has been deleted.";
    }
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookList.stream()
                .filter(book -> book.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(required = false) String title,
                                  @RequestParam(required = false) String author) {
        return bookList.stream()
                .filter(book -> (title == null || book.getTitle().equalsIgnoreCase(title)) &&
                        (author == null || book.getAuthor().equalsIgnoreCase(author)))
                .toList();
    }

    @PostMapping
    public ResponseEntity<Book> addBookWithHeaders(@RequestBody Book book) {
        book.setId((long) (bookList.size() + 1));
        bookList.add(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Custom-Header", "BookAddedSuccessfully");

        return new ResponseEntity<>(book, headers, HttpStatus.CREATED);
    }

}
