package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Exercise;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private ExerciseService exerciseService;

    @Test
    void GetAllExerciseTest() {
        Exercise exercise1 = new Exercise("test1", "desc1", Arrays.asList(0, 1, 2));
        Exercise exercise2 = new Exercise("test2", "desc2", Arrays.asList());
        List<Exercise> exercises = Arrays.asList(exercise1, exercise2);

        Mockito.when(mongoTemplate.findAll(Exercise.class)).thenReturn(exercises);

        List<Exercise> result = exerciseService.getAllExercise();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() == 2);
        Assertions.assertTrue(result.get(0).getName().equals("test1") && result.get(1).getName().equals("test2"));
    }
}
