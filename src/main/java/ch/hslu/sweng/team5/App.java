package ch.hslu.sweng.team5;

import java.util.Scanner;

import static ch.hslu.sweng.team5.User.*;

public class App 
{
    public static void main( String[] args ) {
        System.out.println("----- Welcome to the Cinema Booking System! -----");
        displayInfo();

        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();

        if (r == 1){
            displayMovieProgram();
        } else if (r == 2){
            displayReservations();
        } else if (r == 3){
            addMovie();
        } else if (r == 4){
            deleteMovies();
        } else if (r == 5){
            editMovies();
        } else if (r == 6){
            addBooking();
        } else if (r == 7){
            deleteBookings();
        } else if (r == 8){
            editBookings();
        } else if (r == 9 || r == 10){
            System.out.println("Data save/load feature coming soon!");
        } else {
            System.out.println("Please enter a lumber from the list!");
        }


    }
}
