package com.rafiul.trs.enums;

public enum TripStatusEnum {

    PENDING("PENDING", "pending"),
    RUNNING("RUNNING", "running"),
    COMPLETED("COMPLETED", "completed");

    private final String key;
    private final String value;

    TripStatusEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
