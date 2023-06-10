package ru.levelup.at.homework2;

public class TicketNumberChecker {

    public boolean checkTicketNumber(String ticketNumber) {
        if (ticketNumber == null) {
            throw new NullPointerException("Illegal argument is provided");
        }
        if (ticketNumber.isEmpty() || ticketNumber.isBlank()) {
            throw new IllegalArgumentException("Illegal argument is provided");
        } else {
            return countFirstPart(ticketNumber) == countSecondPart(ticketNumber);
        }
    }

    private int countFirstPart(String ticketNumber) {
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

    private int countSecondPart(String ticketNumber) {
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
