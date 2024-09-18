package com.pservice.pservice.inheritancerelations.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sg_instructor")
public class Instructor extends User {
    private String currentBatchName;
    private double avgRating;
}
