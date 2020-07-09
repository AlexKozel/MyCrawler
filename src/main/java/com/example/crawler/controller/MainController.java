package com.example.crawler.controller;

import com.example.crawler.service.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @Autowired
    Crawler crawler;

    String  startUrl = "https://en.wikipedia.org/wiki/Elon_Musk";

    String words = "Musk, Elon";

//    @PostMapping("/start")
//    public ResponseEntity<Map<String, Сoincidences>> StartCrawler(){
//        Map result = crawler.scan(startUrl, 1);
//        return new ResponseEntity<Map<String, Сoincidences>>( result, HttpStatus.OK);
//    }

    @GetMapping("/start")
    public String getResult(){
        return crawler.scan(startUrl,1, words);
    }

}
