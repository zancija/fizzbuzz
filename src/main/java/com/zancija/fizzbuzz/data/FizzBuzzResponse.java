package com.zancija.fizzbuzz.data;

import java.util.List;

public class FizzBuzzResponse {

    private List<String> results;

    public FizzBuzzResponse(List<String> results) {
        this.results = results;
    }

    public List<String> getResults() {
        return results;
    }

    public void setResults(List<String> results) {
        this.results = results;
    }
}
