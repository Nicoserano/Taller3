import logica.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final MusicLibrary musicLibrary = InitLibrary.loadData();

    public static void main(String[] args) {

        System.out.println("Music Library!");

        boolean exit = false;
        while (!exit) {
            int menuChoice = menu("Menu: 1. Show Songs Library | 2. Show Playlists | 0. Exit");
            switch (menuChoice) {
                case 1 -> showSongs(musicLibrary.getSongs());
                case 2 -> showPlaylists(musicLibrary.getPlaylists());
                case 0 -> exit = true;
                default -> System.out.println("Unknown menu option");
            }
        }
    }

    private static void showSongs(ArrayList<Song> songs) {
        System.out.println("List of songs:");
        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            System.out.println(i + 1 + " | " + s); // i+1 to start with 1 instead of 0
        }
        System.out.println();


        int menuChoice = menu("Menu: 1. Add Song | 2. Remove Song | 3. Filter by gender | 4. Filter by year " + "| 5. Sort by duration | 6. Sort by date | 7. Create playlist from this list | 9. Main menu");
        switch (menuChoice) {
            case 1 -> musicLibrary.addSong(Song.createSong());
            case 2 -> {
                int indexToRemove = Integer.parseInt(read("Insert the number of the song you want to remove: ")) - 1;
                try {
                    musicLibrary.removeSong(indexToRemove);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
                showSongs(musicLibrary.getSongs());
            }
            case 3 -> {
                String filterGender = read("Insert the gender you want to filter: ");
                showSongs(musicLibrary.filterSongs(FilterType.GENDER, filterGender));
            }
            case 4 -> {
                String filterYear = read("Insert the year you want to filter: ");
                showSongs(musicLibrary.filterSongs(FilterType.YEAR, filterYear));
            }
            case 5 -> showSongs(musicLibrary.sortSongs(SortType.DURATION, true));
            case 6 -> showSongs(musicLibrary.sortSongs(SortType.DATE, true));
            case 7 -> musicLibrary.addPlaylist(Playlist.createPlaylist(songs));
            case 0 -> System.out.println();

            default -> System.out.println("Unknown menu option");
        }
    }

    private static void showPlaylists(ArrayList<Playlist> playlists) {
        System.out.println("Playlists Library:");
        for (int i = 0; i < playlists.size(); i++) {
            Playlist p = playlists.get(i);
            System.out.println((i + 1) + " | " + p);
        }
        System.out.println();

        int menuChoice = menu("Menu: 1. Select playlist | 2. Remove playlist | 0. Main menu");
        switch (menuChoice) {
            case 1 -> {
                int playlistIndex = Integer.parseInt(read("Insert the number of the playlist to select: ")) - 1;
                showSongs(musicLibrary.getPlaylists().get(playlistIndex).getSongs());
            }
            case 2 -> {
                int playlistIndex = Integer.parseInt(read("Insert the number of the playlist to remove: ")) - 1;
                try {
                    musicLibrary.removePlaylist(playlistIndex);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 0 -> System.out.println();
            default -> System.out.println("Unknown menu option");
        }
    }

    private static int menu(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextInt();
    }

    private static String read(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}