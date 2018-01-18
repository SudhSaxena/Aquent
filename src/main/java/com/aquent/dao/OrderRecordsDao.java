package com.aquent.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class OrderRecordsDao implements IOrderRecordsDao {

	public List<String> getOrderRecords(String inputFile) {
		List<String> lineList = new ArrayList<>();
		try {
			FileReader fileReader = new FileReader(inputFile);
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			// Assumption: First line in input file is always the header - Order		Time
			String inputLine = bufferedReader.readLine();

			// Assumption: The complete file can be read into the memory
			lineList = new ArrayList<String>();

			while ((inputLine = bufferedReader.readLine()) != null) {
				if (inputLine.trim().equals(""))
					continue;
				lineList.add(inputLine);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found!");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lineList;
	}

	public void writeOrderRecords(String outputFile, List<String> lineList) {
		try {
			FileWriter fileWriter = new FileWriter(outputFile);
			PrintWriter out = new PrintWriter(fileWriter);
			for (String outputLine : lineList) {
				out.println(outputLine);
			}
			out.flush();
			out.close();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
