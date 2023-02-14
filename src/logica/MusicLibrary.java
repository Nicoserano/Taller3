package logica;

import java.util.ArrayList;
import java.util.stream.Collectors;
/**
 * This class represents a music library, which contains a list of songs and playlists, and provides methods to add
 * , remove, filter, and sort songs.
 *
 * @author Ronald serrano
 * @author David Bonelo
 */
public class MusicLibrary {
    // ArrayList to store songs and playlists
    private final ArrayList<Song> songs = new ArrayList<>(1);
    private final ArrayList<Playlist> playlists = new ArrayList<>(1);

    // Getter methods for songs and playlists
    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    // Method to add a song to the music library
    public void addSong(Song song) {
        songs.add(song);
    }

    // Method to remove a song from the music library
    public void removeSong(int songIndex) {
        // Throw an exception if the index is out of bounds
        if (songIndex < 0 || songIndex >= songs.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + songIndex);
        }
        songs.remove(songIndex);
    }

    // Method to add a playlist to the music library
    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    // Method to remove a playlist from the music library
    public void removePlaylist(int playlistIndex) {
        // Throw an exception if the index is out of bounds
        if (playlistIndex < 0 || playlistIndex >= songs.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + playlistIndex);
        }
        songs.remove(playlistIndex);
    }

    // Method to filter songs by a given filter type and value
    public ArrayList<Song> filterSongs(FilterType filterType, String filter) {
        switch (filterType) {
            // Filter by gender
            case GENDER -> {
                return new ArrayList<>(getSongs().stream().filter(s -> s.getGender().equals(filter)).collect(Collectors.toList()));
            }
            // Filter by year
            case YEAR -> {
                return new ArrayList<>(getSongs().stream().filter(s -> s.releaseDate.getYear() == Integer.parseInt(filter)).collect(Collectors.toList()));
            }
            // Return all songs if no filter type is specified
            default -> {
                return getSongs();
            }
        }
    }

    // Method to sort songs by a given sort type and order
    public ArrayList<Song> sortSongs(SortType sortType, boolean ascending) {
        switch (sortType) {
            // Sort by release date
            case DATE -> {
                // Sort songs by release date using a lambda expression
                getSongs().sort((s1, s2) -> {
                    if (s1.releaseDate == s2.releaseDate) return 0;
                    return (s1.releaseDate.isBefore(s2.releaseDate) ? -1 : 1);
                });
                return getSongs();
            }

            // Sort by duration
            case DURATION -> {
                // Sort songs by duration using a lambda expression
                getSongs().sort((s1, s2) -> {
                    if (s1.duration == s2.duration) return 0;
                    // Sort in ascending order if specified, otherwise sort in descending order
                    if (ascending) {
                        return (s1.duration.isBefore(s2.duration) ? -1 : 1);
                    } else {
                        return (s1.duration.isBefore(s2.duration) ? 1 : -1);
                    }
                });
                return getSongs();
            }
            // Return all songs if no sort type is specified
            default -> {
                return getSongs();
            }
        }
    }
}
