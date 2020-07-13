package com.example.crawler.service;

import com.example.crawler.model.PageResult;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CSVGenerator {

    public String escapeSpecialCharacters(PageResult pageResult) {
        String data = pageResult.toString();
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            escapedData = data.replace("\"", "\"\"").replace("{", " ").replace("}", " ");
        }
        return escapedData;
    }

    public void convertToCsv_OutputCreated(ArrayList<PageResult> pageResults, String file) throws IOException {
        File csvOutputFile = new File(file);
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            pageResults.stream()
                    .map(this::escapeSpecialCharacters)
                    .forEach(pw::println);
        }
    }


    /**
     * get t10 pages with maximum total visit
     *
     * @param pageResults
     * @throws IOException
     */
    public void top10Print(ArrayList<PageResult> pageResults) throws IOException {
        ArrayList<PageResult> list = new ArrayList<>(pageResults
                .stream()
                .sorted((pageResult, t1) -> t1.getTotalCoincidences().compareTo(pageResult.getTotalCoincidences()))
                .collect(Collectors.toCollection(ArrayList::new)).subList(0, 10));
        convertToCsv_OutputCreated(list, "CSV_TOP10.csv");
        for (PageResult result : list
        ) {
            System.out.println(result);
        }
    }
}
