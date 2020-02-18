package com.junit.learning.unittesting.servicetests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.junit.learning.unittesting.services.SomeBusinessImpl;

class SomeBusinessImplTest {

	@Test
	void calculateSumBasic() {
	     SomeBusinessImpl sbi = new SomeBusinessImpl();
	     int actualResult = sbi.calculateSum(new int[] {2,3,5});
	     int expectedResult = 10;
	     assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSumEmpty() {
	     SomeBusinessImpl sbi = new SomeBusinessImpl();
	     int actualResult = sbi.calculateSum(new int[] {});
	     int expectedResult = 0;
	     assertEquals(expectedResult,actualResult);
	}
	
	@Test
	void calculateSumOneValue() {
	     SomeBusinessImpl sbi = new SomeBusinessImpl();
	     int actualResult = sbi.calculateSum(new int[] {});
	     int expectedResult = 0;
	     assertEquals(expectedResult,actualResult);
	}

}
