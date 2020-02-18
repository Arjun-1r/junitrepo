package com.junit.learning.unittesting.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.junit.learning.unittesting.dao.SomeDataService;
import com.junit.learning.unittesting.services.SomeBusinessImpl;

 class SomeDataServiceEmptyStubTest implements SomeDataService {

	@Override
	public int[] retrieveAllDatas() {
			return new int[] {};
	}

}
 
 class SomeDataServiceSingleDataStubTest implements SomeDataService {

	@Override
	public int[] retrieveAllDatas() {
			return new int[] {5};
	}

}



class SomeBusinessImplStubTest {

	@Test
	void calculateSumUsingDataService_Basic() {
	     SomeBusinessImpl sbi = new SomeBusinessImpl();
	     sbi.setSomeDataService(new SomeDataServiceStubTest());
	     int actualResult = sbi.calculateSumUsingDataService();
	     int expectedResult = 10;
	     assertEquals(expectedResult,actualResult);
	}
	
	
	@Test
	void calculateSumEmpty() {
	     SomeBusinessImpl sbi = new SomeBusinessImpl();
	     sbi.setSomeDataService(new SomeDataServiceEmptyStubTest());
	     int actualResult = sbi.calculateSumUsingDataService();
	     int expectedResult = 0;
	     assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSumOneValue() {
	     SomeBusinessImpl sbi = new SomeBusinessImpl();
	     sbi.setSomeDataService(new SomeDataServiceSingleDataStubTest());
	     int actualResult = sbi.calculateSumUsingDataService();
	     int expectedResult = 5;
	     assertEquals(expectedResult,actualResult);
	}
	

}
