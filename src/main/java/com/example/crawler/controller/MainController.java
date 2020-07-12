package com.example.crawler.controller;

import com.example.crawler.model.PageResult;
import com.example.crawler.service.CSVGenerator;
import com.example.crawler.service.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MainController {

    @Autowired
    Crawler crawler;
    @Autowired
    CSVGenerator csvGenerator;

    /**
     * JSON for PostRequest
     * {
     * "startUrl" : "https://en.wikipedia.org/wiki/Elon_Musk",
     * "words":"Tesla, Musk, Gigafactory, Elon Mask"
     * }
     */
    @PostMapping("/start")
    public String getResult(@RequestBody HashMap<String, String> body) throws IOException {
        long start = System.currentTimeMillis();
        ArrayList<PageResult> list = crawler.scan(body.get("startUrl"), 8, body.get("words"));
        csvGenerator.convertToCsv_OutputCreated(list, "CSV_ALL.csv");
        csvGenerator.top10Print(list);
        long finish = System.currentTimeMillis();
        long timeConsumedMillis = finish - start;
        return "time1 =" + timeConsumedMillis;
    }
}
