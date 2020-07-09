package com.example.crawler.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class PageScanner {

    private Scanner sc = new Scanner(System.in);

    public List<String> scanForUrls(String url) {
        Scanner sc = new Scanner(System.in);
//        String word = "musk";
//        int count = 0;
//        for (String singleString : html
//        ) {
//            Pattern p = Pattern.compile("\\b"+word +"\\b", Pattern.UNICODE_CASE| Pattern.CASE_INSENSITIVE);
//            Matcher m = p.matcher(singleString);
//            while(m.find()) count++;
//
//        }
//        System.out.println(count);
        List<String> urls = new ArrayList<>();
        return urls;
    }


    /**
     * fin all coincidences
     */
    public Map<String, Integer> scanCoincidences(ArrayList<String> html, String words) {
        List<String> wordsList = Arrays.stream(words.split(",")).collect(Collectors.toList());

        Map<String, Integer> newNap = new HashMap<>();

        for (String s : wordsList
        ) {
            int count = 0;
            for (String singleString : html
            ) {
                Pattern p = Pattern.compile("\\b" + s.toLowerCase().trim() + "\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(singleString);
                while (m.find()) count++;
            }
            newNap.put(s,count);
        }
        System.out.println("result = " + newNap);
        return newNap;
    }

}
