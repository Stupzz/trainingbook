package com.stupzz.trainingbook.domains.Block;

import lombok.Data;

import java.util.List;

@Data
public class BlockDto {

    private String name;
    private int exercise;
    private int nbSeries;
    private int executionPerSeries;
    private float weight;
    private int offTime;
    private int durationTime;
}
