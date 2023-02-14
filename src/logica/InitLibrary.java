package logica;

import java.time.LocalDate;
import java.time.LocalTime;
/**
 * This class is responsible for initializing the MusicLibrary with some sample data.
 * 
 * @author Ronald serrano
 * @author David Bonelo
 * */
public class InitLibrary {

    // A static method to initialize and return a MusicLibrary object with some pre-defined Song objects
    public static MusicLibrary loadData() {
        MusicLibrary myLibrary = new MusicLibrary();// Create a new MusicLibrary object

        /*
         Add some pre-defined Song objects to the library using the addSong() method of MusicLibrary
         Each Song object is created with its unique ID, title, release date, duration, genre
         ,image filename, and description
        */
        myLibrary.addSong(new Song("1", "Shape of You", LocalDate.of(2017, 1, 6)
                , LocalTime.of(3, 53), "Pop", "shape_of_you.jpg"
                , "One of Ed Sheeran's most popular songs"));

        myLibrary.addSong(new Song("2", "Blinding Lights", LocalDate.of(2019, 11, 29)
                , LocalTime.of(4, 2), "Pop", "blinding_lights.jpg"
                , "A song by The Weeknd that reached number one in several countries"));

        myLibrary.addSong(new Song("3", "Girls Like You", LocalDate.of(2018, 5, 30)
                , LocalTime.of(3, 35), "Pop", "girls_like_you.jpg"
                , "A song by Maroon 5 featuring Cardi B"));

        myLibrary.addSong(new Song("4", "Sugar", LocalDate.of(2014, 1, 12)
                , LocalTime.of(3, 56), "Pop", "sugar.jpg"
                , "A song by Maroon 5 that reached number two on the Billboard Hot 100"));

        myLibrary.addSong(new Song("5", "See You Again", LocalDate.of(2015, 3, 10)
                , LocalTime.of(3, 49), "Pop", "see_you_again.jpg"
                , "A song by Wiz Khalifa and Charlie Puth that pays tribute to Paul Walker"));

        myLibrary.addSong(new Song("6", "Uptown Funk", LocalDate.of(2014, 11, 10)
                , LocalTime.of(4, 31), "Funk", "uptown_funk.jpg"
                , "A song by Mark Ronson and Bruno Mars that reached number one in several countries"));

        myLibrary.addSong(new Song("7", "Thriller", LocalDate.of(1982, 11, 30)
                , LocalTime.of(5, 57), "Pop", "thriller.jpg"
                , "A song by Michael Jackson that became one of the most popular songs of all time"));

        myLibrary.addSong(new Song("8", "Billie Jean", LocalDate.of(1983, 1, 2)
                , LocalTime.of(4, 54), "Pop", "billie_jean.jpg"
                , "Another song by Michael Jackson that became a worldwide hit"));

        myLibrary.addSong(new Song("9", "Bohemian Rhapsody", LocalDate.of(1975, 10, 31)
                , LocalTime.of(5, 55), "Rock", "bohemian_rhapsody.jpg"
                , "A song by Queen that became one of the most famous rock anthems of all time"));

        myLibrary.addSong(new Song("10", "Stairway to Heaven", LocalDate.of(1971, 11, 8)
                , LocalTime.of(8, 2), "Rock", "stairway_to_heaven.jpg"
                , "A song by Led Zeppelin that is considered one of the greatest songs of all time"));

        return myLibrary;// Return the MusicLibrary object
    }
}
