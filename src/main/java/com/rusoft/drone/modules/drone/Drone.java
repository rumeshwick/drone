package com.rusoft.drone.modules.drone;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;

import com.rusoft.drone.modules.drone.enums.DroneModel;
import com.rusoft.drone.modules.drone.enums.DroneState;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "drone")
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="serial_number",length = 100)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
	private DroneModel model;

    @Column(name="weight_limit")
    @DecimalMax(value = "500",message = "Weight limit should not be greater than 500")
    @DecimalMin(value = "0")
    private BigDecimal weightLimit;

    @Column(name="battery_capacity")
    @DecimalMax(value = "100")
    @DecimalMin(value = "0")
    private BigDecimal batteryCapacity;

    @Enumerated(EnumType.STRING)
	private DroneState state;


}
