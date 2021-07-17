package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

@Data
public class Exercise {

    @Id
    private String id;

    private String name;
    private String description;
    private List<Integer> muscles;

    public Exercise(String name, String description, List<Integer> muscles) {
        this.name = name;
        this.description = description;
        this.muscles = muscles;
    }
}
