package ch.hslu.sweng.team5;

public class Movie {

    //Name of movie
    private String name;
    //Total number of seats that can be booked (has a default value)
    private int totalSeats;
    //Number of seats booked for the instance
    private int bookedSeats;

    //Constructor
    public Movie(String name) {
        this.name = name;
        this.totalSeats = 40;
        this.bookedSeats = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }
}
