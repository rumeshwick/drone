package com.rusoft.drone.modules.medication;


import java.util.List;

import com.rusoft.drone.modules.drone.Drone;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findAllByDrone(Drone drone);

}
