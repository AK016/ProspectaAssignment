package com.CSV;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class RecursiveCSVCalculator {
	// Store calculated values of cells. Key is cell name (e.g., "A1"), value is the
	// calculated integer value.
	private static final Map<String, Integer> keyValues = new HashMap<>();

	public static void main(String[] args) {
		String inputFilePath = "src\\Input.csv"; // Input file path
		String outputFilePath = "src\\Output.csv"; // Output file path


		readFileAndProcessEntries(inputFilePath);
		writeResultsToFile(outputFilePath);
	}

	private static void readFileAndProcessEntries(String filePath) {
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				processEntry(line);
			}
		} catch (IOException e) {
			System.out.println("An error occurred while reading the file: " + e.getMessage());
		}
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

	private static void writeResultsToFile(String filePath) {
		try (PrintWriter pw = new PrintWriter(new FileWriter(filePath))) {
			keyValues.forEach((key, value) -> pw.println(key + ": " + value));
		} catch (IOException e) {
			System.out.println("An error occurred while writing to the file: " + e.getMessage());
		}
	}
}
