package com.rusoft.drone.modules.medication;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rusoft.drone.modules.drone.Drone;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Pattern(regexp="^[a-zA-Z0-9_-]+$",message="Invalid Name")  
    private String name;

    @Pattern(regexp="^[A-Z0-9_]+$",message="Invalid Code")  
    private String code;

    @Column(name="weight")
    private BigDecimal weight;

    private String image;

    @ManyToOne
    @JsonIgnore
    private Drone drone;

}
