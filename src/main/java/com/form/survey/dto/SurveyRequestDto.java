package com.form.survey.dto;

import com.form.survey.domain.Country;
import com.form.survey.enums.AgeGroup;
import com.form.survey.enums.NumberOfPeopleGroup;
import com.form.survey.enums.ReferralPath;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class SurveyRequestDto {
    private Country country;
    private AgeGroup ageGroup;
    private NumberOfPeopleGroup numberOfPeopleGroup;
    private List<ReferralPath> referralPaths;
}