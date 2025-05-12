package com.food.Order.Entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection="sequence")
public class Sequence {

    @Id
    private String id;
    private int sequence;




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }


}
