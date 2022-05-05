package ch.hslu.sweng.team5;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

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
    booking = new Booking(movie,6);
    b.getBookingList().add(booking);


}

@Test

public void checkAvailableSeatsTest(){

   boolean x = b.checkAvlSeats(10 , movie);

   assertEquals(true, x);


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
    b.editBooking(booking,movie2,5);

    assertEquals("The Godfather" ,booking.getMovie().getName() );
    assertEquals(5,booking.getSeatsBooked());
}

}
