public class Time {
    private int hour;
    private int minute;
    private int second;

    Time() {
        this.hour = 0;
        this.minute = 0;
        this.second = 0;
    }

    Time(int newHour, int newMinute, int newSecond) {
        this.hour = newHour;
        this.minute = newMinute;
        this.second = newSecond;
    }

    public void increment(int seconds) {
        while (seconds >= 3600) {
            seconds -= 3600;
            if (this.hour == 23) {
                this.hour = 0;
            } else {
                this.hour++;
            }
        }
        while (seconds >= 60) {
            seconds -= 60;
            if (this.minute == 59) {
                this.minute = 0;
                this.hour++;
            } else {
                this.minute++;
            }
        }
        while (seconds > 0) {
            seconds--;
            if (this.second == 59) {
                this.second = 0;
                if (this.minute == 59) {
                    this.minute = 0;
                    this.hour++;
                } else {
                    this.minute++;
                }
            } else {
                this.second++;
            }
        }
    }

    public void print(boolean military) {
        String newHour;
        String newMinute;
        String newSecond;
        boolean isPM = false;
        if (military) {
            if (this.hour < 10) {
                newHour = "0" + this.hour;
            } else {
                newHour = String.valueOf(this.hour);
            }
            if (this.minute < 10) {
                newMinute = "0" + this.minute;
            } else {
                newMinute = String.valueOf(minute);
            }
            if (this.second < 10) {
                newSecond = "0" + this.second;
            } else {
                newSecond = String.valueOf(this.second);
            }
            System.out.println(newHour + ":" + newMinute + ":" + newSecond);
        } else {
            if (this.hour > 12) {
                this.hour -= 12;
                isPM = true;
            }
            if (this.hour < 10) {
                newHour = "0" + this.hour;
            } else {
                newHour = String.valueOf(this.hour);
            }
            if (this.minute < 10) {
                newMinute = "0" + this.minute;
            } else {
                newMinute = String.valueOf(this.minute);
            }
            if (this.second < 10) {
                newSecond = "0" + this.second;
            } else {
                newSecond = String.valueOf(this.second);
            }
            if (isPM) {
                System.out.println(newHour + ":" + newMinute + ":" + newSecond + " PM");
                this.hour += 12;
            } else {
                System.out.println(newHour + ":" + newMinute + ":" + newSecond + " AM");
            }
        }
    }

    public static Time fromString(String timeString) {
        String[] split = timeString.split(":");
        return new Time(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
    }
}
