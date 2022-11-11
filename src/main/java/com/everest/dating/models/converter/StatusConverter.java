package com.everest.dating.models.converter;

import com.everest.dating.models.enums.Status;
import com.everest.dating.models.enums.Status;

import javax.persistence.AttributeConverter;
import java.util.stream.Stream;

public class StatusConverter  implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return  status != null ? status.getValue() : null;
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        return value != null ?  Stream.of(Status.values())
                .filter(val -> value.equals(val.getValue()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new) : null;
    }
}
