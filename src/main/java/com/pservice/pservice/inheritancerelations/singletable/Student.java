package com.pservice.pservice.inheritancerelations.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "sg_student")
public class Student extends User {
    private double psp;
    private String batchName;
    private int attendance;
}
