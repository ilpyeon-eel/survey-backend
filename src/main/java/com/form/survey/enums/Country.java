package com.form.survey.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import java.util.Arrays;

@Getter
public enum Country {
    SOUTH_KOREA("South Korea"),
    JAPAN("Japan"),
    CHINA("China"),
    HONGKONG("Hongkong"),
    UNITED_STATES("United States"),
    CANADA("Canada"),
    VIETNAM("Vietnam"),
    THAILAND("Thailand"),
    SINGAPORE("Singapore");

    private final String displayName;

    Country(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static Country fromDisplayName(String displayName) {
        return Arrays.stream(Country.values())
                .filter(country -> country.displayName.equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 나라 입력"));
    }
}