package com.example.service;

import com.example.dao.CityRepository;
import com.example.model.TblCity;
import com.example.service.Impl.CityService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CityServiceTest {
	
	@InjectMocks
	CityService sut;
	
	@Mock
	CityRepository cityRepository;
	
	
	/**
	 * Setup data by before test
	 */
	@Before
	public void setUp() {
		List<TblCity> tblCityList = new ArrayList<>();
		tblCityList.add(new TblCity());
		tblCityList.add(new TblCity());
		when(cityRepository.searchCityByPrefectureCode("11")).thenReturn(tblCityList);
	}
	
	/**
	 * Test find list TblCity by PrefectureCode
	 */
	@Test
	public void searchCityByPrefectureCodeTest() {
		//setup
		List<TblCity> tblCityList = sut.searchCityByPrefectureCode("11");
		//verify
		Assert.assertEquals(2, tblCityList.size());
	}
}
