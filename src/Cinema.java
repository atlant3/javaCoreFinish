import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version 1.0
 * @autor Maksym Bilozir
 */

public class Cinema {
    private TreeMap<Days, Schedule> schedules = new TreeMap<>();
    private ArrayList<Movie> moviesLibrary = new ArrayList<>();
    private Time openTime;
    private Time closeTime;
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public Cinema() {
    }


    public TreeMap<Days, Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(TreeMap<Days, Schedule> schedules) {
        this.schedules = schedules;
    }

    public ArrayList<Movie> getMoviesLibrary() {
        return moviesLibrary;
    }


    public Time getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Time openTime) {
        this.openTime = openTime;
    }

    public Time getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Time closeTime) {
        this.closeTime = closeTime;
    }

    public void addMovie(Movie movie) {
        moviesLibrary.add(movie);
    }

    public void addSeance(Seance seance, String dayWeek) {
        boolean checkOpen = checkOpen(seance.getStartTime(), seance.getEndTime());
        if (checkOpen) {
            for (Days day : Days.values()){
                if (day.toString().equalsIgnoreCase(dayWeek)) {
                    Schedule schedule = new Schedule();
                    schedule.addSeance(seance);
                    schedules.put(day, schedule);
                }
            }

        } else System.out.println("Close!!!");

    }

    public void removeMovie(Movie movie) {
        moviesLibrary.remove(movie);
    }

    public void removeSeance(Seance seance, String s) {
        schedules.entrySet().stream().forEach(e -> {
            if (e.getKey().toString().equalsIgnoreCase(s)) {
                e.getValue().removeSeance(seance);
            }
        });
    }

    public void showAllMovies() {
        int i = 0;
        System.out.println("Show list of movies: ");
        for (Movie movie : moviesLibrary) {
            System.out.println("ID " + i + " " + movie);
            i++;
        }
    }

    public void showAllSeasons() {
        for (Map.Entry<Days, Schedule> entry : schedules.entrySet()) {
            Days key = entry.getKey();
            Schedule value = entry.getValue();
            System.out.printf("%s : %s\n", key.toString(), value.toString());
        }

    }

    public void sellTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void showAllTickets() {
        System.out.println("Show all tickets");
        System.out.println(tickets.toString());
    }

    public void removeTicket(int i) {
        tickets.remove(i);
    }

    private boolean checkOpen(Time openC, Time closeC) {
        if (openC.compareTo(openTime) < 0 || closeC.compareTo(closeTime) > 0) {
            return false;
        } else
            return true;
    }

    @Override
    public String toString() {
        return "Cinema{" +
                "schedules=" + schedules +
                ", moviesLibrary=" + moviesLibrary +
                ", openTime=" + openTime +
                ", closeTime=" + closeTime +
                '}';
    }
}
