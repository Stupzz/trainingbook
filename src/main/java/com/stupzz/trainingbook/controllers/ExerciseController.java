package com.stupzz.trainingbook.controllers;

import com.stupzz.trainingbook.domains.Exercise;
import com.stupzz.trainingbook.domains.Muscle;
import com.stupzz.trainingbook.services.ExerciseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/exercises")
public class ExerciseController {

    private final ExerciseService exerciseService;

    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    //TODO: Delete this method
    @PostMapping("test")
    public void createRandomExercise() {
//        return exerciseService.exerciseExiste(344);
    }

    @GetMapping()
    public List<Exercise> getAllExercise() {
        return exerciseService.getAllExercise();
    }

    @PostMapping("find")
    public List<Exercise> getExerciseForSpecificMuscle(@RequestBody List<Integer> muscles){
        return exerciseService.getExerciseForSpecificMuscle(muscles);
    }
}
