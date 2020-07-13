package com.example.crawler;

import com.example.crawler.model.PageResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestData {

    public static String URL = "https://en.wikipedia.org/wiki/Elon_Musk";
    public static String WORDS = "Elon, Musk";


    public ArrayList<String> getTestPage(){
        String url = "<LINK REL=STYLESHEET TYPE=\"text/css\" HREF=\"work/css.css\">"
                + "</HEAD><BODY>"
                + "<H1><A href=\"https://en.wikipedia.org/wiki/Elon_Musk1\">Полный справочник по C</A></H1>"
                + "<H2><A href=\"I.htm\" name=\"I\">Часть I. Основы языка C</A></H2>"
                + "<UL type=disk>"
                + "<LI><A href=\"01/01.htm\" name=\"01\"><B>Глава 01. Обзор возможностей языка C</B></A>"
                + "<UL type=circle>"
                + "<Elon Musk asdg  abc asfgqwbj Musasdf Musk ad>"
                + "<Elon Musk asdg Musk Musk. abc. abc asfgqwbj Musasdf Musk ad>"
                + "<LI><A HREF=\"01/0101.htm\">Краткая история развития С</A>"
                + "<LI><A href = \"https://en.wikipedia.org/wiki/Elon_Musk2\">С - язык среднего уровня</A>"
                + "</UL>";
        String[] lines = url.split("/A");
        ArrayList<String> html = new ArrayList<String>(Arrays.asList(lines));
        return html;
    }

    public ArrayList<PageResult> getTestResults(){
        ArrayList<PageResult> pageResults= new ArrayList<>();
        Map<String, Integer> innerMap1 = new HashMap<>();
        Map<String, Integer> innerMap2 = new HashMap<>();
        Map<String, Integer> innerMap3 = new HashMap<>();
        Map<String, Integer> innerMap4 = new HashMap<>();
        Map<String, Integer> innerMap5 = new HashMap<>();
        Map<String, Integer> innerMap6 = new HashMap<>();
        Map<String, Integer> innerMap7 = new HashMap<>();
        Map<String, Integer> innerMap8 = new HashMap<>();
        Map<String, Integer> innerMap9 = new HashMap<>();
        Map<String, Integer> innerMap10 = new HashMap<>();
        Map<String, Integer> innerMap11 = new HashMap<>();
        innerMap1.put("Elon", 11);
        innerMap1.put("Musk", 21);
        innerMap2.put("Elon", 12);
        innerMap2.put("Musk", 22);
        innerMap3.put("Elon", 12);
        innerMap3.put("Musk", 22);
        innerMap4.put("Elon", 12);
        innerMap4.put("Musk", 22);
        innerMap5.put("Elon", 12);
        innerMap5.put("Musk", 22);
        innerMap6.put("Elon", 12);
        innerMap6.put("Musk", 22);
        innerMap7.put("Elon", 12);
        innerMap7.put("Musk", 22);
        innerMap8.put("Elon", 12);
        innerMap8.put("Musk", 22);
        innerMap9.put("Elon", 12);
        innerMap9.put("Musk", 22);
        innerMap10.put("Elon", 12);
        innerMap10.put("Musk", 22);
        innerMap11.put("Elon", 12);
        innerMap11.put("Musk", 22);
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap1));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap2));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap3));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap4));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap5));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap6));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap7));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap8));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap9));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap10));
        pageResults.add(new PageResult("https://en.wikipedia.org/wiki/Elon_Musk1",innerMap11));

        return pageResults;

    }



}
