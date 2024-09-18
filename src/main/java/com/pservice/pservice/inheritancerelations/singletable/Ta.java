package com.pservice.pservice.inheritancerelations.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sg_ta")
public class Ta extends User {
    private String specialization;
}
