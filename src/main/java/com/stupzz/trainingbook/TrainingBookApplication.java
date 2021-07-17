package com.stupzz.trainingbook;

import com.mongodb.client.MongoClients;
import com.stupzz.trainingbook.domains.Exercise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class TrainingBookApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrainingBookApplication.class, args);

    }
}
