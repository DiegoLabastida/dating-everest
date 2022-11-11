package com.everest.dating.models.converter;

import com.everest.dating.models.enums.Gender;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class GenderConverter implements AttributeConverter<Gender, String> {
    @Override
    public String convertToDatabaseColumn(Gender gender) {
        return  gender != null ? gender.getValue() : null;
    }

    @Override
    public Gender convertToEntityAttribute(String value) {
        return value != null ?  Stream.of(Gender.values())
                .filter(val -> value.equals(val.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new) : null;
    }
}
