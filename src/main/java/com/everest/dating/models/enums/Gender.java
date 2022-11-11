package com.everest.dating.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Gender {
    @JsonProperty("female")
    FEMALE("female"),
    @JsonProperty("male")
    MALE("male");

    private final String value;

    Gender(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
