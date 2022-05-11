package ch.hslu.sweng.team5;


import java.util.Scanner;


import static ch.hslu.sweng.team5.BookingAdmin.*;
import static ch.hslu.sweng.team5.Data.loadData;
import static ch.hslu.sweng.team5.Data.saveData;
import static ch.hslu.sweng.team5.MovieAdmin.*;

public class Menu {
    //private static Console console = new Console();
    private static final Scanner scanner = new Scanner(System.in);

    public static void runMenu(int r){
        if (r == 1) {
                displayMovieProgram();
            } else if (r == 2) {
                displayReservations();
            } else if (r == 3) {
                addMovie();
            } else if (r == 4) {
                deleteMovies();
            } else if (r == 5) {
                editMovies();
            } else if (r == 6) {
                addBooking();
            } else if (r == 7) {
                deleteBookings();
            } else if (r == 8) {
                editBookings();
            } else if (r == 9) {
                savingData();
            } else if (r == 10){
                loadingData();
            } else {
                System.out.println("Please enter a number from the list!");
            }
    }

    public static void displayInfo(){
        System.out.println("[1] Display Movie Program");
        System.out.println("[2] Display Current reservations" + "\n");

        System.out.println("[3] Add movie");
        System.out.println("[4] Delete movie");
        System.out.println("[5] Edit movie" + "\n");

        System.out.println("[6] Add Booking");
        System.out.println("[7] Delete Booking");
        System.out.println("[8] Edit Booking" +"\n");

        System.out.println("[9] Save Data");
        System.out.println("[10] Load Data");
    }

    public static void displayMovieProgram(){
        System.out.println("Time: 1 pm --- Movie: " +getMovie1pm().getName() +" --- Avl Seats: " + (getMovie1pm().getTotalSeats()-getMovie1pm().getBookedSeats()));
        System.out.println("Time: 6 pm --- Movie: " +getMovie6pm().getName() +" --- Avl Seats: " + (getMovie6pm().getTotalSeats()-getMovie6pm().getBookedSeats()));
        System.out.println("Time: 9 pm --- Movie: " +getMovie9pm().getName() +" --- Avl Seats: " + (getMovie9pm().getTotalSeats()-getMovie9pm().getBookedSeats()));
    }
    public static void displayReservations(){
        if (getBookingList().size() <= 0){
            System.out.println("*** THERE ARE NO BOOKINGS CURRENTLY! ***");
        } else {
            for (Booking currBook : getBookingList()) {
                System.out.println("[" + getBookingList().indexOf(currBook) + "]" + "BookingRef: " + currBook.getReference() +
                        "; Movie: " + currBook.getMovie().getName() + "; Seats: " + currBook.getSeatsBooked());
            }
        }
    }

    public static void addMovie(){

        scanner.nextLine();
        System.out.println("Enter Movie name: ");
        String name = scanner.nextLine();
        //createMovie(name);

        System.out.println("Set Movie Time: ");
        System.out.println("[1] 1pm");
        System.out.println("[2] 6pm");
        System.out.println("[3] 9pm" + "\n");
        System.out.println("[0] Exit");

        int result = scanner.nextInt();
        if (result == 1){
            setMovie1pm(createMovie(name));
        } else if (result == 2){
            setMovie6pm(createMovie(name));
        } else if (result == 3){
            setMovie9pm(createMovie(name));
        } else if (result == 0){
            System.out.println("\n"+"----- Exiting menu -----"+"\n");
        }
        System.out.println("*** MOVIE SUCCESSFULLY ADDED! ***");
    }

