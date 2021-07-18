package com.stupzz.trainingbook.services;

import com.stupzz.trainingbook.domains.Muscle;
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
public class MuscleServiceTest {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MuscleService muscleService;

    @Test
    void getAllMusclesTest(){
        Mockito.when(mongoTemplate.findAll(Muscle.class)).thenReturn(Arrays.asList(
                new Muscle("Dos"),
                new Muscle("Pectoraux")
        ));

        List<Muscle> result = muscleService.getAllMuscles();

        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.size() == 2);
        Assertions.assertTrue(result.get(0).getName().equals("Dos") && result.get(1).getName().equals("Pectoraux"));
    }
}
