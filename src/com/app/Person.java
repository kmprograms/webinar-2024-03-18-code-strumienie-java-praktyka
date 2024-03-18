package com.app;

public record Person(String name, int age) {
    public boolean isAdult() {
        return age >= 18;
    }
}
