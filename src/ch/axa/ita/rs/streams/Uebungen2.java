package ch.axa.ita.rs.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static ch.axa.ita.rs.streams.Car.*;
import static ch.axa.ita.rs.streams.Person.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Uebungen2 {
    private static final String ROOT = "src/ch/axa/ita/rs/streams/";
    private static final String PERSONS_FILE = "Persons.txt";
    private static final String CARS_FILE = "Cars.txt";
    private static final String SEPARATOR = ";";

    private Uebungen2() {
        super();

        List<Person> persons = getPersonsFromFile();
        System.out.println("Aufgabe 1:");

        printPersons(persons
                .stream()
                .filter(person -> person.getCar() != null)
                .collect(Collectors.toList())
        );

        System.out.println();
    }

    private void printPersons(List<Person> persons) {
        persons.forEach(person -> System.out.println(person));
    }

    private List<Person> getPersonsFromFile() {
        List<Person> persons = getListFromFile(PERSONS_FILE)
                .map(person -> new Person(person[FIRSTNAME], person[LASTNAME], parseDouble(person[HEIGHT]), parseInt(person[AGE])))
                .collect(Collectors.toList());

        getListFromFile(CARS_FILE)
                .forEach(car -> persons
                        .stream()
                        .filter(person -> parseInt(car[USER_ID]) == person.getId())
                        .findFirst()
                        .get()
                        .setCar(new Car(car[BRAND], car[MODEL], car[COLOR], parseInt(car[PS]))));

        return persons;
    }

    private Stream<String[]> getListFromFile(String file) {
        Stream<String[]> data = null;

        try {
            data = Files
                    .readAllLines(Paths.get(ROOT.concat(file)))
                    .stream()
                    .map(entry -> entry.split(SEPARATOR));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    public static void main(String[] args) {
        new Uebungen2();
    }
}