    public static void deleteMovies(){
        System.out.println("Choose from current movies to delete: ");
        System.out.println("[1] " + getMovie1pm().getName());
        System.out.println("[2] " + getMovie6pm().getName());
        System.out.println("[3] " + getMovie9pm().getName());
        System.out.println("[4] Choose from complete movie list" + "\n");
        System.out.println("[0] Exit");



        int result = scanner.nextInt();
        if (result == 1){
            deleteMovie(getMovie1pm());
            setMovie1pm(new Movie("Default name"));
            //getMovieList().add(getMovie1pm());
            // ^^Was initially added. Not required as movies with name "default name" rather not exist in the list
        } else if (result == 2){
            deleteMovie(getMovie6pm());
            setMovie6pm(new Movie("Default name"));
            //getMovieList().add(getMovie6pm());
        } else if (result == 3){
            deleteMovie(getMovie9pm());
            setMovie9pm(new Movie("Default name"));
            //getMovieList().add(getMovie9pm());
        } else if (result == 4){
            System.out.println("Enter index of movie from list");
            for (Movie currMovie : getMovieList()) {
                if (!currMovie.equals(getMovie1pm()) && !currMovie.equals(getMovie6pm()) && !currMovie.equals(getMovie9pm())) {
                    System.out.println("["+ getMovieList().indexOf(currMovie) + "] " + currMovie.getName());
                }
            }
            deleteMovie(getMovieList().get(scanner.nextInt()));

        } else if (result == 0){
            System.out.println("\n"+"----- Exiting menu -----"+"\n");
        }

    }

    public static void editMovies(){
        System.out.println("Select a movie to edit: ");
        System.out.println("[1] " + getMovie1pm().getName());
        System.out.println("[2] " + getMovie6pm().getName());
        System.out.println("[3] " + getMovie9pm().getName());
        System.out.println("[4] Choose movie from list to edit Movie Program" + "\n");
        System.out.println("[0] Exit");

        String successMessage = "*** MOVIE SUCCESSFULLY EDITED! ***";
        String errorMessage = "*** This movie does not exist. Please add a movie first. ***";

        int result = scanner.nextInt();
        scanner.nextLine();
        if (result == 1){
            if (getMovieList().contains(getMovie1pm())) {
                System.out.println("New name of movie: ");
                String newName = scanner.nextLine();
                System.out.println("New name of movie: " + newName);
                System.out.println("Enter booked tickets (if any): ");
                int seats = scanner.nextInt();
                System.out.println("New seat booking for movie: " + seats);
                editMovie(getMovie1pm(), newName, seats);
                System.out.println(successMessage);
            } else System.out.println(errorMessage);
        } else if (result == 2){
            if (getMovieList().contains(getMovie6pm())) {
                System.out.println("New name of movie: ");
                String newName = scanner.nextLine();
                System.out.println("New name of movie: " + newName);
                System.out.println("Enter booked tickets (if any): ");
                int seats = scanner.nextInt();
                System.out.println("New seat booking for movie: " + seats);
                editMovie(getMovie6pm(), newName, seats);
                System.out.println(successMessage);
            } else System.out.println(errorMessage);
        } else if (result == 3){
            if (getMovieList().contains(getMovie9pm())) {
                System.out.println("New name of movie: ");
                String newName = scanner.nextLine();
                System.out.println("New name of movie: " + newName);
                System.out.println("Enter booked tickets (if any): ");
                int seats = scanner.nextInt();
                System.out.println("New seat booking for movie: " + seats);
                editMovie(getMovie9pm(), newName, seats);
                System.out.println(successMessage);
            } else System.out.println(errorMessage);
        } else if (result == 4){
            System.out.println("Enter index of movie from list");
            for (Movie currMovie : getMovieList()) {
                if (!currMovie.equals(getMovie1pm()) && !currMovie.equals(getMovie6pm()) && !currMovie.equals(getMovie9pm())) {
                    System.out.println("["+ getMovieList().indexOf(currMovie) + "] " + currMovie.getName());
                }
            }
            int r = scanner.nextInt();
            if (r <= getMovieList().size() && getMovieList().size() != 0) {
                Movie currMovie = getMovieList().get(r);
                System.out.println("Select a movie to replace: ");
                System.out.println("[1] " + getMovie1pm().getName());
                System.out.println("[2] " + getMovie6pm().getName());
                System.out.println("[3] " + getMovie9pm().getName() + "\n");
                System.out.println("[0] Exit");

                int r1 = scanner.nextInt();
                if (r1 == 1){
                    setMovie1pm(currMovie);
                    System.out.println(successMessage);
                } else if (r1 == 2){
                    setMovie6pm(currMovie);
                    System.out.println(successMessage);
                } else if (r1 == 3) {
                    setMovie9pm(currMovie);
                    System.out.println(successMessage);
                }
            } else System.out.println(errorMessage);


        } else if (result == 0){
            System.out.println("\n"+"----- Exiting menu -----"+"\n");
        }
    }

