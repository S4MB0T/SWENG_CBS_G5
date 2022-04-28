package ch.hslu.sweng.team5;

import java.io.Console;
import java.util.Scanner;


import static ch.hslu.sweng.team5.BookingAdmin.*;
import static ch.hslu.sweng.team5.MovieAdmin.*;

public class User {
    //private static Console console = new Console();
    private static Scanner scanner = new Scanner(System.in);

    public static int displayInfo(){
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

        return scanner.nextInt();
    }

    public static void displayMovieProgram(){
        getMovie1pm().toString();
        getMovie6pm().toString();
        getMovie9pm().toString();
    }
    public static void displayReservations(){
        int i = 0;
        for (Booking currBook : getBookingList()){
            System.out.println("["+i+"]" + "BookingRef: " + currBook.getReference() +
                    "; Movie: " + currBook.getMovie() +"; Seats: " + currBook.getSeatsBooked());
            i++;
        }
    }

    public static void addMovie(){
        System.out.println("Enter Movie name");
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
            displayInfo();
        }
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
        } else if (result == 2){
            deleteMovie(getMovie6pm());
        } else if (result == 3){
            deleteMovie(getMovie9pm());
        } else if (result == 4){
            System.out.println("Enter index of movie from list (starts with 0: )");
            System.out.println(getMovieList());
            deleteMovie(getMovieList().get(scanner.nextInt()));
        } else if (result == 0){
            displayInfo();
        }
    }

    public static void editMovies(){
        System.out.println("Select a movie to edit: ");
        System.out.println("[1] " + getMovie1pm().getName());
        System.out.println("[2] " + getMovie6pm().getName());
        System.out.println("[3] " + getMovie9pm().getName() + "\n");
        System.out.println("[0] Exit");

        int result = scanner.nextInt();
        if (result == 1){
            System.out.println("New name of movie: ");
            String newName = scanner.nextLine();
            System.out.println("Enter booked tickets (if any): ");
            int seats = scanner.nextInt();
            editMovie(getMovie1pm(), newName, seats);
        } else if (result == 2){
            System.out.println("New name of movie: ");
            String newName = scanner.nextLine();
            System.out.println("Enter booked tickets (if any): ");
            int seats = scanner.nextInt();
            editMovie(getMovie6pm(), newName, seats);
        } else if (result == 3){
            System.out.println("New name of movie: ");
            String newName = scanner.nextLine();
            System.out.println("Enter booked tickets (if any): ");
            int seats = scanner.nextInt();
            editMovie(getMovie9pm(), newName, seats);
        } else if (result == 0){
            displayInfo();
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
            displayInfo();
        }
    }

    public static void deleteBookings(){
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

    public static void editBookings(){
        System.out.println("Select booking to edit: " + "\n");
        int i = 0;
        for (Booking currBook : getBookingList()){
            System.out.println("["+i+"]" + "BookingRef: " + currBook.getReference() +
                    "; Movie: " + currBook.getMovie() +"; Seats: " + currBook.getSeatsBooked());
            i++;
        }
        int result = scanner.nextInt();
        if (result < getBookingList().size()){
            Booking currBook = getBookingList().get(result);
            System.out.println("Select a movie: ");
            System.out.println("[1] " + getMovie1pm().getName());
            System.out.println("[2] " + getMovie6pm().getName());
            System.out.println("[3] " + getMovie9pm().getName() + "\n");
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
                displayInfo();
            }

        } else {
            System.out.println("Enter a number within the index");
        }
    }


}
