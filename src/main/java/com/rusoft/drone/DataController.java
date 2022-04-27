package com.rusoft.drone;

import java.util.ArrayList;
import java.util.List;

import com.rusoft.drone.modules.drone.Drone;
import com.rusoft.drone.modules.drone.DroneRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "${spring.data.rest.base-path}/data/")
public class DataController {

	private final DroneRepository countryRepository;


	@GetMapping(value = "get-extracts")
	public ResponseEntity<?> getExtracts() {
		List<String> dataList = new ArrayList<String>();
		dataList.add("dddd");

		List<Drone> findAll = countryRepository.findAll();
		return ResponseEntity.ok(findAll);
	}

	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	

}
