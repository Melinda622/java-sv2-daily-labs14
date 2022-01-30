package day02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public List<Movie> filterMoviesByActor(String actor) {

        return movies.stream().filter(movie -> movie.getActors().contains(actor)).toList();
    }

    public int getTheLengthOfTheLongestMovie() {
        return movies.stream().mapToInt(movie -> movie.getLength()).max().orElseThrow(() -> new IllegalArgumentException("No such element"));
    }

    public Movie getTheLongestMovie() {
        return movies.stream().max(Comparator.comparingInt(Movie::getLength)).orElseThrow(() -> new IllegalArgumentException("No such element"));
    }
}
