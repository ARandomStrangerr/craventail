package main.product.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void serialize(LocalDate value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        if (value != null) {
            gen.writeString(value.format(FORMATTER));
        }
    }
} 