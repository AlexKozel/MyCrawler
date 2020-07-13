package com.example.crawler;

import com.example.crawler.service.CSVGenerator;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CSVGeneratorTests {

    CSVGenerator csvGenerator = new CSVGenerator();
    TestData testData = new TestData();

    @Test
    public void escapeSpecialCharactersTest() {
        String after = csvGenerator.escapeSpecialCharacters(testData.getTestResults().get(0));
        String readyToCSV = "https://en.wikipedia.org/wiki/Elon_Musk1',  Musk=21, Elon=11 , 32";
        assertEquals(after, readyToCSV);
        assertNotEquals(after, testData.getTestResults().get(0).toString());

    }

    @Test
    public void convertToCsv_OutputCreatedTest() throws IOException {
        csvGenerator.convertToCsv_OutputCreated(testData.getTestResults(), "TestCSV.csv");
        File file = new File("TestCSV.csv");
        assertTrue(file.getTotalSpace() != 0);
        assertTrue(file.exists());
    }

    @Test
    public void top10PrintTest() throws IOException {
        csvGenerator.top10Print(testData.getTestResults());
        File file = new File("CSV_TOP10.csv");
        assertTrue(file.getTotalSpace() != 0);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        assertEquals(bufferedReader.lines().toArray().length, 10);
        assertTrue(file.exists());

    }
}
