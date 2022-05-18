package ch.hslu.sweng.team5;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;


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

    @Test
    public void generateMovieListTest(){

        setUp();
       // Movie movie2 = new Movie("Harry Potter");
        //Movie movie3 = new Movie("Avengers");

        //m.getMovieList().add(movie2);
       // m.getMovieList().add(movie3);

        ArrayList<Movie> movies = m.generateMovieList();


        assertEquals("The Hangover", movies.get(0).getName());
        assertEquals("Harry Potter", movies.get(1).getName());
        assertEquals("Avengers", movies.get(2).getName());







    }
}
