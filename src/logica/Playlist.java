package logica;

import java.util.ArrayList;

/**
 * Class representing a playlist of songs
 *
 * @author Ronald serrano
 * @author David Bonelo
 * */
public class Playlist {
    // Private variables for the id and the list of songs
    private String id;
    private ArrayList<Song> songs;

    // Constructor that initializes the list of songs
    public Playlist(String id) {
        this.id = id;
        this.songs = new ArrayList<>();
    }

    // Method to add a song to the list
    public void addSong(Song song){
        songs.add(song);
    }

    // Method to remove a song from the list
    public void removeSong(Song song){
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
}