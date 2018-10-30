package com.example.service;

import com.example.dao.CityRepositoryImpl;
import com.example.model.TblCity;
import com.example.service.Impl.CityServiceImpl;
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
public class CityServiceImplTest {
    @InjectMocks
    CityServiceImpl cityService;
    @Mock
    CityRepositoryImpl cityRepository;

    @Before
    public void setUp(){
        List<TblCity> tblCityList = new ArrayList<>();
        tblCityList.add(new TblCity());
        tblCityList.add(new TblCity());
        when(cityRepository.searchCityByPrefectureCode("11")).thenReturn(tblCityList);
    }
    @Test
    public void searchCityByPrefectureCodeTest(){
        List<TblCity> tblCityList1 = cityService.searchCityByPrefectureCode("11");
        System.out.println("xxxxx: "+tblCityList1.size());
        Assert.assertEquals(2,tblCityList1.size());
    }
}
