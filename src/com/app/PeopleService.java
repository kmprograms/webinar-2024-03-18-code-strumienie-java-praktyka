package com.app;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public interface PeopleService {

    List<Person> filterIfAdultV1();

    List<Person> filterIfAdultV2();

    List<Person> filter(Predicate<Person> personTester);

    <T> List<T> filterV2(Function<Person, T> mapper, Predicate<T> personTester);

    // MAPOWANIE / KONWERSJA

    <T> List<T> mapTo(Function<Person, T> mapper);

    List<String> mapToNames();

    // SORTOWANIE
    Set<Person> sort(Comparator<Person> personComparator);

    // Pobieraj elementy dopoki spelniaja warunek
    List<Person> takeWhile(Predicate<Person> personTester);

    // Usuwa elementy dopoki spelniaja warunek
    List<Person> dropWhile(Predicate<Person> personTester);
}
