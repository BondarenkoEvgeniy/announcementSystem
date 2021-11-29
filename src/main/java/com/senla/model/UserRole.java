package com.senla.model;

import java.util.Arrays;

public enum UserRole {
    USER,
    ADMINISTRATOR;

    public static UserRole byName(String name) {
        return Arrays.stream(values()).filter( season -> season.name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}


