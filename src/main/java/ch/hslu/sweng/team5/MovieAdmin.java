package ch.hslu.sweng.team5;

import java.util.ArrayList;

public class MovieAdmin {

    private static ArrayList<Movie> movieList = new ArrayList<>();
    //Non-static arraylist for serialisation
    private ArrayList<Movie> moviesList = new ArrayList<>();

    //Movie variables for timings
    private static Movie movie1pm = new Movie("default name");
    private static Movie movie6pm = new Movie("default name");
    private static Movie movie9pm = new Movie("default name");

    //Static initialisation block to add the default movies to arrayList
//    static{
//        movieList.add(movie1pm);
//        movieList.add(movie6pm);
//        movieList.add(movie9pm);
//    }

    public static Movie createMovie(String movieName){
        Movie newMovie = new Movie(movieName);
        movieList.add(newMovie);
        return newMovie;
    }
    public static void deleteMovie(Movie movie){
        movie.setBookedSeats(0);
        movie.setName("Default name");
        if (movieList.contains(movie)) {
            movieList.remove(movie);
            System.out.println("*** MOVIE SUCCESSFULLY DELETED! ***" + "\n" + "** MOVIE VALUES CHANGED TO DEFAULT **");
        } else {
            System.out.println("*** This movie does not exist. Please add a movie first. ***");
        }
    }
    public static void editMovie(Movie selectedMovie, String newName, int bookedSeats) {
        if (movieList.contains(selectedMovie)) {
            selectedMovie.setName(newName);
            selectedMovie.setBookedSeats(bookedSeats);
            System.out.println("*** MOVIE SUCCESSFULLY EDITED! ***");
        } else {
            System.out.println("*** This movie does not exist. Please add a movie first. ***");
        }
    }

    //Add all movies from the static arraylist to non-static one for serialisation
    public ArrayList<Movie> generateMovieList(){
        //moviesList.addAll(movieList);
        moviesList.add(movie1pm);
        moviesList.add(movie6pm);
        moviesList.add(movie9pm);
        return moviesList;
    }

    public static Movie getMovie1pm() {
        return movie1pm;
    }

    public static void setMovie1pm(Movie movie1pm) {
        MovieAdmin.movie1pm = movie1pm;
    }

    public static Movie getMovie6pm() {
        return movie6pm;
    }

    public static void setMovie6pm(Movie movie6pm) {
        MovieAdmin.movie6pm = movie6pm;
    }

    public static Movie getMovie9pm() {
        return movie9pm;
    }

    public static void setMovie9pm(Movie movie9pm) {
        MovieAdmin.movie9pm = movie9pm;
    }

    public static ArrayList<Movie> getMovieList() {

        return movieList;
    }
    public static void setMovieList(ArrayList<Movie> movieList) {
        MovieAdmin.movieList = movieList;
    }
    public ArrayList<Movie> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(ArrayList<Movie> moviesList) {
        this.moviesList = moviesList;
    }


}
