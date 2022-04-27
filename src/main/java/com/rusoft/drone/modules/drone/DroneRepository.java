package com.rusoft.drone.modules.drone;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.rusoft.drone.modules.drone.enums.DroneState;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {

    Optional<Drone> findBySerialNumber(String serialNumber);

    List<Drone> findAllByStateAndBatteryCapacityGreaterThanEqual(DroneState states,BigDecimal batteryCapacity);

    List<Drone> findAllByStateInAndBatteryCapacityGreaterThanEqual(List<DroneState> states,BigDecimal batteryCapacity);
}
