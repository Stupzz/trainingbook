package com.stupzz.trainingbook.listeners;

import com.stupzz.trainingbook.domains.Block.Block;
import com.stupzz.trainingbook.domains.Exercise;
import com.stupzz.trainingbook.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class ExerciseModelListener extends AbstractMongoEventListener<Exercise> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ExerciseModelListener() {
    }


    @Override
    public void onBeforeConvert(BeforeConvertEvent<Exercise> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId((int) sequenceGeneratorService.generateSequence(Exercise.SEQUENCE_NAME));
        }
    }
}
