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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="serial_number",length = 100)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
	private DroneModel model;

    @Column(name="weight_imit")
    private BigDecimal weightLimit;

    @Column(name="battery_capacity")
    private BigDecimal batteryCapacity;

    @Enumerated(EnumType.STRING)
	private DroneState state;


}
