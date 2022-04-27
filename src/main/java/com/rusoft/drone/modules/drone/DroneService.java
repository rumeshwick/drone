package com.rusoft.drone.modules.drone;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.rusoft.drone.modules.drone.enums.DroneState;
import com.rusoft.drone.modules.droneHistory.DroneHistory;
import com.rusoft.drone.modules.droneHistory.DroneHistoryRepository;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@EnableScheduling
@Slf4j
public class DroneService {

	private final DroneRepository droneRepository;

	private final DroneHistoryRepository droneHistoryRepository;

	@Scheduled(cron="0 */5 * * * ?") // Every 5 Mins
	// @Scheduled(cron="*/5 * * * * ?") // Every 20 sec
	public void droneScheduler()
	{

		List<Drone> drons = droneRepository.findAll();

		for(Drone drone : drons){

			// Update drone battery level history
			DroneHistory droneHistory = new DroneHistory();
			droneHistory.setDrone(drone);
			droneHistory.setDate(new Date());
			droneHistory.setBatteryCapacity(drone.getBatteryCapacity());
			droneHistoryRepository.save(droneHistory);

			// Prevent drones being in LOADING state if battery capacity is less than 25
			if(drone.getState().equals(DroneState.LOADING) && drone.getBatteryCapacity().compareTo(new BigDecimal("25")) < 0){
				drone.setState(DroneState.IDLE);
				droneRepository.save(drone);
			}
		}

	}

	

	

}