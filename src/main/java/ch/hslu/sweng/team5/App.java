package ch.hslu.sweng.team5;

import java.util.Scanner;

import static ch.hslu.sweng.team5.Menu.*;

public class App
{
    public static void main( String[] args ) {
        System.out.println("----- Welcome to the Cinema Booking System! -----");
        //displayInfo();

        Scanner scanner = new Scanner(System.in);
        //int r = scanner.nextInt();

        int r;
        do {
            displayInfo();
            r = scanner.nextInt();
            scanner.nextLine();
            runMenu(r);
            System.out.println("\n" + "----- End of program function -----" + "\n");

        } while (r != 0);


    }
}
