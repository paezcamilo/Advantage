package org.advantage.data;

import org.testng.annotations.DataProvider;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Data {

	@DataProvider(name = "stays")
    public Object[][] departureData() {
		LocalDate currentDate = LocalDate.now();
		LocalDate checkInDate = currentDate.plusDays(30);
		LocalDate checkOutDate = currentDate.plusDays(45);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
        return new Object[][] {{"Bogotá, Colombia",dtf.format(checkInDate),dtf.format(checkOutDate)}};
    }
	
	@DataProvider(name = "formInfo")
    public Object[][] formInfo() {
        return new Object[][] {{"Paez","test@gmail.com"}};
    }
		
}