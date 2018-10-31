package com.example.dao;

import com.example.model.TblArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AreaRepository extends JpaRepository<TblArea, Integer>, AreaRepositoryCustom {
	
}
