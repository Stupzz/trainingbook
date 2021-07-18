package com.stupzz.trainingbook.listeners;

import com.stupzz.trainingbook.domains.Exercise;
import com.stupzz.trainingbook.domains.Muscle;
import com.stupzz.trainingbook.domains.Series;
import com.stupzz.trainingbook.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class SeriesModelListener extends AbstractMongoEventListener<Series> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public SeriesModelListener() {
    }


    @Override
    public void onBeforeConvert(BeforeConvertEvent<Series> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId((int) sequenceGeneratorService.generateSequence(Series.SEQUENCE_NAME));
        }
    }
}