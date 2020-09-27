package com.wellsfargo.fsd.coronakit.service;

import com.wellsfargo.fsd.coronakit.entity.CoronaKit;

public interface CoronaKitService {
	public CoronaKit saveKit(CoronaKit kit);
	public CoronaKit getKitById(int kitId);
}
