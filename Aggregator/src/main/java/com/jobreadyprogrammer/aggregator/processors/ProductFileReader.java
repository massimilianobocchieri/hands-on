package com.jobreadyprogrammer.aggregator.processors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductFileReader {

	String filePath = null;

	public ProductFileReader(String filePath) {
		this.filePath = filePath;
	}

	public List<String> getHeaders() throws IOException {
		String line = readFirstLine(filePath);
		String[] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}

	static String readFirstLine(String path) throws IOException {
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
			return bufferedReader.readLine();
		}
	}

	public List<String> readFileData() throws IOException {
		List<String> lines = new ArrayList<>();
		String currentLine = null;
		try (BufferedReader br = new BufferedReader(new FileReader(this.filePath))) {
			currentLine = br.readLine(); // skips headers
			while ((currentLine = br.readLine()) != null)
				lines.add(currentLine);

			return lines;
		}
	}

}
