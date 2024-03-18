package com.app;

import java.util.List;

public class App1 {
    public static void main(String[] args) {
        var people = List.of(
                new Person("ADAM", 15),
                new Person("EWA", 17),
                new Person("CEZARY", 34),
                new Person("DANIEL", 31),
                new Person("EWA", 37),
                new Person("MARTA", 26),
                new Person("KAMIL", 23),
                new Person("PIOTR", 28));
    }
}
