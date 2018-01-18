package com.aquent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aquent.service.SortingService;

@SpringBootApplication
public class Application implements CommandLineRunner{
	
	@Autowired
	private SortingService service;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	public void processRecords(String[] args) {
		if(args.length < 2) {
			System.out.println("Error: Need input and output filenames as parameters");
			System.exit(1);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		
		if(service.sortOrderRecords(inputFile, outputFile)) {
			System.out.println("Records sorted successfully");
		} else {
			System.out.println("Error in sorting records");
		}
	}

	@Override
	public void run(String... args) throws Exception {
		if(args.length < 2) {
			System.out.println("Error: Need input and output filenames as parameters");
			System.exit(1);
		}
		String inputFile = args[0];
		String outputFile = args[1];
		
		if(service.sortOrderRecords(inputFile, outputFile)) {
			System.out.println("Records sorted successfully");
		} else {
			System.out.println("Error in sorting records");
		}
		
	}
}
