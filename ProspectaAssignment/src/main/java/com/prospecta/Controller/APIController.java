package com.prospecta.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prospecta.Entity.APIEntity;
import com.prospecta.Service.APIService;

@RestController
public class APIController {

	private final APIService apiService;

	@Autowired
	public APIController(APIService apiService) {
		this.apiService = apiService;
	}

	// For fetching data by category
	@GetMapping("/byCategory")
	public List<APIEntity> getApisByCategory(@RequestParam String category) {
		return apiService.getApisByCategory(category);
	}

	// For adding new entries to the API
	@PostMapping("/saveEntry")
	public ResponseEntity<Object> saveEntry(@RequestBody APIEntity entry) {
		return apiService.saveEntry(entry);
		// As the API doesn't support POST operation, an error will be thrown mostly 500
		// server error.
	}

}
