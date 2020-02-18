package com.junit.learning.unittesting.services;

import com.junit.learning.unittesting.dao.SomeDataService;

public class SomeBusinessImpl {
	
	private SomeDataService someDataService;
	
	
	
	public void setSomeDataService(SomeDataService someDataService) {
		this.someDataService = someDataService;
	}



	public int calculateSum(int[] data) {
		int sum = 0;
		for(int value : data) {
			sum+=value;
		}
		return sum;
	}
	
	public int calculateSumUsingDataService() {
		int sum = 0;
		
		int[] data = someDataService.retrieveAllDatas();
		
		for(int value : data) {
			sum+=value;
		}
		return sum;
	}

}
