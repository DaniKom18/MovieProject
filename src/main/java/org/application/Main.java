package org.application;

import org.entity.MovieManager;

import java.util.Scanner;

public class Main {
    private static MovieManager movies = new MovieManager();
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

/*
        movies.createMovie("Albert", "Hoffman", "LSD", 10.0);
        movies.createMovie("John", "Hoffman", "Informatik", 6.0);
        movies.createMovie("Jo", "Kreisler", "Move", 9.0);

        System.out.println("_".repeat(10));
        movies.readMovie(1);
        System.out.println("_".repeat(10));
        movies.readAllMovie();
        System.out.println("_".repeat(10));
        movies.updateMovie(2, "John2", "Jimbean", "ThI", 0.0 );
        System.out.println("_".repeat(10));
        movies.deleteMovie(3);
        System.out.println("_".repeat(10));
        movies.readAllMovie();
*/
        //ToDO implement While(True) where user can go through all Options by himself
        boolean run = true;
        while (run){
            System.out.println("Press '1' for creating a movie");
            System.out.println("Press '2' for reading all movies");
            System.out.println("Press '3' for reading 1 movie");
            System.out.println("Press '4' for updating a movie");
            System.out.println("Press '5' for updating a movie rating");
            System.out.println("Press '6' for deleting a movie");
            System.out.println("Press '7' exit");


            System.out.println("Input: ");
            int userInput = userInputInt();

            switch (userInput){
                case 1:
                    createMovie();
                    break;

                case 2:
                    movies.readAllMovie();
                    break;

                case 3:
                    readMovie();
                    break;

                case 4:
                    updateMovie();
                    break;

                case 5:
                    updateMovieRating();
                    break;

                case 6:
                    deleteMovie();
                    break;

                case 7:
                    run = false;
                    break;

                default:
                    continue;
            }
        }

    }

    private static void deleteMovie() {
        int id = userInputInt();
        movies.deleteMovie(id);
    }

    private static void updateMovieRating() {
        System.out.println("Enter Movie ID you want to update");
        int id = userInputInt();
        System.out.println("Enter new rating:");
        double rating = userInputDouble();
        movies.updateMovieRating(id, rating);
    }

    private static void updateMovie() {
        System.out.println("Enter Movie ID you want to update");
        int id = userInputInt();
        System.out.println("enter Author firstname:");
        String authorFirstName = scan.nextLine();
        System.out.println("enter Author lastname:");
        String authorLastName = scan.nextLine();
        System.out.println("enter Movie name:");
        String movieName = scan.nextLine();
        System.out.println("enter rating:");
        Double rating = userInputDouble();
        movies.updateMovie(id, authorFirstName, authorLastName, movieName, rating);
    }

    private static void readMovie() {
        int userInput = userInputInt();
        movies.readMovie(userInput);
    }

    private static void createMovie() {
        System.out.println("enter Author firstname:");
        String authorFirstName = scan.nextLine();
        System.out.println("enter Author lastname:");
        String authorLastName = scan.nextLine();
        System.out.println("enter Movie name:");
        String movieName = scan.nextLine();
        System.out.println("enter rating:");
        double rating = userInputDouble();
        movies.createMovie(authorFirstName,authorLastName,movieName,rating);
    }

    private static int userInputInt() {
        while (!scan.hasNextInt()) {
            System.out.println("Input is not a number, please try again..");
            scan.nextLine();
        }
        int number = scan.nextInt();
        scan.nextLine();
        return number;
    }

    private static double userInputDouble() {
        while (!scan.hasNextDouble()) {
            System.out.println("Input is not a number, please try again.");
            scan.nextLine();
        }
        double number = scan.nextDouble();
        scan.nextLine();
        return number;
    }
}