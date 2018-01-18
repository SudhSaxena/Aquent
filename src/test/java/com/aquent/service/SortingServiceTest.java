package com.aquent.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aquent.dao.OrderRecordsDao;

public class SortingServiceTest {
	
	@Mock
	private OrderRecordsDao mockDao;
	
	@InjectMocks
	private SortingService testService;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void invalidFilenames() {
		assertFalse(testService.sortOrderRecords("", ""));
	}
	
	@Test
	public void daoReturnsNullList() {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		when(mockDao.getOrderRecords(inputFile)).thenReturn(null);
		assertFalse(testService.sortOrderRecords(inputFile, outputFile));
	}
	
	@Test
	public void daoReturnsEmptyList() {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		when(mockDao.getOrderRecords(inputFile)).thenReturn(new ArrayList<String>());
		assertFalse(testService.sortOrderRecords(inputFile, outputFile));
	}
	
	@Test
	public void daoReturnsValidList() {
		String inputFile = "input.txt";
		String outputFile = "output.txt";
		List<String> lineList = new ArrayList<String>();
		lineList.add("order1    123456");
		lineList.add("order2     232344");
		when(mockDao.getOrderRecords(inputFile)).thenReturn(lineList);
		assertTrue(testService.sortOrderRecords(inputFile, outputFile));
	}
}
