package ru.levelup.at.utils;

public final class SleepUtils {

    private SleepUtils() {

    }

    public static void sleep(long timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException exception) {
            throw new RuntimeException();
        }
    }
}
