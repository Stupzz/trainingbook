package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;

@Data
public class Exercise {

    @Transient
    public static final String SEQUENCE_NAME = "exercise_sequence";

    @Id
    private int id;

    private String name;
    private String description;
    private List<Integer> muscles;

    public Exercise(String name, String description, List<Integer> muscles) {
        this.name = name;
        this.description = description;
        this.muscles = muscles;
    }
}
