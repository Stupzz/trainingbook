package com.stupzz.trainingbook.domains;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection= "database_sequences")
public class DatabaseSequence {

    @Id
    private String id;

    private long seq;
}
