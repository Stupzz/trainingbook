package com.stupzz.trainingbook.listeners;

import com.stupzz.trainingbook.domains.Block.Block;
import com.stupzz.trainingbook.services.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;

public class BlockModelListener extends AbstractMongoEventListener<Block> {

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public BlockModelListener() {
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Block> event) {
        if (event.getSource().getId() < 1) {
            event.getSource().setId((int) sequenceGeneratorService.generateSequence(Block.SEQUENCE_NAME));
        }
    }
}
