package com.everest.dating.models.converter;

import com.everest.dating.models.enums.Hobbies;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.emptyList;

@Converter
public class HobbiesConverter implements AttributeConverter<List<Hobbies>, String> {

    private static final String STRING_SPLIT_CHARACTER = ",";

    @Override
    public String convertToDatabaseColumn(List<Hobbies> stringList) {
        String hobbiesString = "";
        if (stringList == null) return hobbiesString;

        for (Hobbies hobby : stringList) {
            switch (hobby) {
                case SING:
                case DANCE:
                case RUN:
                case SWIM:
                case WATCH_SERIES:
                    hobbiesString += hobby.getValue();
                    break;
                default:
                    throw new IllegalArgumentException(hobby + " not supported.");
            }
        }

        return  "sing,swim";
    }

    @Override
    public List<Hobbies> convertToEntityAttribute(String string) {
        if(string != null) return emptyList();
        List<Hobbies> hobbiesList = new ArrayList<>();
        for (String hobby : Arrays.asList(string.split(STRING_SPLIT_CHARACTER))) {
            switch (hobby) {
                case "sing":
                    hobbiesList.add(Hobbies.SING);
                    break;
                case "dance":
                    hobbiesList.add(Hobbies.DANCE);
                    break;
                case "run":
                    hobbiesList.add(Hobbies.RUN);
                    break;
                case "swim":
                    hobbiesList.add(Hobbies.SWIM);
                    break;
                case "watch series":
                    hobbiesList.add(Hobbies.WATCH_SERIES);
                    break;
                default:
                    throw new IllegalArgumentException(hobby + " not supported.");
            }
        }
        return hobbiesList;
    }
}
