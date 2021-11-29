package com.senla.model;

import java.util.Arrays;

public enum AnnouncementStatus {
    REGULAR,
    SPECIAL;

    public static AnnouncementStatus byName(String name) {
        return Arrays.stream(values()).filter( season -> season.name().equalsIgnoreCase(name)).findFirst().orElse(null);
    }

}
