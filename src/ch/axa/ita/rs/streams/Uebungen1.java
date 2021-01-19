package ch.axa.ita.rs.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static ch.axa.ita.rs.streams.Person.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Uebungen1 {
    private static final String ROOT = "src/ch/axa/ita/rs/streams/";
    private static final String PERSONS_FILE = "Persons.txt";
    private static final String SEPARATOR = ";";

    private Uebungen1() {
        super();

        List<Person> persons = getPersonsFromFile();
        List<Person> youngestAndOldest = new ArrayList<>();

        System.out.println("Aufgabe 1:");
        printPersons(persons);

        System.out.println();
        System.out.println("Aufgabe 2:");

        printPersons(persons
                .stream()
                .sorted(Comparator.comparingInt(Person::getAge))
                .limit(10)
                .collect(Collectors.toList())
        );

        System.out.println();
        System.out.println("Aufgabe 3:");

        youngestAndOldest.add(persons
                .stream()
                .min(Comparator.comparingInt(Person::getAge))
                .get()
        );

        youngestAndOldest.add(persons
                .stream()
                .max(Comparator.comparingInt(Person::getAge))
                .get()
        );

        printPersons(youngestAndOldest);
    }

    private void printPersons(List<Person> persons) {
        persons.forEach(person -> System.out.println(person));
    }

    private List<Person> getPersonsFromFile() {
        List<Person> persons = new ArrayList<>();

        try {
            persons = Files
                    .readAllLines(Paths.get(ROOT.concat(PERSONS_FILE)))
                    .stream()
                    .map(person -> {
                        String[] personData = person.split(SEPARATOR);
                        return new Person(personData[FIRSTNAME], personData[LASTNAME], parseDouble(personData[HEIGHT]), parseInt(personData[AGE]));
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public static void main(String[] args) {
        new Uebungen1();
    }
}
