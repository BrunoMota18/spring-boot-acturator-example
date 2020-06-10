package com.brunomota18.springbootactuatorexample.controller;

import java.util.List;
import java.util.Random;
import com.brunomota18.springbootactuatorexample.model.Book;
import com.brunomota18.springbootactuatorexample.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookRecommendationController {

    @Autowired
    private BookService bookService;

    @GetMapping("/recommendations")
    @ResponseBody
    public Book getBookRecommendation(@RequestParam(name="subject", required=false, defaultValue="coding") String subject){
        Random random = new Random();
        List<Book> bookList = bookService.getBookList(subject).getBooks();
        return bookList.get(random.nextInt(bookList.size()));
    }
    
}