package gov.naco.soch.ti.service;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
 
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
 
@Component
public class LocalDateConverter implements Converter<String, LocalDate> {
 
    @Override
    public LocalDate convert(final String s) {
        return LocalDate.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
