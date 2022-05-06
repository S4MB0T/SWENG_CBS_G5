package ch.hslu.sweng.team5;

import java.util.Random;

public class Booking implements java.io.Serializable{

    private Movie movie;
    private int seatsBooked;
    private String reference;

    public Booking(Movie movie, int seatsBooked) {
        this.movie = movie;
        this.seatsBooked = seatsBooked;
    }

    public void generateRef() {
        Random random = new Random();
        int i = random.nextInt(10);
        int j = random.nextInt(10);
        int k = random.nextInt(10);
        int l = random.nextInt(10);
        int m = random.nextInt(10);
        int n = random.nextInt(10);
        char c = (char)(random.nextInt(26) + 'a');
        String ref = c + Integer.toString(i) + j + k + l + m + n;
        setReference(ref);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public void setSeatsBooked(int seatsBooked) {
        this.seatsBooked = seatsBooked;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
