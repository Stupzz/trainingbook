package com.stupzz.trainingbook.controllers;

import com.stupzz.trainingbook.Exceptions.NotFound.ExerciseNotFound;
import com.stupzz.trainingbook.Exceptions.NotFound.NotFoundException;
import com.stupzz.trainingbook.domains.Block.Block;
import com.stupzz.trainingbook.domains.Block.BlockDto;
import com.stupzz.trainingbook.services.BlockService;
import com.stupzz.trainingbook.services.ExerciseService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/blocks")
public class BlockController {

    private final BlockService blockService;
    private final ExerciseService exerciseService;

    public BlockController(BlockService blockService, ExerciseService exerciseService) {
        this.blockService = blockService;
        this.exerciseService = exerciseService;
    }

    @PostMapping("create")
    public Block createNewBlock(@RequestBody BlockDto blockDto) throws ExerciseNotFound {
        guardExerciseExist(blockDto.getExercise());
        return blockService.createBlock(blockDto);
    }

    private void guardExerciseExist(int indExercise) throws ExerciseNotFound {
        if(!exerciseService.exerciseExiste(indExercise)){
            throw new ExerciseNotFound("Exercise " + indExercise + " not found");
        }
    }
}
