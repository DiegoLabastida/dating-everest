package com.everest.dating.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SexualOrientation {
    @JsonProperty("heterosexual")
    HETEROSEXUAL("heterosexual"),
    @JsonProperty("bisexual")
    BISEXUAL("bisexual"),
    @JsonProperty("homosexual")
    HOMOSEXUAL("homosexual"),
    @JsonProperty("other")
    OTHER("other");

    private final String value;

    SexualOrientation(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
