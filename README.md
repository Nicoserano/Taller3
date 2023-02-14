# Taller3
Taller3 Cantera nivel 2
This is a Java program that models a music library, where users can add and remove songs and create playlists. 
The program shows a menu to the user with several options to manage the library, such as adding or removing songs, 
filtering and sorting songs, or creating and removing playlists.

The program uses the following classes:

Main: The main class where the program starts and contains the logic to show the menus to the user.

InitLibrary: A utility class to load the initial data of the library from a file.

MusicLibrary: A class that represents the music library, contains a list of songs and playlists, and provides methods to
manipulate them.

Song: A class that represents a song, with attributes such as title, artist, gender, year, duration, and date added.

Playlist: A class that represents a playlist, with a list of songs and a name.
The program uses several helper methods to show prompts and read user input from the console using the Scanner class.

The program also defines two enumeration classes: FilterType and SortType, to represent the types of filters and sorting
used in the program. These are used as arguments in some of the methods of the MusicLibrary class.
