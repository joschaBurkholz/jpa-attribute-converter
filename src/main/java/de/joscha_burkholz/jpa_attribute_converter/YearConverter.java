package de.joscha_burkholz.jpa_attribute_converter;

import java.time.Year;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Converter
public class YearConverter implements AttributeConverter<Year, String> {

    @Override
    public String convertToDatabaseColumn(Year attribute) {
        if(attribute == null){
            return null;
        }
        return String.valueOf(attribute.getValue());
    }

    @Override
    public Year convertToEntityAttribute(String dbData) throws IllegalArgumentException {
        if(dbData == null){
            return null;
        }
        int year;
        try{
            year = Integer.parseInt(dbData);
        } catch (NumberFormatException e){
            log.error("Failed to parse {} to Integer", dbData);
            throw new IllegalArgumentException(dbData + " is not a valid value.");
        }
        return Year.of(year);
    }
}
