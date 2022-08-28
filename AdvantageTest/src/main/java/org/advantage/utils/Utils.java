package org.advantage.utils;

import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import com.opencsv.*;

public class Utils {

	public String generateRandomPasswordAlpNum(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
          +"jklmnopqrstuvwxyz!#$%&";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public String generateRandomPasswordInt(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public String generateRandomPasswordAlp(int len) {
		String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghi"
				+"jklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public void writeDataLineByLine(String userName, String passwordUser, String filePath)
	{
		// first create file object for file placed at location
		// specified by filepath
		File file = new File(filePath);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputFile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputFile);

			// adding header to csv
			String[] header = { "User", "Password" };
			writer.writeNext(header);

			// add data to csv
			String[] data1 = { userName, passwordUser };
			writer.writeNext(data1);

			// closing writer connection
			writer.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Java code to illustrate
	// Reading CSV File
	public String readDataFromCustomSeparator(String file)
	{
		try {
			// Create an object of file reader class with CSV file as a parameter.
			FileReader filereader = new FileReader(file);

			// create csvParser object with
			// custom separator semi-colon
			CSVParser parser = new CSVParserBuilder().withSeparator(',').build();
			// create csvReader object with parameter
			// filereader and parser
			CSVReader csvReader = new CSVReaderBuilder(filereader).withCSVParser(parser).withSkipLines(1).build();

			// Read all data at once
			List<String[]> allData = csvReader.readAll();

			// Print Data.
			for (String[] row : allData) {
				for (String cell : row) {

					String userName = row[0];
					String PasswordUser = row[1];

					return userName+","+PasswordUser;
				}
				System.out.println();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}return "noUser";
	}

}
