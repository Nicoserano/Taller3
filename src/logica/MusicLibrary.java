package logica;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MusicLibrary {
    private final ArrayList<Song> songs = new ArrayList<>(1);
    private final ArrayList<Playlist> playlists = new ArrayList<>(1);

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public ArrayList<Playlist> getPlaylists() {
        return playlists;
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public void removeSong(int songIndex) {
        if (songIndex < 0 || songIndex >= songs.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + songIndex);
        }
        songs.remove(songIndex);
    }

    public void addPlaylist(Playlist playlist) {
        playlists.add(playlist);
    }

    public void removePlaylist(int playlistIndex) {
        if (playlistIndex < 0 || playlistIndex >= songs.size()) {
            throw new IndexOutOfBoundsException("Invalid index: " + playlistIndex);
        }
        songs.remove(playlistIndex);
    }

    public ArrayList<Song> filterSongs(FilterType filterType, String filter) {
        switch (filterType) {
            case GENDER -> {
                return new ArrayList<>(getSongs().stream().filter(s -> s.getGender().equals(filter)).collect(Collectors.toList()));
            }
            case YEAR -> {
                return new ArrayList<>(getSongs().stream().filter(s -> s.releaseDate.getYear() == Integer.parseInt(filter)).collect(Collectors.toList()));
            }
            default -> {
                return getSongs();
            }
        }
    }

    public ArrayList<Song> sortSongs(SortType sortType, boolean ascending) {
        switch (sortType) {
            case DATE -> {
                getSongs().sort((s1, s2) -> {
                    if (s1.releaseDate == s2.releaseDate) return 0;
                    return (s1.releaseDate.isBefore(s2.releaseDate) ? -1 : 1);
                });
                return getSongs();
            }
            case DURATION -> {
                getSongs().sort((s1, s2) -> {
                    if (s1.duration == s2.duration) return 0;
                    if (ascending) {
                        return (s1.duration.isBefore(s2.duration) ? -1 : 1);
                    } else {
                        return (s1.duration.isBefore(s2.duration) ? 1 : -1);
                    }
                });
                return getSongs();
            }
            default -> {
                return getSongs();
            }
        }
    }
}
