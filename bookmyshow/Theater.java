package bookmyshow;

import java.util.ArrayList;
import java.util.List;

import bookmyshow.Enums.City;

public class Theater {
    int id;
    String address;
    City city;
    List<Screen> screens = new ArrayList<>();
    List<Show> shows = new ArrayList<>();

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public City getCity() {
        return city;
    }
    public void setCity(City city) {
        this.city = city;
    }
    public List<Screen> getScreens() {
        return screens;
    }
    public void setScreens(List<Screen> screens) {
        this.screens = screens;
    }
    public List<Show> getShows() {
        return shows;
    }
    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
