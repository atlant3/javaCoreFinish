/**
 * @version 1.0
 * @autor Maksym Bilozir
 */

public class Seance implements Comparable<Seance> {
    private Movie movie;
    private Time startTime;
    private Time endTime;

    public Seance(Movie movie, Time startTime) {
        this.movie = movie;
        this.startTime = startTime;
        this.endTime = movie.getDuration().addTime(startTime);
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Seance{" +
                "movie=" + movie +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(Seance s) {
        if (this.startTime.compareTo(startTime) == s.startTime.compareTo(startTime))
            return 0;
        else if (this.startTime.compareTo(startTime) < s.startTime.compareTo(startTime))
            return -1;
        else
            return 1;
    }
}
