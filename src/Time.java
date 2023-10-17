public class Time {
    private int hour;
    private int minute;
    private int second;
    Time() {
        hour = 0;
        minute = 0;
        second = 0;
    }

    Time(int newHour, int newMinute, int newSecond) {
        hour = newHour;
        minute = newMinute;
        second = newSecond;
    }

    public void increment(int seconds) {
        while(seconds >= 3600) {
            seconds -= 3600;
            if(hour == 23) {
                hour = 0;
            } else {
                hour++;
            }
        }
        while(seconds >= 60) {
            seconds -= 60;
            if(minute == 59) {
                minute = 0;
                hour++;
            } else {
                minute++;
            }
        }
        while(seconds > 0) {
            seconds--;
            if(second == 59) {
                second = 0;
                if(minute == 59) {
                    minute = 0;
                    hour++;
                } else {
                    minute++;
                }
            } else {
                second++;
            }
        }
    }

    public void print(boolean military) {
        String newHour;
        String newMinute;
        String newSecond;
        boolean isPM = false;
        if(military) {
            if(hour < 10) {
                newHour = "0" + String.valueOf(hour);
            } else {
                newHour = String.valueOf(hour);
            }
            if(minute < 10) {
                newMinute = "0" + String.valueOf(minute);
            } else {
                newMinute = String.valueOf(minute);
            }
            if(second < 10) {
                newSecond = "0" + String.valueOf(second);
            } else {
                newSecond = String.valueOf(second);
            }
            System.out.println(newHour + ":" + newMinute + ":" + newSecond);
        } else {
            if(hour > 12) {
                hour -= 12;
                isPM = true;
            }
            if(hour < 10) {
                newHour = "0" + String.valueOf(hour);
            } else {
                newHour = String.valueOf(hour);
            }
            if(minute < 10) {
                newMinute = "0" + String.valueOf(minute);
            } else {
                newMinute = String.valueOf(minute);
            }
            if(second < 10) {
                newSecond = "0" + String.valueOf(second);
            } else {
                newSecond = String.valueOf(second);
            }
            if(isPM) {
                System.out.println(newHour + ":" + newMinute + ":" + newSecond + " PM");
                hour += 12;
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
