package com.rusoft.drone.modules.droneHistory;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rusoft.drone.modules.drone.Drone;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "drone_history")
public class DroneHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnore
    private Drone drone;

    @Column(name="battery_capacity")
    @DecimalMax(value = "100")
    @DecimalMin(value = "0")
    private BigDecimal batteryCapacity;

	private Date date;


}
