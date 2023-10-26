package ru.appline.service;

public enum Direction {
    NORTH("North"),
    NORTH_EAST("North-East"),
    EAST("East"),
    SOUTH_EAST("South-East"),
    SOUTH("South"),
    SOUTH_WEST("South-West"),
    WEST("West"),
    NORTH_WEST("North-West");

    private final String directionValue;

    Direction(String directionValue) {
        this.directionValue = directionValue;
    }

    public String getDirectionValue() {
        return directionValue;
    }
}
