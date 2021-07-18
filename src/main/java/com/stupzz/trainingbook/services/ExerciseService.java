package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Exercise;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ExerciseService {

    private final MongoTemplate mongoTemplate;

    public ExerciseService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Exercise> getAllExercise(){
        return mongoTemplate.findAll(Exercise.class);
    }

    //TODO : Delete this method after develop
    public Exercise test(){
        Exercise exercise = new Exercise("nameTests", "descriptionTest", Arrays.asList(0,1,2,3));
        return mongoTemplate.insert(exercise);
    }

    public List<Exercise> getExerciseForSpecificMuscle(List<Integer> muscles) {
        Query query = new Query();
        query.addCriteria(
                Criteria.where("muscles").all(muscles)
        );

        return mongoTemplate.find(query, Exercise.class);
    }

    public boolean exerciseExiste(int indexExercise) {
        return mongoTemplate.exists(Query.query(Criteria.where("_id").is(indexExercise)), Exercise.class);
    }
}
