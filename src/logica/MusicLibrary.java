package logica;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MusicLibrary {
    ArrayList<Song> songs = new ArrayList<>(1);
    ArrayList<Playlist> playlists = new ArrayList<>(1);

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public ArrayList<Song> filterSongs(FilterType filterType, String filter) {
        switch (filterType) {
            case GENDER -> {
                return new ArrayList<>(getSongs().stream().filter(s -> s.getGender().equals(filter)).collect(Collectors.toList()));
            }
            case YEAR -> {
                return new ArrayList<>(getSongs().stream().filter(s -> s.date.getYear() == Integer.parseInt(filter)).collect(Collectors.toList()));
            }
            default -> {
                return getSongs();
            }
        }
    }

    public ArrayList<Song> sortSongs(SortType sortType, boolean ascending) {
        return getSongs();
    }
}
