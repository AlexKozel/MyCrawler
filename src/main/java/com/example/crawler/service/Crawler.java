package com.example.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.*;

@Service
public class Crawler {

    private final Logger logger = LoggerFactory.getLogger(Crawler.class);

    private PageScanner pageScanner;

    @Autowired
    public Crawler(PageScanner pageScanner) {
        this.pageScanner = pageScanner;
    }

    public Crawler() {
    }

    public String scan(String url, Integer depth, String words) {
        logger.info("start scan method");
        Queue<String> urlsQueue = null;
        ArrayList<String> html = new ArrayList<>();
        Map<String, Map<String, Integer>> coincidences = new HashMap<>();

        urlsQueue.add(url);
        String curUrl;

        while ((curUrl = urlsQueue.poll()) != null) {
            logger.info("start scan url {}", url);
            html = getHTML(curUrl);
            urlsQueue = new LinkedList<>(pageScanner.scanForUrls(url));
            coincidences.put(curUrl, pageScanner.scanCoincidences(html, words));

        }
        return html.toString();
    }


    /**
     * get html page as List of Strings
     *
     * @param url
     * @return
     */
    private ArrayList getHTML(String url) {

        URL u;
        try {
            u = new URL(url);
            URLConnection connection = u.openConnection();
            connection.setRequestProperty("User-Agent", "Mee/1.0");
            connection.setRequestProperty("Accept-Charset", "UTF-8");

            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            ArrayList<String> html = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                html.add(line.toLowerCase());
            }
            return html;
        } catch (Exception e) {
            logger.warn("exception - {}", e.toString());
            return null;
        }
    }
}
