package com.example.crawler.service;

import com.example.crawler.model.PageResult;
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

    private static final Integer MAX_URL_NUMBER = 20;
    private PageScanner pageScanner;

    @Autowired
    public Crawler(PageScanner pageScanner) {
        this.pageScanner = pageScanner;
    }

    public Crawler() {
    }

    public ArrayList<PageResult> scan(String url, Integer depth, String words) {
        Integer foundedURL = 0;
        Integer scanedUrl = 0;
        logger.info("start scan method");

        ArrayList<PageResult> pageResults = new ArrayList<>();

        Queue<String> urlsQueue = new LinkedList<>();
        ArrayList<String> html;

        urlsQueue.add(url);
        String curUrl;

        for (int localDepth = 0; localDepth < depth || !urlsQueue.isEmpty(); localDepth++ ) {
            Queue<String> curQueue = new LinkedList<>(urlsQueue);
            urlsQueue.clear();
            while ((curUrl = curQueue.poll()) != null && scanedUrl < MAX_URL_NUMBER) {
                logger.info("start scan url {}", curUrl);
                try {
                    html = getHTML(curUrl);                                       //get all text from html
                    if (html == null) {
                        logger.info("invalid url {}", curUrl);
                        continue;
                    }
                    scanedUrl++;
                    pageResults.add(new PageResult(curUrl, pageScanner.scanCoincidences(html, words)));// scan html for coincidences
                    /**
                     * finished scan urls from queue
                     */

                    while (foundedURL < MAX_URL_NUMBER) { //может быть погрешность неправильных адресов (картинки и прочее)
                        for (String s : pageScanner.scanForUrls(html)               //scan html for urls
                        ) {
                            if (foundedURL < MAX_URL_NUMBER) {
                                curQueue.offer(s);
                                foundedURL++;
                            }
                        }
                    }
                } catch (NullPointerException e) {
                    logger.warn(e.toString());
                }
            }
        }
        return pageResults;
    }


    /**
     * get html page as List of Strings
     *
     * @param url
     * @return
     */
    public ArrayList getHTML(String url) {

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
            logger.warn("get HTML  exception - {}", e.toString());
            return null;
        }
    }
}
