package com.stakkato95;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        createStream();
    }

    private static void createStream() {
        //from collection
        List<Person> persons = PersonGenerator.generatePersonList(10000);
        System.out.printf("Number %d\n", persons.parallelStream().count());

        //from supplier
        Stream.generate(new MySupplier())
                .parallel()
                .limit(10)
                .forEach(System.out::println);

        //of
        Stream.of("Hello", "World", "!")
                .parallel()
                .forEach(System.out::println);

        //file
        System.out.println("\nFrom file:");
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            br.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //directory
        System.out.println("\nFrom dir:");
        try (Stream<Path> directoryContent = Files.list(Paths.get(System.getProperty("user.home")))) {
            directoryContent.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //array
        System.out.println("\nArray:");
        int[] ints = {1, 2, 3, 4};
        IntStream fromArray = Arrays.stream(ints);
        fromArray.filter(x -> x % 2 == 0).forEach(System.out::println);

        //random
        System.out.println("\nAverage:");
        Random random = new Random();
        //peek is usually for debugging
        double avg = random.doubles(50).peek(System.out::println).average().orElse(100500);
        System.out.printf("Value %f\n", avg);

        //concatenate streams
        System.out.println("\nConcatenation:");
        Stream<String> one = Stream.of("1", "2", "3");
        Stream<String> two = Stream.of("4", "5", "6");
        Stream.concat(one, two).parallel().forEach(System.out::println);
    }
}
