package com.library.librarymanagementsystem;

import com.library.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BookService bookService = context.getBean("bookService", BookService.class);
		bookService.performService();
	}

}