    public static void addBooking(){
        System.out.println("Enter number of seats: ");
        int seats = scanner.nextInt();

        System.out.println("Select a movie: ");
        System.out.println("[1] " + getMovie1pm().getName());
        System.out.println("[2] " + getMovie6pm().getName());
        System.out.println("[3] " + getMovie9pm().getName() + "\n");
        System.out.println("[0] Exit");

        int result = scanner.nextInt();
        if (result == 1){
            createBooking(getMovie1pm(), seats);
        } else if (result == 2){
            createBooking(getMovie6pm(), seats);
        } else if (result == 3){
            createBooking(getMovie9pm(), seats);
        } else if (result == 0) {
            System.out.println("\n"+"----- Exiting menu -----"+"\n");
        }
    }

    public static void deleteBookings(){
        if (getBookingList().size() <= 0){
            System.out.println("*** THERE ARE NO BOOKINGS CURRENTLY! ***");
        } else {
            System.out.println("Select booking to delete: " + "\n");
            for (Booking currBook : getBookingList()){
                System.out.println("["+getBookingList().indexOf(currBook)+"]" + "BookingRef: " + currBook.getReference() +
                        "; Movie: " + currBook.getMovie() +"; Seats: " + currBook.getSeatsBooked());
            }
            int result = scanner.nextInt();
            if (result < getBookingList().size()){
                deleteBooking(getBookingList().get(result));
            } else {
                System.out.println("Enter a number within the index");
            }
        }

    }

    public static void editBookings(){
        if (getBookingList().size() <= 0){
            System.out.println("*** THERE ARE NO BOOKINGS CURRENTLY! ***");
        } else {
            System.out.println("Select booking to edit: " + "\n");
            for (Booking currBook : getBookingList()){
                System.out.println("["+getBookingList().indexOf(currBook)+"]" + "BookingRef: " + currBook.getReference() +
                        "; Movie: " + currBook.getMovie().getName() +"; Seats: " + currBook.getSeatsBooked());
            }
            int result = scanner.nextInt();
            if (result < getBookingList().size()){
                Booking currBook = getBookingList().get(result);
                System.out.println("Select a movie: ");
                System.out.println("[1] " + getMovie1pm().getName());
                System.out.println("[2] " + getMovie6pm().getName());
                System.out.println("[3] " + getMovie9pm().getName() + "\n");
                System.out.println("[0] Exit");
                int r = scanner.nextInt();
                System.out.println("Enter new number of seats");
                int s = scanner.nextInt();
                if (r == 1){
                    editBooking(currBook, getMovie1pm(), s);
                } else if (r == 2){
                    editBooking(currBook, getMovie6pm(), s);
                } else if (r == 3){
                    editBooking(currBook, getMovie9pm(), s);
                } else if (r == 0) {
                    System.out.println("\n"+"----- Exiting menu -----"+"\n");
                }

            } else {
                System.out.println("Enter a number within the index");
            }
        }

    }

    public static void savingData(){
        saveData();
        System.out.println("*** DATA SUCCESSFULLY SAVED ***");
    }

    public static void loadingData(){

        loadData();

        System.out.println("*** DATA SUCCESSFULLY LOADED ***");

        System.out.println("Movies in list but not in current program:");

        for (Movie currMovie : getMovieList()) {
            if (!currMovie.equals(getMovie1pm()) && !currMovie.equals(getMovie6pm()) && !currMovie.equals(getMovie9pm())) {
                System.out.println("["+ getMovieList().indexOf(currMovie) + "] " + currMovie.getName());
            }
        }
        System.out.println("\n"+"*** Use -- [5] Edit Movies -- to edit the movie program! ***");
    }


}
