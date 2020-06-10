package com.brunomota18.springbootactuatorexample.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    
    private String title;
    private String subtitle;
    private List<String> authors;
    private String description;
    
    @JsonProperty("volumeInfo")
    private void unpackValuesFromVolumeInfo(Map<String, Object> volumeInfo){
        title = (String) volumeInfo.get("title");
        subtitle = (String) volumeInfo.get("subtitle");
        authors = (List<String>) volumeInfo.get("authors");
        description = (String) volumeInfo.get("description");
    }
}