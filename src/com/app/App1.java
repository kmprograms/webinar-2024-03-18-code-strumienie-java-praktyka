package com.app;

import java.util.List;

/*
    W strumieniach w Javie operacje można podzielić na dwie główne kategorie: metody pośrednie (intermediate operations)
    i metody końcowe (terminal operations). To podział, który określa rolę i efekty działania poszczególnych operacji
    w łańcuchu przetwarzania strumienia danych. Oto główne różnice i cechy charakterystyczne tych dwóch typów metod:

    Metody Pośrednie (Intermediate Operations)
    Metody pośrednie mogą być łączone w łańcuchy (chain), co oznacza, że wynik jednej operacji pośredniej może być
    przekazywany jako wejście do kolejnej. Wykonanie operacji pośrednich jest leniwe, co oznacza, że nie są one
    faktycznie wykonane do momentu wywołania metody końcowej. Pozwala to na optymalizację przetwarzania (np. łączenie
    wielu operacji w jedną). Każda metoda pośrednia zwraca nowy strumień, umożliwiając dalsze przetwarzanie.
    Nie modyfikują one oryginalnego strumienia. Przykłady: filter(), map(), flatMap(), sorted(), distinct(),
    limit(), skip().

    Metody Końcowe (Terminal Operations)
    Metody końcowe uruchamiają przetwarzanie strumienia i zamykają go, co oznacza, że po ich wykonaniu strumień staje
    się zużyty i nie może być dalej używany. W przeciwieństwie do metod pośrednich, metody końcowe zazwyczaj zwracają
    wynik w postaci wartości lub efektu ubocznego (np. void), a nie strumień. Mogą zwracać różne typy danych,
    w zależności od operacji, np. wartość boolean (dla anyMatch(), allMatch(), noneMatch()), obiekt (dla findAny(),
    findFirst()), wartość numeryczną (dla count()) lub kolekcję (dla collect()).

    Podsumowując, metody pośrednie służą do tworzenia łańcuchów operacji przetwarzających elementy strumienia, ale
    sam proces przetwarzania zostaje uruchomiony dopiero przy wywołaniu metody końcowej. Metody końcowe z kolei
    uruchamiają przetwarzanie i dostarczają wynik operacji na strumieniu, po czym strumień jest zużywany
    i nie może być ponownie używany.

    ==> Zalety

    Strumienie pozwalają na bardziej zwięzłe i czytelne wyrażenie operacji na kolekcjach danych, zmniejszając
    potrzebę pisania boilerplate code.

    Pozwalają programiście skupić się na "co" ma być wykonane, a nie "jak" ma być wykonane, co ułatwia
    zrozumienie intencji kodu.

    Dzięki strumieniom rownoleglym łatwo jest wykorzystać potencjał wielowątkowości bez bezpośredniego zarządzania
    wątkami, co może przynieść znaczne korzyści wydajnościowe przy przetwarzaniu dużych zbiorów danych.

    Operacje na strumieniach mogą być łańcuchowane, co ułatwia tworzenie złożonych przekształceń danych w sposób deklaratywny.

    Strumienie zapewniają bogaty zestaw operacji takich jak filtrowanie, mapowanie, redukcja, agregacja, sortowanie,
    i inne, co ułatwia manipulację i analizę danych.

    Operacje pośrednie na strumieniach są wykonywane leniwie, co oznacza, że wykonanie następuje dopiero w momencie
    wywołania operacji końcowej. Pozwala to na optymalizację przetwarzania.

==> Wady

    Dla programistów nieobeznanych z programowaniem funkcyjnym lub strumieniami, ich nauka może być początkowo wyzwaniem.

    Choć równoległość strumieni może przynieść korzyści, nie zawsze jest on idealny dla każdego przypadku użycia. Nieprawidłowe użycie strumieni równoległych może prowadzić do gorszej wydajności niż przy użyciu pętli tradycyjnych, ze względu na koszty związane z zarządzaniem wątkami.

    Strumienie i operacje lambda mogą być trudniejsze do debugowania niż tradycyjne pętle i operacje, ponieważ stack trace może być mniej intuicyjny.

    Niektórzy programiści mogą nadużywać strumieni, stosując je nawet tam, gdzie tradycyjne pętle lub operacje na kolekcjach byłyby bardziej zrozumiałe lub wydajne.

    Strumienie nie zmieniają źródłowej kolekcji danych, co jest zarówno zaletą, jak i wadą. W pewnych sytuacjach mutowanie oryginalnej kolekcji może być pożądane.

    Użycie strumieni może wiązać się z dodatkowym, choć zazwyczaj niewielkim, kosztem pamięciowym spowodowanym tworzeniem obiektów pośrednich.
*/

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

        PeopleService peopleService = new PeopleServiceImpl(people);

        System.out.println(peopleService.filterIfAdultV1());
        System.out.println(peopleService.filterIfAdultV2());
        System.out.println(peopleService.filter(person -> person.isAdult()));
        System.out.println(peopleService.filter(person -> person.name().startsWith("A")));
        System.out.println(peopleService.mapToNames());
        System.out.println(peopleService.mapTo(person -> person.age()));


    }
}
