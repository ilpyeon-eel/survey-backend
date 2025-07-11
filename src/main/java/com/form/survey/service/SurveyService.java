package com.form.survey.service;
import com.form.survey.domain.Survey;
import com.form.survey.dto.SurveyRequestDto;
import com.form.survey.dto.SurveyResponseDto;
import com.form.survey.repository.SurveyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SurveyService {

    private final SurveyRepository surveyRepository;


    @Transactional
    public SurveyResponseDto saveSurvey(SurveyRequestDto requestDto) {

        Survey survey = Survey.builder()
                .country(requestDto.getCountry())
                .ageGroup(requestDto.getAgeGroup())
                .numberOfPeopleGroup(requestDto.getNumberOfPeopleGroup())
                .referralPaths(requestDto.getReferralPaths())
                .build();


        Survey savedSurvey = surveyRepository.save(survey);


        return new SurveyResponseDto(savedSurvey);
    }


    @Transactional(readOnly = true)
    public List<SurveyResponseDto> getAllSurveys() {

        List<Survey> surveys = surveyRepository.findAll();
        return surveys.stream()
                .map(SurveyResponseDto::new)
                .collect(Collectors.toList());
    }
}