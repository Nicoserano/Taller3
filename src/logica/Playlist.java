package logica;

import java.util.ArrayList;

public class Playlist {
    String id;
    ArrayList<Song> songs;

    public void addSong(Song song){
        songs.add(song);
    }
    public void removeSong(Song song){
        songs.remove(song);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }
}
