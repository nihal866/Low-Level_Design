package bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bookmyshow.Enums.City;

public class TheaterController {
    Map<City, List<Theater>> theatersPerCity;
    List<Theater> allTheaters;

    TheaterController(){
        theatersPerCity = new HashMap<>();
        allTheaters = new ArrayList<>();
    }

    void addTheater(City city, Theater theater) {
        allTheaters.add(theater);

        List<Theater> theaters = theatersPerCity.getOrDefault(city, new ArrayList<>());
        theaters.add(theater);
        theatersPerCity.put(city, theaters);
    }

    Map<Theater, List<Show>> getAllShows(Movie movie, City city){
        Map<Theater, List<Show>> shows = new HashMap<>();
        List<Theater> theaters = theatersPerCity.get(city);
        for(Theater theater : theaters){
            List<Show> showsPerTheater = new ArrayList<>();
            for(Show show : theater.getShows()){
                if(show.getMovie().equals(movie)){
                    showsPerTheater.add(show);
                }
            }
            shows.put(theater, showsPerTheater);
        }
        return shows;
    }
}
