package com.example.crawler;

import com.example.crawler.service.PageScanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;

public class PageScannerTests {

    PageScanner pageScanner = new PageScanner();
    TestData testData= new TestData();

    @Test
    public void scanForUrlsTest(){
       List<String> urls =  pageScanner.scanForUrls(testData.getTestPage());
       assertFalse(urls.isEmpty());
    }

    @Test
    public void scanCoincidencesTest(){
        Map<String, Integer> map =
        pageScanner.scanCoincidences(testData.getTestPage(), TestData.WORDS);
        assertFalse(map.isEmpty());
    }

}
