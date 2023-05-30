package ru.levelup.at.homework2;

import java.util.Arrays;

public class TickerNumberChecker {

    public boolean checkTicketNumber(String ticketNumber) {
        return countFirstPart(ticketNumber) == countSecondPart(ticketNumber);
    }

    public int countFirstPart(String ticketNumber) {
        String firstPart = ticketNumber.substring(0, 3);
        System.out.println(firstPart);
        char[] arrayNumber = firstPart.toCharArray();
        int result = 0;
        for (int i = 0; i < firstPart.length(); i++) {
            result += Character.getNumericValue(arrayNumber[i]);
        }
        System.out.println(result);
        return result;
    }

    public int countSecondPart(String ticketNumber) {
        String secondPart = ticketNumber.substring(3);
        System.out.println(secondPart);
        char[] arrayNumber = secondPart.toCharArray();
        int result = 0;
        for (int i = 0; i < secondPart.length(); i++) {
            result += Character.getNumericValue(arrayNumber[i]);
        }
        System.out.println(result);
        return result;
    }
}
