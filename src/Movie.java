/**
 * @version 1.0
 * @autor Maksym Bilozir
 */

public class Movie {
    private String title;
    private Time duration;
    private int year;

    public Movie(String title, Time duration, int year) {
        this.title = title;
        this.duration = duration;
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", year=" + year;
    }
}
