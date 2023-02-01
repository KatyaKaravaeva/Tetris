package com.jigsaw.game;

public class Timer {
    private int hours;
    private int minutes;
    private int seconds;

    // Zero the values of hours, minutes and seconds in the timer in the constructor.
    public Timer() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    /**
     * Method that returns the value of the current time.
     *
     * @return current time
     */
    public String showTime() {
        return hours + ":" + minutes + ":" + seconds;
    }

    /**
     * Method that imitates the action of the timer, it is called every second.
     */
    public void setPlusOne() {
        ++seconds;
        if (seconds == 60) {
            seconds = 0;
            ++minutes;
            if (minutes == 60) {
                minutes = 0;
                ++hours;
                if (hours == 24) {
                    hours = 0;
                }
            }
        }
    }
}
