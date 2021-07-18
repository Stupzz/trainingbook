package com.stupzz.trainingbook.configuration;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.stupzz.trainingbook.listeners.BlockModelListener;
import com.stupzz.trainingbook.listeners.ExerciseModelListener;
import com.stupzz.trainingbook.listeners.MuscleModelListener;
import com.stupzz.trainingbook.listeners.SeriesModelListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class AppConfig {

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create("mongodb://localhost:27017");
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "training-book");
    }

    @Bean
    public BlockModelListener blockModelListener() {
        return new BlockModelListener();
    }

    @Bean
    public ExerciseModelListener exerciseModelListener() {
        return new ExerciseModelListener();
    }

    @Bean
    public MuscleModelListener muscleModelListener() {
        return new MuscleModelListener();
    }

    @Bean
    public SeriesModelListener seriesModelListener() {
        return new SeriesModelListener();
    }
}
