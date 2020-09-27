package com.eval.coronakit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eval.coronakit.dao.KitDetailRepository;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.exception.ProductException;

@Service
public class KitDetailServiceImpl implements KitDetailService {

	@Autowired
	KitDetailRepository kitDetailRepository;

	@Override
	public KitDetail addKitItem(KitDetail kitDetail) throws ProductException {

		if (kitDetail != null) {
			kitDetailRepository.save(kitDetail);
		}
		return kitDetail;
	}

	@Override
	public KitDetail getKitItemById(int id) {
		return kitDetailRepository.findById(id).orElse(null);
	}

	@Override
	public List<KitDetail> getAllKitItemsOfAKit(int kitId) {
		return kitDetailRepository.findAllCoronaKitId(kitId);

	}

}
