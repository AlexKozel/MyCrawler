package com.example.crawler;

import com.example.crawler.model.PageResult;
import com.example.crawler.service.CSVGenerator;
import com.example.crawler.service.Crawler;
import com.example.crawler.service.PageScanner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class CrawlerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void pageScannerForCoincidencesTest() {
        PageScanner pageScanner = new PageScanner();
        ArrayList<String> example = new ArrayList<>();
        example.add("Elon Musk asdg  abc asfgqwbj Musasdf Musk ad");
        example.add("Elon Musk asdg Musk Musk. abc. abc asfgqwbj Musasdf Musk ad");
        String words = "abc, musk,    Elon musk";
        pageScanner.scanCoincidences(example, words);

    }

    @Test
    public void pageScannerForUrlTest() {
        PageScanner pageScanner = new PageScanner();
        String url = "<LINK REL=STYLESHEET TYPE=\"text/css\" HREF=\"work/css.css\">"
                + "</HEAD><BODY>"
                + "<H1><A href=\"about.htm\">Полный справочник по C</A></H1>"
                + "<H2><A href=\"I.htm\" name=\"I\">Часть I. Основы языка C</A></H2>"
                + "<UL type=disk>"
                + "<LI><A href=\"01/01.htm\" name=\"01\"><B>Глава 01. Обзор возможностей языка C</B></A>"
                + "<UL type=circle>"
                + "<LI><A HREF=\"01/0101.htm\">Краткая история развития С</A>"
                + "<LI><A href = \"01/0102.htm\">С - язык среднего уровня</A>"
                + "</UL>";
        String[] lines = url.split("/A");
        ArrayList<String> html = new ArrayList<String>(Arrays.asList(lines));
        for (String s : pageScanner.scanForUrls(html)
        ) {
            System.out.println(s);

        }
    }

    @Test
    public void getHTMLTest() {
        Crawler crawler = new Crawler();
        crawler.getHTML("http://asfgas.safd");
    }

    @Test
    public void CSVGeneratorTest() throws IOException {

        ArrayList<PageResult> pageResults= new ArrayList<>();
        CSVGenerator csvGenerator = new CSVGenerator();
        Map<String, Integer> innerMap1 = new HashMap<>();
        Map<String, Integer> innerMap2 = new HashMap<>();
        innerMap1.put("Elon", 11);
        innerMap1.put("Musk", 21);
        innerMap2.put("Elon", 12);
        innerMap2.put("Musk", 22);
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap1));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap2));

        csvGenerator.convertToCsv_OutputCreated(pageResults, "CSV_TEST.csv");
    }

}
