package com.wellsfargo.fsd.coronakit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wellsfargo.fsd.coronakit.dao.CoronaKitRepository;
import com.wellsfargo.fsd.coronakit.entity.CoronaKit;

@Service
public class CoronaKitServiceImpl implements CoronaKitService {

	@Autowired
	CoronaKitRepository repository;
	
	@Override
	public CoronaKit saveKit(CoronaKit kit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CoronaKit getKitById(int kitId) {
		// TODO Auto-generated method stub
		return null;
	}

}
