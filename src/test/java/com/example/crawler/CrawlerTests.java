package com.example.crawler;

import com.example.crawler.service.Crawler;
import com.example.crawler.service.PageScanner;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CrawlerTests {

    PageScanner pageScannerMock = Mockito.mock(PageScanner.class);
    Crawler crawler = new Crawler(pageScannerMock);
    TestData testData = new TestData();

    @Test
    public void scanTest() {
        Mockito.when(pageScannerMock.scanCoincidences(any(), anyString())).thenReturn(testData.getTestResults().get(1).getCoincidences());
        Mockito.when(pageScannerMock.scanForUrls(any())).thenReturn(null);
        crawler.scan(TestData.URL,1,TestData.WORDS);
        verify(pageScannerMock).scanCoincidences(any(),eq("Elon, Musk"));
        verify(pageScannerMock).scanForUrls(any());
    }

    @Test
    public void getHTMLTest() {
        ArrayList<String> hmtl = crawler.getHTML("https://en.wikipedia.org/wiki/Elon_Musk");
        assertFalse(hmtl.isEmpty());
    }

}
