package com.form.survey.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.Arrays;

@Getter
public enum NumberOfPeopleGroup {
    ONE_PERSON("1인"),
    TWO_THREE_PEOPLE("2-3인"),
    FOUR_FIVE_PEOPLE("4-5인"),
    SIX_OR_MORE_PEOPLE("6인 이상");

    private final String displayName;

    NumberOfPeopleGroup(String displayName) {
        this.displayName = displayName;
    }

    @JsonValue
    public String getDisplayName() {
        return displayName;
    }

    @JsonCreator
    public static NumberOfPeopleGroup fromDisplayName(String displayName) {
        return Arrays.stream(NumberOfPeopleGroup.values())
                .filter(group -> group.displayName.equals(displayName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid Number of People Group: " + displayName));
    }
}