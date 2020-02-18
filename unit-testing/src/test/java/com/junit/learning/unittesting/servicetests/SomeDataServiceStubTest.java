package com.junit.learning.unittesting.servicetests;

import com.junit.learning.unittesting.dao.SomeDataService;

public class SomeDataServiceStubTest implements SomeDataService {

	@Override
	public int[] retrieveAllDatas() {
			return new int[] {2,3,5};
	}

}
