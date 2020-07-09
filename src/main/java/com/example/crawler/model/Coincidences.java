package com.example.crawler.model;

import java.util.Map;
import java.util.Objects;

public class Coincidences {
    private Map<String, Integer> allCoincidences;

    public Coincidences(Map<String, Integer> allCoincidences) {
        this.allCoincidences = allCoincidences;
    }

    public Map<String, Integer> getAllCoincidences() {
        return allCoincidences;
    }

    public void setAllCoincidences(Map<String, Integer> allCoincidences) {
        this.allCoincidences = allCoincidences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coincidences that = (Coincidences) o;
        return Objects.equals(allCoincidences, that.allCoincidences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allCoincidences);
    }
}
