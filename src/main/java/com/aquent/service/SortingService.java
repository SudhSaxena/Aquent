package com.aquent.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aquent.dao.OrderRecordsDao;

@Component
public class SortingService {

	@Autowired
	private OrderRecordsDao dao;

	public boolean sortOrderRecords(String inputFile, String outputFile) {
		if(inputFile.trim().isEmpty() || outputFile.trim().isEmpty()) {
			System.out.println("Invalid filenames!");
			return false;
		}
		
		List<String> lineList = dao.getOrderRecords(inputFile);

		if (lineList != null && !lineList.isEmpty()) {
			Collections.sort(lineList, new IgnoreCaseSorter());
			dao.writeOrderRecords(outputFile, lineList);
			return true;
		}

		return false;
	}
}