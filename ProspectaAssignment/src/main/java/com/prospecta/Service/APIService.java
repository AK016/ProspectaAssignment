package com.prospecta.Service;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.prospecta.Entity.APIEntity;

@Service
public class APIService {
	public List<APIEntity> getApisByCategory(String category) {
		// Create an instance of RestTemplate for making HTTP requests and fetch the
		// response as a String
		RestTemplate restTemplate = new RestTemplate();
		String response = restTemplate.getForObject("https://api.publicapis.org/entries?category=" + category,
				String.class);

		// Store the data
		List<APIEntity> data = new ArrayList<>();

		// Convert the response string to a JSONObject and Get the "entries" array from
		// the response JSON
		JSONObject jsonObject = new JSONObject(response);
		JSONArray entries = jsonObject.getJSONArray("entries");

		// traverse the response to filter title and description only and store them in
		// data array
		for (int i = 0; i < entries.length(); i++) {
			JSONObject entry = entries.getJSONObject(i);
			String title = entry.getString("API"); // filter title which goes by API
			String description = entry.getString("Description"); // filter description which goes by Description
			data.add(new APIEntity(title, description));
		}

		return data;
	}

	public ResponseEntity<Object> saveEntry(APIEntity entry) {
		final String uri = "https://api.publicapis.org/entries";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Object> result = restTemplate.postForEntity(uri, entry, Object.class);

		// As the API doesn't support POST operation, an error will be thrown mostly 500
		// server error.
		return result;
	}
}
