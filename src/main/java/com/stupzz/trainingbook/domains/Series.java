package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
public class Series {

    @Transient
    public static final String SEQUENCE_NAME = "series_sequence";

    @Id
    private int id;

    private int blockId;
    private int executionNumber;
    private float weight;
    private int offTime;
    private int durationTime;
}
