package com.app;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PeopleServiceImpl implements PeopleService{
    private final List<Person> people;

    public PeopleServiceImpl(List<Person> people) {
        this.people = people;
    }

    // Filtrowanie

    public List<Person> filterIfAdultV1() {
        var filteredPeople = new ArrayList<Person>();
        for (var person : people) {
            if (person.isAdult()) {
                filteredPeople.add(person);
            }
        }
        return filteredPeople;
    }

    public List<Person> filterIfAdultV2() {
        return people
                .stream()
                .filter(person -> person.isAdult())
                .toList();
    }

    public List<Person> filter(Predicate<Person> personTester) {
        return people
                .stream()
                .filter(personTester)
                .toList();
    }

    public <T> List<T> filterV2(Function<Person, T> mapper, Predicate<T> personTester) {
        return people
                .stream()
                .map(mapper)
                .filter(personTester)
                .toList();
    }

    // MAPOWANIE / KONWERSJA

    public <T> List<T> mapTo(Function<Person, T> mapper) {
        return people
                .stream()
                .map(mapper)
                .toList();
    }

    public List<String> mapToNames() {
        /*return people
                .stream()
                .map(person -> person.name())
                .toList();*/
        return mapTo(person -> person.name());
    }

    // SORTOWANIE
    public Set<Person> sort(Comparator<Person> personComparator) {
        return people
                .stream()
                .sorted(personComparator)
                // Metoda collect wspolpracuje z collectorami
                .collect(Collectors.toCollection(() -> new LinkedHashSet<>()));
    }

    // Pobieraj elementy dopoki spelniaja warunek
    public List<Person> takeWhile(Predicate<Person> personTester) {
        return people
                .stream()
                .takeWhile(personTester)
                .toList();
    }

    // Usuwa elementy dopoki spelniaja warunek
    public List<Person> dropWhile(Predicate<Person> personTester) {
        return people
                .stream()
                // .mapMulti() vs flatMap()
                .dropWhile(personTester)
                .toList();
    }
}
