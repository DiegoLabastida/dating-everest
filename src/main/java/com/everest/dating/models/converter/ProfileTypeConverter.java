package com.everest.dating.models.converter;

import com.everest.dating.models.enums.Gender;
import com.everest.dating.models.enums.ProfileType;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class ProfileTypeConverter implements AttributeConverter<ProfileType, String> {

    @Override
    public String convertToDatabaseColumn(ProfileType profileType) {
        return  profileType != null ? profileType.getValue() : null;
    }

    @Override
    public ProfileType convertToEntityAttribute(String value) {
        return value != null ?  Stream.of(ProfileType.values())
                .filter(val -> value.equals(val.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new) : null;
    }
}
