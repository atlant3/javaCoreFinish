public final class Time implements Comparable<Time> {
    private int min;
    private int hour;

    public Time(int hour, int min) {
        checkTime(hour, min);
    }

    public int getMin() {
        return min;
    }


    public int getHour() {
        return hour;
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

    public void checkTime(int checkHour, int checkMin) {
        if (checkHour >= 0) {
            if (checkHour <= 24) {
                this.hour = checkHour;
            } else {
                System.out.println("Error time (hour) - Please retry");
                System.exit(0);
            }

        } else {
            System.out.println("Error time (hour) - Please retry");
            System.exit(0);
        }
        if (checkMin >= 0) {
            if (checkMin <= 60) {
                this.min = checkMin;
            } else {
                System.out.println("Error time (min) - Please retry");
                System.exit(0);
            }

        } else {
            System.out.println("Error time (min) - Please retry");
            System.exit(0);
        }



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
