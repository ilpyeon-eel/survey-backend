package com.form.survey.controller;
import com.form.survey.dto.SurveyRequestDto;
import com.form.survey.dto.SurveyResponseDto;
import com.form.survey.service.SurveyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/surveys")
@RequiredArgsConstructor
public class SurveyController {

    private final SurveyService surveyService;


    @PostMapping // POST /api/surveys
    public ResponseEntity<SurveyResponseDto> createSurvey(@RequestBody SurveyRequestDto requestDto) {
        SurveyResponseDto responseDto = surveyService.saveSurvey(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }


    @GetMapping // GET /api/surveys
    public ResponseEntity<List<SurveyResponseDto>> getAllSurveys() {
        List<SurveyResponseDto> responseDtos = surveyService.getAllSurveys();
        return ResponseEntity.ok(responseDtos);
    }
}