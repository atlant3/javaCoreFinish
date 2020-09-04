import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Set;

/**
 * @version 1.0
 * @autor Maksym Bilozir
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter clock(hour) open Cinema");
        int open = sc.nextInt();
        System.out.println("Please enter clock(hour) close Cinema");
        int close = sc.nextInt();
        Cinema cinema = new Cinema();
        cinema.setOpenTime(new Time(open, 00));
        cinema.setCloseTime(new Time(close, 00));
        System.out.println("Open time:" + cinema.getOpenTime() + " Close time:" + cinema.getCloseTime());
        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println("Today: " + LocalDateTime.now().format(myFormat));
        boolean flag = true;
        while (flag) {
            try {
                nav();
                switch (sc.next()) {
                    case "1":
                        System.out.println("Please enter title movie");
                        String title = sc.next();
                        System.out.println("Please enter year movie");
                        int year = sc.nextInt();
                        System.out.println("Please enter hour duration movie");
                        int hour = sc.nextInt();
                        System.out.println("Please enter min duration movie");
                        int min = sc.nextInt();
                        cinema.addMovie(new Movie(title, new Time(hour, min), year));
                        break;
                    case "2":
                        System.out.println("List all of movies");
                        cinema.showAllMovies();
                        break;
                    case "3":
                        System.out.println("List all of movies");
                        cinema.showAllMovies();
                        System.out.println("Please enter id - Movie");
                        int idMov = sc.nextInt();
                        System.out.println("Please enter start clock(hour)");
                        int startHour = sc.nextInt();
                        System.out.println("Please enter start clock(min)");
                        int startMin = sc.nextInt();

                        System.out.println("Please enter day");
                        String dayStart = sc.next();
                        Seance seance = new Seance(cinema.getMoviesLibrary().get(idMov), new Time(startHour, startMin));
                        cinema.addSeance(seance, dayStart);
                        break;
                    case "4":
                        System.out.println("List all of seances");
                        cinema.showAllSeasons();
                        break;
                    case "5":
                        cinema.showAllMovies();
                        System.out.println("Please enter id Movie remove");
                        int idRemoveMov = sc.nextInt();
                        Movie movie = cinema.getMoviesLibrary().get(idRemoveMov);
                        cinema.removeMovie(movie);
                        cinema.showAllMovies();
                        break;
                    case "6":
                        cinema.showAllSeasons();
                        System.out.println("Please enter day Seance remove");
                        String day = sc.next();
                        cinema.showAllSeasons();
                        System.out.print("Please enter id ");
                        int id = sc.nextInt();
                        Set<Seance> seances = cinema.getSchedules().get(Days.valueOf(day.toUpperCase())).getSeances();
                        int i = 0;
                        for (Seance s : seances) {
                            if (id == i)
                                cinema.removeSeance(s, day);
                        }
                        break;
                    case "7":
                        int k = 0;
                        System.out.println("Please enter day");
                        String daySell = sc.next();
                        Set<Seance> seances1 = cinema.getSchedules().get(Days.valueOf((daySell.toUpperCase()))).getSeances();
                        System.out.println(" ID - " + k + " " + seances1.toString());
                        System.out.println("Please enter id");
                        int r = sc.nextInt();

                        for (Seance s : seances1) {
                            if (k == r) {
                                Schedule schedule2 = new Schedule();
                                schedule2.addSeance(s);
                                System.out.println("Please enter Last Name");
                                String lastName = sc.next();
                                System.out.println("Please enter First Name");
                                String firstName = sc.next();
                                System.out.println("Please enter age");
                                int age = sc.nextInt();
                                System.out.println("Please enter place");
                                int place = sc.nextInt();
                                cinema.sellTicket(new Ticket(schedule2, lastName, firstName, age, place, Days.valueOf(daySell.toUpperCase())));
                            }
                            k++;
                        }
                        cinema.showAllTickets();
                        break;
                    case "8":
                        cinema.showAllTickets();
                        break;
                    case "9":
                        System.out.println("remove a ticket");
                        cinema.showAllTickets();
                        System.out.println("Please enter id ticket");
                        int t = sc.nextInt();
                        cinema.removeTicket(t);
                        cinema.showAllTickets();
                        break;
                    case "0":
                        System.out.println("Good bye");
                        System.exit(0);

                }
            } catch (Exception ex) {
                System.out.println(ex);
                System.out.println("Error");
            }
        }
    }


    public static void nav() {
        System.out.println("Please enter 1 - Add a new Movie");
        System.out.println("Please enter 2 - Show all Movies");
        System.out.println("Please enter 3 - Add a new Seance");
        System.out.println("Please enter 4 - Show all Seances");
        System.out.println("Please enter 5 - Remove a Movie");
        System.out.println("Please enter 6 - Remove a Seance");
        System.out.println("Please enter 7 - Sell a new ticket");
        System.out.println("Please enter 8 - Show all tickets");
        System.out.println("Please enter 9 - Delete ticket");
        System.out.println("Please enter 0 - exit");

    }
}
