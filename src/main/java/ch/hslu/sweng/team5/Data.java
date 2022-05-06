package ch.hslu.sweng.team5;

import java.io.*;
import java.util.ArrayList;

import static ch.hslu.sweng.team5.BookingAdmin.getBookingList;
import static ch.hslu.sweng.team5.MovieAdmin.getMovieList;

public class Data {
    private static MovieAdmin mA = new MovieAdmin();
    private static BookingAdmin bA = new BookingAdmin();

    private static ArrayList<Movie> loadMovies = new ArrayList<>();
    private static ArrayList<Booking> loadBooking = new ArrayList<>();

    public static void saveData(){

        try {
            File saveFile = new File("movies.ser");
            saveFile.createNewFile();
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(saveFile));
            output.writeObject(mA.generateMovieList());
            //output.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

        try {
            File saveFile = new File("bookings.ser");
            saveFile.createNewFile();
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(saveFile));
            output.writeObject(bA.generateBookingList());
            //output.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public static void loadData(){
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("movies.ser"));
            loadMovies = (ArrayList<Movie>) input.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("bookings.ser"));
            loadBooking = (ArrayList<Booking>) input.readObject();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }

        getMovieList().addAll(loadMovies);
        getBookingList().addAll(loadBooking);
    }
}
