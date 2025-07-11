package com.form.survey.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum AgeGroup {
    UNDER_20("20미만"),
    TWENTIES("20-30"),
    THIRTIES("31-40"),
    FORTIES("41 ~ 50"),
    FIFTIES("51 ~ 60"),
    OVER_60("61 이상");

    private final String displayName;

    AgeGroup(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static AgeGroup fromDisplayName(String displayName) {
        return Arrays.stream(AgeGroup.values())
                .filter(ageGroup -> ageGroup.displayName.equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Age Group: " + displayName));
    }
}