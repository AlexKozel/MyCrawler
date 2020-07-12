package com.example.crawler.model;

import lombok.Data;

import java.util.Map;

@Data
public class PageResult {

    private String url;
    private Map coincidences;
    private Integer totalCoincidences;

   public PageResult(String url, Map coincidences){
        this.url = url;
        this.coincidences = coincidences;
        totalCoincidences=0;
        coincidences.values().stream().forEach(i ->totalCoincidences=totalCoincidences+(Integer)i);
    }


    @Override
    public String toString() {
        return url + '\'' +
                ", " + coincidences +
                ", " + totalCoincidences ;
    }
}
