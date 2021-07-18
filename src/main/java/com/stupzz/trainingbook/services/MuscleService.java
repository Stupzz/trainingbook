package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Muscle;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuscleService {

    private final MongoTemplate mongoTemplate;

    public MuscleService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<Muscle> getAllMuscles() {
        return mongoTemplate.findAll(Muscle.class);
    }

    public Muscle addOneMuscle(String muscleName) {
        return this.mongoTemplate.insert(new Muscle(muscleName));
    }
}
