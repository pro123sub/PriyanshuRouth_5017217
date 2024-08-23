package com.library.bookstoreapi.controllers;

import com.library.bookstoreapi.Services.BookServices;
import com.library.bookstoreapi.controller.BookController;
import com.library.bookstoreapi.model.Book;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookServices bookService;

    @Test
    public void testGetBookById() throws Exception {
        Book book = new Book(1L, "Title", "Author", 100.0, "1234567890");
        Mockito.when(bookService.findBookById(1L)).thenReturn(book);

        mockMvc.perform(get("/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"));
    }
}
