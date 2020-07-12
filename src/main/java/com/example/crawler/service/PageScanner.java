package com.example.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class PageScanner {

    private Logger logger = LoggerFactory.getLogger(PageScanner.class);

    /**
     * find all urls
     */
    public List<String> scanForUrls(ArrayList<String> html) {
        logger.info("Scan for Urls");
        Set<String> set = new HashSet<>();
        for (String s : html
        ) {
            Pattern p = Pattern.compile("\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]");
            Matcher m = p.matcher(s);
            while (m.find()) {
                set.add(m.group());
            }
        }
        List<String> urls = new ArrayList<>(set);
        return urls;
    }


    /**
     * find all coincidences
     */
    public Map<String, Integer> scanCoincidences(ArrayList<String> html, String words) {
        logger.info("Scan for coincidences");
        List<String> wordsList = Arrays.stream(words.trim().split(",")).collect(Collectors.toList());

        Map<String, Integer> newMap = new HashMap<>();

        for (String s : wordsList
        ) {
            int count = 0;
            for (String singleString : html
            ) {
                Pattern p = Pattern.compile("\\b" + s.trim() + "\\b", Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);
                Matcher m = p.matcher(singleString);
                while (m.find()) count++;
            }
            newMap.put(s.trim(), count);
        }
        return newMap;
    }

}
