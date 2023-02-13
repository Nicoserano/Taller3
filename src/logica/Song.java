package logica;

import java.time.LocalDate;
import java.time.LocalTime;

public class Song {
    private String id;
    private String title;
    protected LocalDate date;
    protected LocalTime duration;
    private String gender;
    private String coverPath;
    private String description;

    public Song() {
    }

    public Song(String id , String title, LocalDate date, LocalTime duration , String gender,
                String coverPath, String description) {
        this.id = id;
        this.date= date;
        this.duration = duration;
        this.gender = gender;
        this.coverPath = coverPath;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getDuration() {
        return duration;
    }

    public void setDuration(LocalTime duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCoverPath() {
        return coverPath;
    }

    public void setCoverPath(String coverPath) {
        this.coverPath = coverPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
