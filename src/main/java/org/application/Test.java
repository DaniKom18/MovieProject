package org.application;

import org.entity.Movie;

import java.util.HashMap;
import java.util.Map;

public class Test {
    private static HashMap<Integer, Movie> movie = new HashMap<>();

    public static void main(String[] args) {
        movie.put(1, new Movie("hey", "Say", "lay", 2.0));
        movie.put(2, new Movie("yey", "lay", "KOKOK", 3.0));


        System.out.println(movie);
        movie.forEach((key, value)-> System.out.println(key +""+ value));
        System.out.println(movie.values());
    }
}
