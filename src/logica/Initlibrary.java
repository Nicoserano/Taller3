package logica;
import logica.Song;

import java.time.LocalDate;
import java.time.LocalTime;

public class Initlibrary  {
    Song song1 = new Song("1", "Shape of You", LocalDate.of(2017, 1, 6)
            , LocalTime.of(3, 53), "Pop", "shape_of_you.jpg"
            , "Una de las canciones más populares de Ed Sheeran");
    Song song2 = new Song("2", "Blinding Lights", LocalDate.of(2019, 11, 29)
            , LocalTime.of(4, 2), "Pop", "blinding_lights.jpg"
            , "Canción de The Weeknd que alcanzó el número uno en varios países");
    Song song3 = new Song("3", "Girls Like You", LocalDate.of(2018, 5, 30)
            , LocalTime.of(3, 35), "Pop", "girls_like_you.jpg"
            ,"Canción de Maroon 5 con la colaboración de Cardi B");
    Song song4 = new Song("4", "Sugar", LocalDate.of(2014, 1, 12)
            , LocalTime.of(3, 56), "Pop", "sugar.jpg"
            , "Canción de Maroon 5 que alcanzó el número dos en el Billboard Hot 100");
    Song song5 = new Song("5", "See You Again", LocalDate.of(2015, 3, 10)
            , LocalTime.of(3, 49), "Pop", "see_you_again.jpg"
            , "Canción de Wiz Khalifa y Charlie Puth que rinde homenaje a Paul Walker");
    Song song6 = new Song("6", "Uptown Funk", LocalDate.of(2014, 11, 10)
            , LocalTime.of(4, 31), "Funk", "uptown_funk.jpg"
            , "Canción de Mark Ronson y Bruno Mars que alcanzó el número uno en varios países");
    Song song7 = new Song("7", "Thriller", LocalDate.of(1982, 11, 30)
            , LocalTime.of(5, 57), "Pop", "thriller.jpg"
            , "Canción de Michael Jackson que se convirtió en una de las canciones más populares de todos los tiempos");
    Song song8 = new Song("8", "Billie Jean", LocalDate.of(1983, 1, 2)
            , LocalTime.of(4, 54), "Pop", "billie_jean.jpg"
            , "Otra canción de Michael Jackson que se convirtió en un éxito mundial");
    Song song9 = new Song("9", "Bohemian Rhapsody", LocalDate.of(1975, 10, 31)
            , LocalTime.of(5, 55), "Rock", "bohemian_rhapsody.jpg"
            , "Canción de Queen que se convirtió en uno de los himnos del rock más famosos de todos los tiempos");
    Song song10 = new Song("10", "Stairway to Heaven", LocalDate.of(1971, 11, 8)
            , LocalTime.of(8, 2), "Rock", "stairway_to_heaven.jpg"
            , "Canción de Led Zeppelin que es considerada como una de las mejores canciones");

}
