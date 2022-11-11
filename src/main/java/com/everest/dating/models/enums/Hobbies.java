package com.everest.dating.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Hobbies {
    @JsonProperty("sing")
    SING("sing"),
    @JsonProperty("dance")
    DANCE("dance"),
    @JsonProperty("run")
    RUN("run"),
    @JsonProperty("swim")
    SWIM("swim"),
    @JsonProperty("watch series")
    WATCH_SERIES("watch series");

    private final String value;

    Hobbies(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
