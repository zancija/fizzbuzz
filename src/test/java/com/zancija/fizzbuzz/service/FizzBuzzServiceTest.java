package com.zancija.fizzbuzz.service;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

public class FizzBuzzServiceTest {

    private FizzBuzzService service = new FizzBuzzService();

    @Test
    public void testPlayGame() {
        assertEquals(Arrays.asList("1"), service.playGame(Arrays.asList(1)));
        assertEquals(Arrays.asList("fizz"), service.playGame(Arrays.asList(3)));
        assertEquals(Arrays.asList("buzz"), service.playGame(Arrays.asList(5)));
        assertEquals(Arrays.asList("fizzbuzz"), service.playGame(Arrays.asList(15)));
        assertEquals(Arrays.asList("fizzbuzz", "4", "buzz", "fizz"), service.playGame(Arrays.asList(105, 4, 25, 99)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayGameNullList() {
        service.playGame(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testPlayGameEmptyList() {
        service.playGame(Arrays.asList());
    }
}