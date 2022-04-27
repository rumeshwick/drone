package com.rusoft.drone.modules.drone;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.rusoft.drone.modules.drone.enums.DroneState;
import com.rusoft.drone.modules.medication.Medication;
import com.rusoft.drone.modules.medication.MedicationRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${spring.data.rest.base-path}/drones/")
@Slf4j
public class DroneController {

	private final DroneRepository droneRepository;

	private final MedicationRepository medicationRepository;


	@GetMapping(value = "check_battery_level")
	public ResponseEntity<?> checkBatteryLevel(@RequestParam(value = "serialNumber") String serialNumber) {

		Optional<Drone> droneResponse = droneRepository.findBySerialNumber(serialNumber);

		if(droneResponse.isPresent()){
			Map<String,Object> response = new HashMap<String,Object>();
			response.put("batterLevel", droneResponse.get().getBatteryCapacity());
			return ResponseEntity.ok(response);
		}

		return ResponseEntity.badRequest().body("Drone not found");
	}

	@GetMapping(value = "available")
	public ResponseEntity<?> getAvailableDrones() {

		List<DroneState> states = new ArrayList<DroneState>() {
            {
                add(DroneState.IDLE);
                add(DroneState.LOADING);
            }
        };

		List<Drone> drones = droneRepository.findAllByStateInAndBatteryCapacityGreaterThanEqual(states,new BigDecimal(25));

		return ResponseEntity.ok(drones);
	}


	@GetMapping(value = "{serialNumber}/get_medications")
	public ResponseEntity<?> getMedications(@PathVariable String serialNumber) {

		log.info("serialNumber: {}",serialNumber);

		Optional<Drone> droneResponse = droneRepository.findBySerialNumber(serialNumber);

		if(droneResponse.isPresent()){

			List<Medication> findAllByDrone = medicationRepository.findAllByDrone(droneResponse.get());
	
			return ResponseEntity.ok(findAllByDrone);
		}
		
		return ResponseEntity.badRequest().body("Drone not found");
	}

	@PostMapping(value = "{serialNumber}/load_medication/")
	public ResponseEntity<?> loadMedication(@RequestBody Medication medication,
			@PathVariable String serialNumber) {

		log.info("serialNumber: {}",serialNumber);

		Optional<Drone> droneResponse = droneRepository.findBySerialNumber(serialNumber);

		if(droneResponse.isPresent()){
			medication.setDrone(droneResponse.get());
			medicationRepository.save(medication);
			return ResponseEntity.ok(medication);
		}
		
		return ResponseEntity.badRequest().body("Drone not found");
	}

}
