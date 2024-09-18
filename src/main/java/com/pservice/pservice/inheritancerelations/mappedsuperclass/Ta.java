package com.pservice.pservice.inheritancerelations.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ms_ta")
public class Ta extends User{
    private String specialization;
}
