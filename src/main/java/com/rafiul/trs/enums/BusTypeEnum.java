package com.rafiul.trs.enums;

public enum BusTypeEnum {

    AC("AC", "ac"),
    NON_AC("NON_AC", "non_ac");

    private final String key;
    private final String value;

    BusTypeEnum(String key, String value) {
        this.key = key;
        this.value = value;
    }

//    public String getValue() {
//        return value;
//    }
}
