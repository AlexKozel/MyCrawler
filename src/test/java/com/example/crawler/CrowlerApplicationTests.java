package com.example.crawler;

import com.example.crawler.service.PageScanner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
class CrowlerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void pageScannerForCoincidencesTest(){
        PageScanner pageScanner = new PageScanner();
        ArrayList<String> example = new ArrayList<>();
        example.add("Elon Musk asdg  abc asfgqwbj Musasdf Musk ad");
        example.add("Elon Musk asdg Musk Musk. abc. abc asfgqwbj Musasdf Musk ad");
        String words = "abc, musk";
        pageScanner.scanCoincidences(example,words);

    }

}
