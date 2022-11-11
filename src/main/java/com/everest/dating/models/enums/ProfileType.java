package com.everest.dating.models.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum ProfileType {
    @JsonProperty("client")
    CLIENT("client"),
    @JsonProperty("contractor")
    CONTRACTOR("contractor");

    private final String value;

    ProfileType(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }

}
