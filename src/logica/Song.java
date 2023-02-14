package logica;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

/**
 * This is the Song class that defines a Song object
 *
 * @author Ronald serrano
 * @author David Bonelo
 */
public class Song {
    private String id;//The id of the song
    private String title;//The title of the song
    protected LocalDate releaseDate;//The date when the song was released
    protected LocalTime duration;//The duration of the song
    private String gender;//The gender of the song
    private String coverPath;//The path of the cover image
    private String description;//A description of the song

    //Constructors

    /**
     * Creates a new Song object with no parameters
     */
    public Song() {
    }

    /**
     * Creates a new Song object with the given parameters
     *
     * @param id          The id of the song
     * @param title       The title of the song
     * @param releaseDate The date when the song was released
     * @param duration    The duration of the song
     * @param gender      The gender of the song
     * @param coverPath   The path of the cover image
     * @param description A description of the song
     */
    public Song(String id, String title, LocalDate releaseDate, LocalTime duration, String gender, String coverPath, String description) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.duration = duration;
        this.coverPath = coverPath;
        this.gender = gender;
        this.description = description;
    }

    //Getters and setters

    /**
     * Gets the id of the song
     *
     * @return The id of the song
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the id of the song
     *
     * @param id The id of the song
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the title of the song
     *
     * @return The title of the song
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the song
     *
     * @param title The title of the song
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the date when the song was released
     *
     * @return The date when the song was released
     */
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the date when the song was released
     *
     * @param releaseDate The date when the song was released
     */
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }


    /**
     * Gets the duration of the song
     *
     * @return The duration of the song
     */
    public LocalTime getDuration() {
        return duration;
    }

    /**
     * Sets the duration of the song
     *
     * @param duration The duration of the song
     */
    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    /**
     * Gets the gender of the song
     *
     * @return The gender of the song
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender of the song
     *
     * @param gender The gender of the song
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the path of the cover image
     *
     * @return The path of the cover image
     */
    public String getCoverPath() {
        return coverPath;
    }

    /**
     * Sets the path of the cover image
     *
     * @param coverPath The path of the cover image
     */
    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    /**
     * Gets a description of the song
     *
     * @return A description of the song
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets a description of the song
     *
     * @param description A description of the song
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Returns a string representation of the Song object
     *
     * @return A string representation of the Song object
     */
    @Override
    public String toString() {
        return "id: " + id + " | title: " + title + " | date: " + releaseDate + " | duration: " + duration + " | gender: " + gender + " | coverPath: " + coverPath + " | description: " + description;
    }

    public static Song createSong() {
        String id = read("Insert the id of the song: ");
        String title = read("Insert the title of the song: ");
        LocalDate releaseDate = LocalDate.parse(read("Insert the release date of the song (YYYY-MM-DD): "));
        LocalTime duration = LocalTime.parse(read("Insert the duration of the song (H:mm:ss): "));
        String gender = read("Insert the gender type of the song: ");
        String coverPath = read("Insert the coverPath type of the song: ");
        String description = read("Insert the description type of the song: ");

        return new Song(id, title, releaseDate, duration, gender, coverPath, description);
    }
    private static String read(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
