package org.example.converter;

import jakarta.persistence.AttributeConverter;
import org.example.entity.BirthDate;

import java.sql.Date;
import java.util.Optional;

public class BirthDayConverter implements AttributeConverter<BirthDate, Date> {

    @Override
    public Date convertToDatabaseColumn(BirthDate attribute) {
        return Optional.ofNullable(attribute)
                .map(BirthDate::birthDate)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public BirthDate convertToEntityAttribute(Date dbData) {
        return Optional.ofNullable(dbData)
                .map(Date::toLocalDate)
                .map(BirthDate::new)
                .orElse(null);
    }
}
