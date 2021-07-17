package com.stupzz.trainingbook.controllers;

import com.stupzz.trainingbook.domains.Exercise;
import com.stupzz.trainingbook.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseService exerciseService;

    //TODO: Delete this method
    @PostMapping("test")
    public Exercise createRandomExercise(){
        return exerciseService.test();
    }

    @GetMapping()
    public List<Exercise> getAllExercise(){
        return exerciseService.getAllExercise();
    }
}