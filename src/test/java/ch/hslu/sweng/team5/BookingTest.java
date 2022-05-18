package ch.hslu.sweng.team5;

import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

public class BookingTest {

    private Booking booking;

    @Before
    public void setUp() {

        booking = new Booking(new Movie("Doctor Strange"), 2);

    }


    @Test
   public void generateRefTest(){
        booking.generateRef();


    }

}


