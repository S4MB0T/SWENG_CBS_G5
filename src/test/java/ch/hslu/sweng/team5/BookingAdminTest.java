package ch.hslu.sweng.team5;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class BookingAdminTest {

private BookingAdmin b;
private Movie movie;
private Movie movie2;
private Booking booking;


@Before
    public void setUp(){
    b = new BookingAdmin();
    b.getBookingList().clear();
    movie = new Movie("Doctor Strange");
    movie2 = new Movie("The Godfather");

    b.createBooking(movie , 10);



}

@Test

public void checkAvailableSeatsTest(){

   boolean x = b.checkAvlSeats( 35, movie);

   assertEquals(false, x);


}
@Test
public void createBookingTest(){

    setUp();
    b.createBooking(movie2, 5);

    Booking booking2 = b.getBookingList().get(1);

    assertEquals(movie2, booking2.getMovie());
    assertEquals(5, booking2.getSeatsBooked());


}

@Test
public void deleteBookingTest(){

    setUp();
    int lengthBefore = b.getBookingList().size();

    b.deleteBooking(booking);

    assertEquals( 0 , lengthBefore - 1);


}


@Test
public void editBookingTest(){

    setUp();

    b.editBooking(b.getBookingList().get(0),movie2,5);


    assertEquals("The Godfather" ,b.getBookingList().get(0).getMovie().getName() );
    assertEquals(5,b.getBookingList().get(0).getSeatsBooked());
}

@Test
    public void generateBookingListTest(){

    setUp();
    b.createBooking(movie2, 5);

    ArrayList<Booking> bookings = b.generateBookingList();

    assertEquals("Doctor Strange", bookings.get(0).getMovie().getName());
    assertEquals(10, bookings.get(0).getMovie().getBookedSeats());
    assertEquals("The Godfather", bookings.get(1).getMovie().getName());
    assertEquals(5, bookings.get(1).getMovie().getBookedSeats());


}
}
