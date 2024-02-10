package com.CSV;

import java.util.HashMap;
import java.util.Map;

public class RecursiveCSVCalculator {
	// Store calculated values of cells. Key is cell name (e.g., "A1"), value is the
	// calculated integer value.
	private static final Map<String, Integer> keyValues = new HashMap<>();

	public static void main(String[] args) {
		String[] entries = { "A1: 5", "A2: 7", "A3: 9", "B1: 3", "B2: 8", "B3: =4+5", "C1: =5+A1", "C2: =A2+B2",
				"C3: =C2+B3" };

		// Process each entry to either calculate its value or directly store it
		for (String entry : entries) {
			processEntry(entry);
		}

		// Print out all key-value pairs
		keyValues.forEach((key, value) -> System.out.println(key + ": " + value));
	}

	public static void processEntry(String entry) {
		String[] parts = entry.split(":"); // Split the entry into key (cell name) and value/expression
		String key = parts[0].trim(); // Cell name
		String value = parts[1].trim(); // Value or expression

		// If value starts with "=", it's an expression that needs to be calculated
		if (value.startsWith("=")) {
			keyValues.put(key, CalculateValue(value.substring(1))); // Calculate and store the result
		} else {
			// Directly parse and store integer values
			keyValues.put(key, Integer.parseInt(value));
		}
	}

	public static int CalculateValue(String expr) {
		int sum = 0;
		// Split the expression by "+" and calculate the sum of its parts
		for (String part : expr.split("\\+")) {
			// If part is a reference to another cell, add its value to the sum
			if (part.matches("[A-Z][0-9]")) {
				sum += keyValues.get(part);
			} else {
				// Otherwise, parse the integer value and add it to the sum
				sum += Integer.parseInt(part);
			}
		}
		return sum;
	}
}
