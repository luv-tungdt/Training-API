package com.example.service.Impl;

import com.example.dao.AreaRepository;
import com.example.model.TblArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
	
	@Autowired
	AreaRepository areaRepo;
	
	
	public List<TblArea> searchAreaByPostCode(String postCode) {
		return areaRepo.searchAreaByPostCode(postCode);
	}
}
