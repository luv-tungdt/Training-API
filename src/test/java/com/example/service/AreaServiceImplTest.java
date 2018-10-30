package com.example.service;

import com.example.dao.AreaRepositoryImpl;
import com.example.model.TblArea;
import com.example.service.Impl.AreaServiceImpl;
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
public class AreaServiceImplTest {
	
	@InjectMocks
	private AreaServiceImpl areaServiceImpl;
	
	@Mock
	private AreaRepositoryImpl areaRepoImpl;

	@Before
	public void setUp() {
		List<TblArea> areaList = new ArrayList<TblArea>();
		areaList.add(new TblArea());
		when(areaRepoImpl.searchAreaByPostCode("4370222")).thenReturn(areaList);
	}
	
	@Test
	public void searchAreaByPostCodeTest() {
		List<TblArea> areaList = areaServiceImpl.searchAreaByPostCode("4370222");
		Assert.assertEquals(1, areaList.size());
	}

	
}
