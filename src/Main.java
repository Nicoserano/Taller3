import logica.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final MusicLibrary musicLibrary = InitLibrary.loadData();
    private static ArrayList<Song> userList = musicLibrary.getSongs();

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
        userList = songs;
        System.out.println("Music Library:");
        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            System.out.println(i + 1 + " | " + s); // i+1 to start with 1 instead of 0
        }
        System.out.println();

        boolean exit = false;
        while (!exit) {
            int menuChoice = menu("Menu: 1. Add Song | 2. Remove Song | 3. Filter by gender | 4. Filter by year | 5. Sort by duration | 6. Sort by date | 7. Create playlist from this list | 0. Main menu");
            switch (menuChoice) {
                case 1 -> musicLibrary.addSong(Song.createSong()); // TODO: handle creation exception
                case 2 -> {
                    int i = Integer.parseInt(read("Insert the number of the song you want to remove: "));
                    musicLibrary.removeSong(i - 1);
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
//                case 7 -> MusicLibrary.addPlaylist(userList);
                case 0 -> exit = true;
                default -> System.out.println("Unknown menu option");
            }
        }
    }

    private static void showPlaylists(ArrayList<Playlist> playlists) {
        System.out.println("Playlists Library:");
        for (int i = 0; i < playlists.size(); i++) {
            Playlist p = playlists.get(i);
            System.out.println((i + 1) + " | " + p);
        }
        System.out.println();
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