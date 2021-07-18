package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
public class Muscle {

    @Transient
    public static final String SEQUENCE_NAME = "muscle_sequence";

    @Id
    private int id;
    private String name;

    public Muscle(String name) {
        this.name = name;
    }
}
