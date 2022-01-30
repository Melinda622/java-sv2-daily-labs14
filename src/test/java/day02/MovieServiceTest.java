package day02;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    List<String> actors= Arrays.asList("Leonardo Dicaprio", "Kate Winslet");
    List<String> actors2= Arrays.asList("Liam Neeson", "Maggie Grace");
    List<String> actors3= Arrays.asList("Michael Keaton", "Kim Basinger");
    Movie batman=new Movie("Batman",120,actors3);
    Movie titanic=new Movie("Titanic",180,actors);
    Movie taken=new Movie("Taken",100,actors2);

    MovieService movieService=new MovieService();




    @Test
    void getTheLengthOfTheLongestMovie(){
        movieService.getMovies().add(batman);
        movieService.getMovies().add(titanic);
        movieService.getMovies().add(taken);
        assertEquals(180,movieService.getTheLengthOfTheLongestMovie());
    }

    @Test
    void getTheLongestMovie(){
        movieService.getMovies().add(batman);
        movieService.getMovies().add(titanic);
        movieService.getMovies().add(taken);
        assertEquals("Titanic",movieService.getTheLongestMovie().getTitle());
    }

    @Test
    void filterMoviesByActor(){
        movieService.getMovies().add(batman);
        movieService.getMovies().add(titanic);
        movieService.getMovies().add(taken);
        assertEquals("Taken",movieService.filterMoviesByActor("Liam Neeson").get(0).getTitle());
        assertEquals(1,movieService.filterMoviesByActor("Liam Neeson").size());
    }
}