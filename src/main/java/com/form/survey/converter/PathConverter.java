package com.form.survey.converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.form.survey.enums.ReferralPath;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class PathConverter implements AttributeConverter<List<ReferralPath>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<ReferralPath> attribute) {
        if (attribute == null || attribute.isEmpty()) {
            return null;
        }
        try {

            List<String> displayNames = attribute.stream()
                    .map(ReferralPath::getDisplayName)
                    .collect(Collectors.toList());
            return objectMapper.writeValueAsString(displayNames);
        } catch (JsonProcessingException e) {

            throw new IllegalArgumentException("Error converting List<ReferralPath> to JSON string", e);
        }
    }

    @Override
    public List<ReferralPath> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.trim().isEmpty()) {
            return null;
        }
        try {

            List<String> displayNames = objectMapper.readValue(dbData, objectMapper.getTypeFactory().constructCollectionType(List.class, String.class));
            return displayNames.stream()
                    .map(ReferralPath::fromDisplayName)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("Error converting JSON string to List<ReferralPath>", e);
        }
    }
}