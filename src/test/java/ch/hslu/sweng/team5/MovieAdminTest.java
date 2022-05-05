package ch.hslu.sweng.team5;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;


public class MovieAdminTest {

    MovieAdmin m;
    Movie movie;


    @Before
    public void setUp(){

         m =new MovieAdmin();
         m.getMovieList().clear();
         movie = new Movie("The Hangover");
         m.getMovieList().add(movie);


    }

    @Test
    public void createMovieTest(){

        setUp();;
        Movie movie2 = m.createMovie("Harry Potter");

       // System.out.println(m.getMovieList().get(0).getName());
        //System.out.println(m.getMovieList().get(1).getName());

        assertEquals(movie2, m.getMovieList().get(1));


    }

    @Test

    public void deleteMovieTest(){

        setUp();
        Movie movie2 = m.createMovie("The Gift");

        int lengthBefore = m.getMovieList().size();

        m.deleteMovie(movie2);

        int LengthAfter = m.getMovieList().size();

            assertEquals(lengthBefore , LengthAfter + 1 );


    }


    @Test
    public void editMovieTest(){

         setUp();
         m.editMovie(movie,"Get Out", 4);

         assertEquals("Get Out" , m.getMovieList().get(0).getName());
         assertEquals(4, m.getMovieList().get(0).getBookedSeats());

    }
}
