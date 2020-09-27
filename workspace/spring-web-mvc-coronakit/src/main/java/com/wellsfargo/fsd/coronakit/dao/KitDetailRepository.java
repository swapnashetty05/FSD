package com.wellsfargo.fsd.coronakit.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.coronakit.entity.KitDetail;



@Repository
public interface KitDetailRepository extends JpaRepository<KitDetail, Integer>{

}
