package ch.hslu.sweng.team5;

import java.util.ArrayList;

public class BookingAdmin {
    private static final ArrayList<Booking> bookingList = new ArrayList<>();
    //Non-static arraylist for serialisation
    private ArrayList<Booking> bookingsList = new ArrayList<>();

    public static void setBookedSeats(int seats, Movie movie){
        movie.setBookedSeats(seats + movie.getBookedSeats());
    }
    public static boolean checkAvlSeats(int seats, Movie movie){
        boolean k;
        k = seats <= (movie.getTotalSeats() - movie.getBookedSeats());
        return k;
    }

    public static void createBooking(Movie movie, int seatsBooked){
        if(checkAvlSeats(seatsBooked, movie)) {
            Booking newBooking = new Booking(movie, seatsBooked);
            newBooking.generateRef();
            bookingList.add(newBooking);
            setBookedSeats(seatsBooked, movie);
        }else{
            System.out.println("Error in booking");
        }
    }

    public static void deleteBooking(Booking booking){
        if (bookingList.contains(booking)) {
            bookingList.remove(booking);
            setBookedSeats((-booking.getSeatsBooked()), booking.getMovie());
        } else {
            System.out.println("The booking does not exist");
        }
    }

    public static void editBooking(Booking selectedBooking, Movie newMovie, int newBookedSeats) {
        if (bookingList.contains(selectedBooking)) {

            if(checkAvlSeats(newBookedSeats, newMovie)) {
                selectedBooking.setMovie(newMovie);
                selectedBooking.setSeatsBooked(newBookedSeats);
            } else{
                System.out.println("Error in booking");
            }

        } else {
            System.out.println("The booking does not exist");
        }
    }

    public ArrayList<Booking> generateBookingList(){
        bookingsList.addAll(bookingList);
        return bookingsList;
    }

    public static ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public ArrayList<Booking> getBookingsList() {
        return bookingsList;
    }

    public void setBookingsList(ArrayList<Booking> bookingsList) {
        this.bookingsList = bookingsList;
    }
}
