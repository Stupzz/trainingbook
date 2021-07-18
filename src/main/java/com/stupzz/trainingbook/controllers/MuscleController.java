package com.stupzz.trainingbook.controllers;

import com.stupzz.trainingbook.domains.Muscle;
import com.stupzz.trainingbook.services.MuscleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/muscles")
public class MuscleController {

    private final MuscleService muscleService;

    public MuscleController(MuscleService muscleService) {
        this.muscleService = muscleService;
    }

    @GetMapping
    public List<Muscle> getAllMuscles(){
        return muscleService.getAllMuscles();
    }

    @PostMapping()
    public Muscle addMuscle(@RequestParam String muscleName){
        return muscleService.addOneMuscle(muscleName);
    }
}
