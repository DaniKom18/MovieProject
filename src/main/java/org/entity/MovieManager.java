package org.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.stream.Stream;


public class MovieManager {
    private HashMap<Integer, Movie>mMovieManager = new HashMap<>();
    private final String jsonFile = "src/main/java/org/data/movie.json";
    public void createMovie(String aAuthorFirstName, String aAuthorLastName, String aMovieName, Double aRating){

        Movie movie = new Movie(aAuthorFirstName,aAuthorLastName, aMovieName, aRating);
        mMovieManager.put(movie.getmId(), movie);
        try {
            jsonWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Created Movie:");
        System.out.println("-".repeat(15));
        System.out.println(movie);
    }
    public void readMovie(int aId){
        Movie movie = mMovieManager.get(aId);
        if (movie == null) throw new NoSuchElementException();
        System.out.println(mMovieManager.get(aId).toString());
    }
    public void readAllMovie(){
        System.out.println(mMovieManager.toString());
    }
    public void updateMovie(int aId, String aAuthorFirstName, String aAuthorLastName, String aMovieName, Double aRating){
        Movie movie = mMovieManager.get(aId);
        System.out.println("updated Movie");
        System.out.println(movie);
        if (movie == null) throw new NoSuchElementException();
        movie.update(aAuthorFirstName,aAuthorLastName,aMovieName,aRating);
        System.out.println("to");
        System.out.println(movie);
    }

    public void updateMovieRating(int aId, Double aRating){
        Movie movie = mMovieManager.get(aId);
        System.out.println("Updated Movie rating from:");
        System.out.println(movie);
        if (movie == null) throw new NoSuchElementException();
        movie.updateRating(aRating);
        System.out.println("to");
        System.out.println(movie);
    }
    public void deleteMovie(int aId){
        Movie movie = mMovieManager.get(aId);
        if (movie == null) throw new NoSuchElementException();
        mMovieManager.remove(aId);
        System.out.println("Removed");
        System.out.println(movie);
    }

    private void jsonWriter() throws IOException {
        try {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Writer writer = new FileWriter(jsonFile);
            gson.toJson(mMovieManager.values(), writer);
            writer.close();
        }
        catch (Exception e){
            System.out.println("File Not Found");
        }

    }

    public void  jsonReader(){
        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(jsonFile));
            //Takes the JSON File and creates an Array where all MOVIES are stored
            Movie [] aMovies = gson.fromJson(reader, Movie[].class);
            //Iterate through Array to get a Movie
            for (int i = 0; i < aMovies.length; i++) {
                //Use the createMovie Methode because otherwise the Automated ID will not be initialized right
                //Other way would be to set the var from Movie {sNextId = aMovies.length()} would be less code
                //but sNextId would need to be public for that.
                createMovie(aMovies[i].getmAuthor().getmFirstName(),
                        aMovies[i].getmAuthor().getmLastName(),
                        aMovies[i].getmMovieName(),
                        aMovies[i].getmRating());
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
