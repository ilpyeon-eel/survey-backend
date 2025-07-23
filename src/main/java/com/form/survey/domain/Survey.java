package com.form.survey.domain;

import com.form.survey.converter.PathConverter;
import com.form.survey.enums.AgeGroup;
import com.form.survey.enums.NumberOfPeopleGroup;
import com.form.survey.enums.ReferralPath;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "survey_data")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Survey {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private com.form.survey.domain.Country country;

    @Enumerated(EnumType.STRING)
    @Column(name = "age_group", nullable = false)
    private AgeGroup ageGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "number_of_people_group", nullable = false)
    private NumberOfPeopleGroup numberOfPeopleGroup;

    @Convert(converter = PathConverter.class)
    @Column(name = "referral_paths", columnDefinition = "TEXT", nullable = false)
    private List<ReferralPath> referralPaths;

    @Builder
    public Survey(com.form.survey.domain.Country country, AgeGroup ageGroup, NumberOfPeopleGroup numberOfPeopleGroup, List<ReferralPath> referralPaths) {
        this.country = country;
        this.ageGroup = ageGroup;
        this.numberOfPeopleGroup = numberOfPeopleGroup;
        this.referralPaths = referralPaths;
    }
}