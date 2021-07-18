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
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

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
        Exercise exercise2 = new Exercise("test2", "desc2", Arrays.asList(1));
        List<Exercise> exercises = Arrays.asList(exercise1, exercise2);

        Mockito.when(mongoTemplate.findAll(Exercise.class)).thenReturn(exercises);

        List<Exercise> result = exerciseService.getAllExercise();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.size(), 2);
        Assertions.assertTrue(result.get(0).getName().equals("test1") && result.get(1).getName().equals("test2"));
    }

    @Test
    void getExerciseForSpecificMuscle(){
        Exercise exercise1 = new Exercise("test1", "desc1", Arrays.asList(0, 1, 2));
        Exercise exercise2 = new Exercise("test2", "desc2", Arrays.asList(1));

        List<Integer> muscleIndex = Arrays.asList(0,2);

        Mockito.when(mongoTemplate.find(new Query().addCriteria(Criteria.where("muscles").all(muscleIndex)), Exercise.class)).thenReturn(Arrays.asList(exercise1));

        List<Exercise> result = exerciseService.getExerciseForSpecificMuscle(muscleIndex);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(result.size(), 1);
        Assertions.assertTrue(result.contains(exercise1));
    }
}
