package com.junit.learning.unittesting.services;

import java.util.Arrays;

import com.junit.learning.unittesting.dao.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}



	public int calculateSum(int[] data) {
		
		return Arrays.stream(data).reduce(Integer::sum).orElse(0);
		
//		int sum = 0;
//		for(int value : data) {
//			sum+=value;
//		}
//		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int[] data = someDataService.retrieveAllDatas();
		return this.calculateSum(data);
	}
	
	

}
