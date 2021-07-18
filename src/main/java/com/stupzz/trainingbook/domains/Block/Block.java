package com.stupzz.trainingbook.domains.Block;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
public class Block {

    @Transient
    public static final String SEQUENCE_NAME = "block_sequence";

    @Id
    private int id;

    private String name;
    private int exercise;
    private int nbSeries;
    private int executionNumber;
    private float weight;
    private int offTime;
    private int durationTime;

    public Block(String name, int exercise, int nbSeries, int executionNumber, float weight, int offTime, int durationTime) {
        this.name = name;
        this.exercise = exercise;
        this.nbSeries = nbSeries;
        this.executionNumber = executionNumber;
        this.weight = weight;
        this.offTime = offTime;
        this.durationTime = durationTime;
    }

    public Block(BlockDto blockDto){
        this.name = blockDto.getName();
        this.exercise = blockDto.getExercise();
        this.nbSeries = blockDto.getNbSeries();
        this.executionNumber = blockDto.getExecutionPerSeries();
        this.weight = blockDto.getWeight();
        this.offTime = blockDto.getOffTime();
        this.durationTime = blockDto.getDurationTime();
    }
}
