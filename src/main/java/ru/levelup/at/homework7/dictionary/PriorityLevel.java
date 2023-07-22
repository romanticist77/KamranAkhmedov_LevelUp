package ru.levelup.at.homework7.dictionary;

public enum PriorityLevel {

    LOW("low"),
    MEDIUM("medium"),
    HIGH("high");

    private final String value;

    PriorityLevel(final String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return value();
    }

}
