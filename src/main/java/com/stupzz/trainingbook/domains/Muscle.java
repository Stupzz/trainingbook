package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Muscle {

    @Id
    private int id;
    private String name;

    public Muscle(String name) {
        this.name = name;
    }
}
