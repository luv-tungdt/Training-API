package com.example.service;

import com.example.dao.AreaRepository;
import com.example.model.TblArea;
import com.example.service.Impl.AreaService;
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
public class AreaServiceTest {
	
	@InjectMocks
	private AreaService sut;
	
	@Mock
	private AreaRepository areaRepo;
	
	
	/**
	 * Setup data by before test
	 */
	@Before
	public void setUp() {
		List<TblArea> areaList = new ArrayList();
		areaList.add(new TblArea());
		when(areaRepo.searchAreaByPostCode("4370222")).thenReturn(areaList);
	}
	
	/**
	 * Test find list TblArea by PostCode
	 */
	@Test
	public void searchAreaByPostCodeTest() {
		//setup
		List<TblArea> areaList = sut.searchAreaByPostCode("4370222");
		//verify
		Assert.assertEquals(1, areaList.size());
	}
	
}
