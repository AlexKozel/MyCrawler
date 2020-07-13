package com.example.crawler;

import com.example.crawler.controller.MainController;
import com.example.crawler.service.CSVGenerator;
import com.example.crawler.service.Crawler;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class CrawlerApplicationTests {

    private CSVGenerator csvGenerator = Mockito.mock(CSVGenerator.class);
    private Crawler crawler = Mockito.mock(Crawler.class);

    MainController mainController = new MainController(crawler, csvGenerator);

    TestData testData= new TestData();

    @Test
    void contextLoads() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void MainControllerTest() throws IOException {
        when(crawler.scan(any(),any(),any())).thenReturn(testData.getTestResults());

         HashMap<String, String> map = new HashMap<>();
         map.put("startUrl", "https://en.wikipedia.org/wiki/Elon_Musk");
         map.put("words", "Tesla, Musk, Gigafactory, Elon Mask");
         assertNotNull( mainController.getResult(map));
         verify(csvGenerator).convertToCsv_OutputCreated(any(), anyString());
         verify(csvGenerator).top10Print(any());
    }

}
