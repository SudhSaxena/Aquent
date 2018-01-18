package com.aquent.dao;

import java.util.List;

public interface IOrderRecordsDao {
	public List<String> getOrderRecords(String inputFile);
	public void writeOrderRecords(String outputFile, List<String> lineList);
}
