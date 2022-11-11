package com.everest.dating.models.converter;

import com.everest.dating.models.enums.SexualOrientation;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class SexualOrientationConverter implements AttributeConverter<SexualOrientation, String> {
    @Override
    public String convertToDatabaseColumn(SexualOrientation sexualOrientation) {
        return  sexualOrientation != null ? sexualOrientation.getValue() : null;
    }

    @Override
    public SexualOrientation convertToEntityAttribute(String value) {
        return value != null ?  Stream.of(SexualOrientation.values())
                .filter(val -> value.equals(val.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new) : null;
    }
}
