package football;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    FootballTeam gosho;
    @Before
    public void  setUp(){
        gosho = new FootballTeam("Gosho" , 10);
    }

    @Test(expected = NullPointerException.class)
    public void testValidationOfTheNameShouldThrowException(){
        FootballTeam sasho = new FootballTeam("" , 21);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testValidationOfVacantPositionsShouldThrowException(){
        FootballTeam sasho = new FootballTeam("sssss" , -1);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testAddFootballer_ShouldThrowExceptionForFullTeam(){
        multyAddPlayer();
        gosho.addFootballer(new Footballer("a10"));
    }
    @Test
    public void testAddFootballer_ShouldAddCorrectly(){
        gosho.addFootballer(new Footballer("a10"));
        int expectedSize = 1;
        assertEquals(expectedSize , gosho.getCount());
    }
    @Test
    public void testRemoveFootballer_ShouldRemoveCorrectly(){
        gosho.addFootballer(new Footballer("a10"));
        gosho.removeFootballer("a10");
        int expectedSize = 0;
        assertEquals(expectedSize , gosho.getCount());
    }
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFootballer_ShouldThrowExceptionForNoExistingFootballer(){
        gosho.addFootballer(new Footballer("a10"));
        gosho.removeFootballer("a11");
    }
    @Test
    public void testFootballerForSale_ShouldReturnTheCorrectFootballer(){
        Footballer footballer = new Footballer("a1");
        gosho.addFootballer(footballer);
        assertEquals(footballer , gosho.footballerForSale("a1"));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSale_ShouldThrowException(){
        Footballer footballer = new Footballer("a1");
        gosho.addFootballer(footballer);
        assertEquals(footballer , gosho.footballerForSale("a2"));
    }
    @Test
    public void testGetStatistic_ShouldBeIdentical(){
        gosho.addFootballer(new Footballer("a10"));
       String theCorrectOne = "The footballer a10 is in the team Gosho.";
        assertEquals(theCorrectOne , gosho.getStatistics());
    }
    private void multyAddPlayer() {
        for (int i = 0; i < 10 ; i++) {
            gosho.addFootballer(new Footballer(String.format("a%d",i)));
        }
    }

}
