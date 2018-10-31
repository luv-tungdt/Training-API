package com.example.service.Impl;

import com.example.dao.AreaRepository;
import com.example.model.TblArea;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
	
	@Autowired
	private AreaRepository areaRepo;
	
	
	@Override
	public List<TblArea> searchAreaByPostCode(String postCode) {
		return areaRepo.searchAreaByPostCode(postCode);
	}
}
