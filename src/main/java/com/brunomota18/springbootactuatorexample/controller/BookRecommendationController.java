package com.brunomota18.springbootactuatorexample.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import com.brunomota18.springbootactuatorexample.model.Book;
import com.brunomota18.springbootactuatorexample.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

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
    @HystrixCommand(fallbackMethod = "getBookRecommendationFallback", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "715")})
    public Book getBookRecommendation(@RequestParam(name="subject", required=false, defaultValue="coding") String subject){
        Random random = new Random();
        List<Book> bookList = bookService.getBookList(subject).getBooks();
        Book book = bookList.get(random.nextInt(bookList.size()));
        return book;
    }

    public Book getBookRecommendationFallback(String subject){
        return new Book("Murder of Roger Ackroyd", "null", Arrays.asList("Agatha Christie"), 
          "A great crime novel...");
    }
    
}