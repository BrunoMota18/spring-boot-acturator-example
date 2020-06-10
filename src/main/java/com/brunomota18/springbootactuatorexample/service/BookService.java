package com.brunomota18.springbootactuatorexample.service;

import com.brunomota18.springbootactuatorexample.model.BookList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class BookService {
    @Autowired
    private WebClient.Builder webClientBuilder;

    private final String apiUrl = "https://www.googleapis.com/books/v1/volumes?q=subject:%s&maxResults=40";

    public BookList getBookList(String subject){
        BookList subjectBooks = webClientBuilder.build()
          .get()
          .uri(String.format(apiUrl, subject))
          .retrieve()
          .bodyToMono(BookList.class)
          .block();

        return subjectBooks;
    }
}