package com.pservice.pservice.inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_mentor")
public class Mentor extends User {
    private double avgRating;
}
