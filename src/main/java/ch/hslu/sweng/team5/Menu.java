package ch.hslu.sweng.team5;

import java.util.Scanner;


import static ch.hslu.sweng.team5.BookingAdmin.*;
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
            } else if (r == 9 || r == 10) {
                System.out.println("Data save/load feature coming soon!");
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
        System.out.println("[10] Reset Data");
    }

    public static void displayMovieProgram(){
        System.out.println("Time: 1 pm --- Movie: " +getMovie1pm().getName());
        System.out.println("Time: 6 pm --- Movie: " +getMovie6pm().getName());
        System.out.println("Time: 9 pm --- Movie: " +getMovie9pm().getName());
    }
    public static void displayReservations(){
        if (getBookingList().size() <= 0){
            System.out.println("*** THERE ARE NO BOOKINGS CURRENTLY! ***");
        } else {
            int i = 0;
            for (Booking currBook : getBookingList()) {
                System.out.println("[" + i + "]" + "BookingRef: " + currBook.getReference() +
                        "; Movie: " + currBook.getMovie().getName() + "; Seats: " + currBook.getSeatsBooked());
                i++;
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
            getMovieList().add(getMovie1pm());
        } else if (result == 2){
            deleteMovie(getMovie6pm());
            setMovie6pm(new Movie("Default name"));
            getMovieList().add(getMovie6pm());
        } else if (result == 3){
            deleteMovie(getMovie9pm());
            setMovie9pm(new Movie("Default name"));
            getMovieList().add(getMovie9pm());
        } else if (result == 4){
            System.out.println("Enter index of movie from list");
            for (Movie currMovie : getMovieList()) {
                if (!currMovie.equals(getMovie1pm()) && !currMovie.equals(getMovie6pm()) && !currMovie.equals(getMovie9pm())) {
                    System.out.println("["+ getMovieList().indexOf(currMovie) + "] " + currMovie.getName());
                }
            }
            deleteMovie(getMovieList().get(scanner.nextInt()));
            if (getMovie1pm() == null){
                setMovie1pm(new Movie("Default name"));
                getMovieList().add(getMovie1pm());
            } else if (getMovie6pm() == null){
                setMovie6pm(new Movie("Default name"));
                getMovieList().add(getMovie6pm());
            } else if (getMovie9pm() == null){
                setMovie9pm(new Movie("Default name"));
                getMovieList().add(getMovie9pm());
            }
        } else if (result == 0){
            System.out.println("\n"+"----- Exiting menu -----"+"\n");
        }
        System.out.println("*** MOVIE SUCCESSFULLY DELETED! ***" + "\n" + "** ALL VALUES CHANGED TO DEFAULT **");
    }

    public static void editMovies(){
        System.out.println("Select a movie to edit: ");
        System.out.println("[1] " + getMovie1pm().getName());
        System.out.println("[2] " + getMovie6pm().getName());
        System.out.println("[3] " + getMovie9pm().getName() + "\n");
        System.out.println("[0] Exit");

        int result = scanner.nextInt();
        scanner.nextLine();
        if (result == 1){
            System.out.println("New name of movie: ");
            String newName = scanner.nextLine();
            System.out.println("New name of movie: " + newName);
            System.out.println("Enter booked tickets (if any): ");
            int seats = scanner.nextInt();
            System.out.println("New seat booking for movie: " +seats);
            editMovie(getMovie1pm(), newName, seats);
        } else if (result == 2){
            System.out.println("New name of movie: ");
            String newName = scanner.nextLine();
            System.out.println("New name of movie: " + newName);
            System.out.println("Enter booked tickets (if any): ");
            int seats = scanner.nextInt();
            System.out.println("New seat booking for movie: " +seats);
            editMovie(getMovie6pm(), newName, seats);
        } else if (result == 3){
            System.out.println("New name of movie: ");
            String newName = scanner.nextLine();
            System.out.println("New name of movie: " + newName);
            System.out.println("Enter booked tickets (if any): ");
            int seats = scanner.nextInt();
            System.out.println("New seat booking for movie: " +seats);
            editMovie(getMovie9pm(), newName, seats);
        } else if (result == 0){
            System.out.println("\n"+"----- Exiting menu -----"+"\n");
        }
        System.out.println("*** MOVIE SUCCESSFULLY EDITED! ***");
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
        System.out.println("*** BOOKING SUCCESSFULLY ADDED! ***");
    }

    public static void deleteBookings(){
        if (getBookingList().size() <= 0){
            System.out.println("*** THERE ARE NO BOOKINGS CURRENTLY! ***");
        } else {
            System.out.println("Select booking to delete: " + "\n");
            int i = 0;
            for (Booking currBook : getBookingList()){
                System.out.println("["+i+"]" + "BookingRef: " + currBook.getReference() +
                        "; Movie: " + currBook.getMovie() +"; Seats: " + currBook.getSeatsBooked());
                i++;
            }
            int result = scanner.nextInt();
            if (result < getBookingList().size()){
                deleteBooking(getBookingList().get(result));
            } else {
                System.out.println("Enter a number within the index");
            }
        }
        System.out.println("*** MOVIE SUCCESSFULLY DELETED! ***");
    }

    public static void editBookings(){
        if (getBookingList().size() <= 0){
            System.out.println("*** THERE ARE NO BOOKINGS CURRENTLY! ***");
        } else {
            System.out.println("Select booking to edit: " + "\n");
            int i = 0;
            for (Booking currBook : getBookingList()){
                System.out.println("["+i+"]" + "BookingRef: " + currBook.getReference() +
                        "; Movie: " + currBook.getMovie().getName() +"; Seats: " + currBook.getSeatsBooked());
                i++;
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


}
