package com.pservice.pservice.inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_instructor")
public class Instructor extends User {
    private String currentBatchName;
    private double avgRating;
}
