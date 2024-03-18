package com.app;

public record Person(String name, int age) /*implements Comparable<Person>*/ {
    public boolean isAdult() {
        return age >= 18;
    }

    /*@Override
    public int compareTo(Person o) {
        return 0;
    }*/
}
