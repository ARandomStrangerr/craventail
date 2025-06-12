package main.product.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.List;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {
    private static final List<DateTimeFormatter> FORMATTERS = Arrays.asList(
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy/MM/dd"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd")
    );

    @Override
    public LocalDate deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String date = p.getText().trim();
        
        if (date == null || date.isEmpty()) {
            return null;
        }

        // Try all supported formats
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {
                // Continue to next format
            }
        }

        throw new IOException("Định dạng ngày tháng không hợp lệ. Các định dạng hỗ trợ: yy/MM/yyyy, yyyy/MM/dd, dd/MM/yyyy, yyyy-MM-dd");
    }
} 