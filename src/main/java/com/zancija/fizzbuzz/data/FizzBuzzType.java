package com.zancija.fizzbuzz.data;

public enum FizzBuzzType {

    FIZZ(3),
    BUZZ(5);

    private final int number;

    FizzBuzzType(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
