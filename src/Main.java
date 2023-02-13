import logica.InitLibrary;
import logica.MusicLibrary;
import logica.Playlist;
import logica.Song;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicLibrary musicLibrary = InitLibrary.loadData();
        System.out.println("Music Library!");

        boolean exit = false;
        while (!exit) {
            int menuChoice = menu("Menu: 1. Show Library | 2. Show Playlists | 3. Create playlist | 4.  | 5.  | 0. Exit");
            switch (menuChoice) {
                case 1 -> showSongs(musicLibrary.getSongs());
                case 2 -> showPlaylists(musicLibrary.getPlaylists());
//                case 3 -> ;
//                case 4 -> ;
//                case 5 -> ;
                case 0 -> exit = true;
                default -> System.out.println("Unknown menu option");
            }
        }
    }

    private static void showSongs(ArrayList<Song> songs) {
        System.out.println("Music Library:");
        for (int i = 0; i < songs.size(); i++) {
            Song s = songs.get(i);
            System.out.println(i + 1 + " | " + s); // i+1 to start with 1 instead of 0
        }
        System.out.println();
    }

    private static void showPlaylists(ArrayList<Playlist> playlists) {
    }

    private static int menu(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(prompt);
        return scanner.nextInt();
    }
}