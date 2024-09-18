package com.pservice.pservice.inheritancerelations.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sg_mentor")
public class Mentor extends User {
    private double avgRating;
}
