package com.everest.dating.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Status {
    @JsonProperty("new")
    NEW("new"),
    @JsonProperty("in_progress")
    IN_PROGRESS("in_progress"),
    @JsonProperty("terminated")
    TERMINATED("terminated");

    private final String value;

    Status(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
