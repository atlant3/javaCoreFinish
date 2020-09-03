public class Time implements Comparable<Time> {
    private int min;
    private int hour;

    public Time() {
    }

    public Time(int hour, int min) {
        this.min = min;
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return " Time " + hour +
                ":" + min;
    }

    public Time addTime(Time time) {
        int nHour = this.hour + time.hour;
        int nMin = this.min + time.min;
        return new Time(nHour, nMin);
    }
    public boolean checkTime(int checkHour, int checkMin) {
        if(checkHour<25 && checkMin<61) {
            return true;
        }
        else return false;
    }

    @Override
    public int compareTo(Time t) {
        if ((this.hour * 60 + this.min) > (t.hour * 60 + t.min))
            return 1;
        else if ((this.hour * 60 + this.min) < (t.hour * 60 + t.min))
            return -1;
        else
            return 0;
    }
}
