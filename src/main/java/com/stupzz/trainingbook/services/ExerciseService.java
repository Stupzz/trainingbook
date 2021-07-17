package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Exercise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Exercise> getAllExercise(){
        return mongoTemplate.findAll(Exercise.class);
    }

    //TODO : Delete this method after develop
    public Exercise test(){
        Exercise exercise = new Exercise("nameTests", "descriptionTest", Arrays.asList(0,1,2,3));
        return mongoTemplate.insert(exercise);
    }
}
