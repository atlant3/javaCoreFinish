/**
 * @version 1.0
 * @autor Maksym Bilozir
 */

public class Ticket {
    private Schedule schedule;
    private String lastName;
    private String firstName;
    private int age;
    private int place;
    private Days days;

    public Ticket(Schedule schedule, String lastName, String firstName, int age, int place, Days days) {
        this.schedule = schedule;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.place = place;
        this.days = days;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "schedule=" + schedule +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                ", place=" + place +
                ", days=" + days +
                '}';
    }
}
