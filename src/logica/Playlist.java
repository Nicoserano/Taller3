package logica;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing a playlist of songs
 *
 * @author Ronald serrano
 * @author David Bonelo
 */
public class Playlist {
    // Private variables for the id, name  and the list of songs
    private final String id;
    private final ArrayList<Song> songs;
    private final String name;

    // Constructor that initializes the list of songs
    public Playlist(String id, String name, ArrayList<Song> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    // Method to add a song to the list
    public void addSong(Song song) {
        songs.add(song);
    }

    // Method to remove a song from the list
    public void removeSong(Song song) {
        songs.remove(song);
    }

    // Method to get all the songs in the list
    public ArrayList<Song> getSongs() {
        // We make a copy of the list to avoid unintentional modifications
        return new ArrayList<>(songs);
    }

    // Method to get the id of the playlist
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        // Devuelve una cadena de texto que representa el objeto Playlist
        return "id: " + id + " | name: " + name;
    }

    public static Playlist createPlaylist(ArrayList<Song> userList) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert the id of the song: ");
        String id = scanner.nextLine();
        System.out.print("Insert the name of the playlist: ");
        String name = scanner.nextLine();

        return new Playlist(id, name, userList);
    }
}