import logica.*;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * Class where the main execution begins and contains the logic to show the menus to the user.
 *
 * @author Ronald serrano
 * @author David Bonelo
 * */
public class Main {
    // static variable to hold the library data, calls the load of initial data
    private static final MusicLibrary musicLibrary = InitLibrary.loadData();

    public static void main(String[] args) {

        System.out.println("Music Library!");

        // Infinite loop for the main menu that asks the user to input their option choice
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


    /**
     * Prints the list of songs and its attributes, then, shows options to use with the list.
     * @param songs list of songs to show
     */
    private static void showSongs(ArrayList<Song> songs) {
        System.out.println("List of songs:");
        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            System.out.println(i + 1 + " | " + s); // i+1 to start with 1 instead of 0
        }
        System.out.println();


        int menuChoice = menu("Menu: 1. Add Song | 2. Remove Song | 3. Filter by gender | 4. Filter by year " + "| 5. Sort by duration | 6. Sort by date | 7. Create playlist from this list | 0. Main menu");
        switch (menuChoice) {
            case 1 -> musicLibrary.addSong(Song.createSong());
            case 2 -> {
                int indexToRemove = Integer.parseInt(read("Insert the number of the song you want to remove: ")) - 1; // -1 because user indexes start from 1
                // IndexOutOfBounds handling
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

    /**
     * Prints the list of playlists and its attributes, then, shows options to use with the list.
     * @param playlists list of playlists to show
     */
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
                // IndexOutOfBounds handling
                int playlistSize = musicLibrary.getPlaylists().size();
                if ((playlistIndex > playlistSize || playlistIndex < 0)) {
                    System.out.println("Incorrect index " + (playlistIndex + 1));
                } else {
                    showSongs(musicLibrary.getPlaylists().get(playlistIndex).getSongs());
                }
            }
            case 2 -> {
                int playlistIndex = Integer.parseInt(read("Insert the number of the playlist to remove: ")) - 1;
                // IndexOutOfBounds handling
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

    /**
     * Simple method to show a prompt and read an integer from std
     * @param prompt a string to show in stdout
     * @return an Integer read from stdin.
     */
    private static int menu(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        // Invalid integer handling
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); // clear invalid input
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // clear buffer
        return input;
    }

    /**
     * Simple method to show a prompt and read a string from std
     * @param prompt a string to show in stdout
     * @return a String read from stdin
     */
    private static String read(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        // Invalid input handling
        while (input.isEmpty()) {
            System.out.println("Invalid input. Please enter a non-empty string.");
            System.out.print(prompt);
            input = scanner.nextLine().trim();
        }
        return input;
    }}