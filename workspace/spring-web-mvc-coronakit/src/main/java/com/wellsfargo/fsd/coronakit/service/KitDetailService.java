package com.wellsfargo.fsd.coronakit.service;

import java.util.List;

import com.wellsfargo.fsd.coronakit.entity.KitDetail;

public interface KitDetailService {
	public KitDetail addKitItem(KitDetail kitItem);
	public KitDetail getKitItemById(int itemId);
	public List<KitDetail> getAllKitItemsOfAKit(int kitId);
}
