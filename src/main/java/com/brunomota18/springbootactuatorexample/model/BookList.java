package com.brunomota18.springbootactuatorexample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class BookList {
    @JsonProperty("items")
    List<Book> books;
}
