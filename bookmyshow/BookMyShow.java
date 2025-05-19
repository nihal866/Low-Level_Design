package bookmyshow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import bookmyshow.Enums.City;
import bookmyshow.Enums.SeatCategory;

public class BookMyShow {
    MovieController movieController;
    TheaterController theaterController;

    BookMyShow() {
        movieController = new MovieController();
        theaterController = new TheaterController();
    }

    public static void main(String args[]) {
        BookMyShow app = new BookMyShow();
        app.initialize();

        // user is in bangalore and want to watch avengers movie
        app.createBooking(City.BANGALORE, "AVENGERS");

        app.createBooking(City.BANGALORE, "AVENGERS");
    }

    private void createBooking(City city, String movieName){
        // serach all movies for that city
        List<Movie> movies = movieController.getMoviesByCity(city);

        // find the interested movie there
        Movie interestedMovie = null;
        for(Movie movie : movies){
            if(movie.getMovieName().equals(movieName)){
                interestedMovie = movie;
                break;
            }
        }

        // find the theaters/shows for that movie
        Map<Theater, List<Show>> shows = theaterController.getAllShows(interestedMovie, city);

        // user selects the particular show
        Map.Entry<Theater, List<Show>> entry = shows.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestShow = runningShows.get(0);

        //user selects the seat
        int seatNumber = 2;
        List<Integer> seatsForInterestedShow = interestShow.getBookedSeats();
        if(!seatsForInterestedShow.contains(seatNumber)){
            seatsForInterestedShow.add(seatNumber);

            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat seat : interestShow.getScreen().getSeats()){
                if(seat.getSeatId() == seatNumber){
                    myBookedSeats.add(seat);
                }
            }
            booking.setBookedSeats(myBookedSeats);
            booking.setShow(interestShow);
        } else {
            System.out.println("Seat already booked, please try again...");
            return;
        }
        System.out.println("Booking Successfull!!!");
    }

    private void createMovies() {
        Movie avengers = new Movie();
        avengers.setMovieId(1);
        avengers.setMovieDuration(128);
        avengers.setMovieName("AVENGERS");

        Movie golmaal = new Movie();
        golmaal.setMovieDuration(127);
        golmaal.setMovieId(2);
        golmaal.setMovieName("GOLMAAL");

        Movie raazi = new Movie();
        raazi.setMovieDuration(117);
        raazi.setMovieId(3);
        raazi.setMovieName("RAAZI");

        movieController.addMovie(City.BANGALORE, raazi);
        movieController.addMovie(City.KANPUR, raazi);
        movieController.addMovie(City.GUWAHATI, raazi);

        movieController.addMovie(City.BANGALORE, golmaal);
        movieController.addMovie(City.KANPUR, golmaal);

        movieController.addMovie(City.BANGALORE, avengers);
        movieController.addMovie(City.GUWAHATI, avengers);
    }

    private List<Seat> createSeats(){
        List<Seat> seats = new ArrayList<>();

        Seat seat1 = new Seat();
        seat1.setCategory(SeatCategory.CLASSIC);
        seat1.setPrice(200);
        seat1.setSeatId(1);

        Seat seat2 = new Seat();
        seat2.setCategory(SeatCategory.PLATINUM);
        seat2.setPrice(500);
        seat2.setSeatId(2);

        seats.add(seat1);
        seats.add(seat2);

        return seats;
    }

    private List<Screen> createScreens(){
        List<Screen> screens = new ArrayList<>();
        
        Screen screen1 = new Screen();
        screen1.setScreenId(1);
        screen1.setSeats(createSeats());
        
        screens.add(screen1);
        return screens;
    }

    private Show createShow(int startTime, Movie movie, Screen screen, int showId){
        Show show = new Show();
        show.setStartTime(startTime);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setShowId(showId);
        return show;
    }

    private void createTheaters() {
        Movie movie1 = movieController.getMovieByName("AVENGERS");
        Movie movie2 = movieController.getMovieByName("GOLMAAL");

        Theater inox = new Theater();
        inox.setId(1);
        inox.setScreens(createScreens());
        inox.setAddress("Maheshmati Singhasan k bagal wali kursi");
        inox.setCity(City.BANGALORE);
        List<Show> inoxShows = new ArrayList<>();
        Show eveningInoxShow = createShow(10, movie1, inox.getScreens().get(0), 1);
        Show morningInoxShow = createShow(17, movie2, inox.getScreens().get(0), 2);
        inoxShows.add(eveningInoxShow);
        inoxShows.add(morningInoxShow);
        inox.setShows(inoxShows);

        Theater pvr = new Theater();
        pvr.setId(2);
        pvr.setScreens(createScreens());
        pvr.setAddress("Babu rao ka ghar");
        pvr.setCity(City.KANPUR);
        List<Show> pvrShows = new ArrayList<>();
        Show eveningPVRShow = createShow(11, movie1, pvr.getScreens().get(0), 3);
        Show morningPVRShow = createShow(19, movie2, pvr.getScreens().get(0), 4);
        pvrShows.add(morningPVRShow);
        pvrShows.add(eveningPVRShow);
        pvr.setShows(pvrShows);

        theaterController.addTheater(City.BANGALORE, inox);
        theaterController.addTheater(City.KANPUR, pvr);
    }

    private void initialize() {
        createMovies();
        createTheaters();
    }
}
