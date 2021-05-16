package ru.sberbank.firstproject.services;

import java.util.Collection;

public class Printer {
    public static <T> void printResult(T t) {
        if (t instanceof Collection) {
            ((Collection<?>) t).forEach(System.out::println);
        }
        else System.out.println(t);
    }
}
