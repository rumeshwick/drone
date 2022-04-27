package com.rusoft.drone.modules.drone;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findAllBySerialNumber(String serialNumber);
}
