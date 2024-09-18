package com.pservice.pservice.inheritancerelations.joinedtable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "j_ta")
public class Ta extends User {
    private String specialization;
}
