package com.rusoft.drone.modules.drone;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class DroneControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private static final String BASE_PATH = "/api/drones";
	private static final String DRONE_ID = "SE1234";

	@Test
	public void shouldReturnBatteryLevel() throws Exception {

		// Print example
		// this.mockMvc.perform(get(BASE_PATH + "/check_battery_level?serialNumber=" + DRONE_ID))
		// 		.andDo(print()).andExpect(status().isOk())
		// 		.andExpect(content().string(containsString("{\"batterLevel\":50.00}")));

		this.mockMvc.perform(get(BASE_PATH + "/check_battery_level?serialNumber=" + DRONE_ID))
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"batterLevel\":50.00}")));
	}
    
        
    
}