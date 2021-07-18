package com.stupzz.trainingbook.listeners;

import com.stupzz.trainingbook.domains.Exercise;
import com.stupzz.trainingbook.domains.Muscle;
import com.stupzz.trainingbook.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class MuscleModelListener extends AbstractMongoEventListener<Muscle> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public MuscleModelListener() {
    }


    @Override
    public void onBeforeConvert(BeforeConvertEvent<Muscle> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId((int) sequenceGeneratorService.generateSequence(Muscle.SEQUENCE_NAME));
        }
    }
}
