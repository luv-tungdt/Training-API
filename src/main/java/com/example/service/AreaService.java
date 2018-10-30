package com.example.service;

import com.example.model.TblArea;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AreaService {
	
	/**
	 * get Area information by postcode
	 *
	 * @param  postCode postcode
	 * @return TblArea
	 */
	List<TblArea> searchAreaByPostCode(String postCode);
}
