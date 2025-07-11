package com.form.survey.dto;
import com.form.survey.enums.AgeGroup;
import com.form.survey.domain.Country;
import com.form.survey.enums.NumberOfPeopleGroup;
import com.form.survey.enums.ReferralPath;
import com.form.survey.domain.Survey;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
@Getter
@NoArgsConstructor
public class SurveyResponseDto {
    private Long id;
    private Country country;
    private AgeGroup ageGroup;
    private NumberOfPeopleGroup numberOfPeopleGroup;
    private List<ReferralPath> referralPaths;

    public SurveyResponseDto(Survey survey) {
        this.id = survey.getId();
        this.country = survey.getCountry();
        this.ageGroup = survey.getAgeGroup();
        this.numberOfPeopleGroup = survey.getNumberOfPeopleGroup();
        this.referralPaths = survey.getReferralPaths();
    }
}