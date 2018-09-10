package com.zancija.fizzbuzz.service;

import com.zancija.fizzbuzz.data.FizzBuzzType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FizzBuzzService {

    /**
     * Implements the rules of Fizz Buzz game: numbers divisible by three replaced with the word "fizz" and numbers divisible by five with the word "buzz".
     * @param numbers integers list that should be converted according to Fizz Buzz game rules
     * @return strings list that is converted according to Fizz Buzz game rules
     */
    public List<String> playGame(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Numbers array is not present");
        }
        return numbers.stream().map(n -> convert(n)).collect(Collectors.toList());
    }

    private String convert(Integer number) {
        String result = checkRemainder(number, FizzBuzzType.FIZZ);
        result += checkRemainder(number, FizzBuzzType.BUZZ);
        return result.length() > 0 ? result : String.valueOf(number);
    }

    private String checkRemainder(Integer number, FizzBuzzType type) {
        if (number % type.getNumber() == 0) {
            return type.toString().toLowerCase();
        }
        return "";
    }
}
