package bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookmyshow.Enums.City;

public class MovieController {
    Map<City, List<Movie>> moviesPerCity;
    List<Movie> allMovies;

    MovieController(){
        moviesPerCity = new HashMap<>();
        allMovies = new ArrayList<>();
    }

    void addMovie(City city, Movie movie){
        allMovies.add(movie);

        List<Movie> movies = moviesPerCity.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        moviesPerCity.put(city, movies);
    }

    Movie getMovieByName(String movieName){
        for(Movie movie : allMovies){
            if(movie.getMovieName().equals(movieName)){
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByCity(City city){
        return moviesPerCity.get(city);
    }
}
