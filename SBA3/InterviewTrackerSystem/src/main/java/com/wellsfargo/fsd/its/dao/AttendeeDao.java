package com.wellsfargo.fsd.its.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.its.entity.AttendeeEntity;



@Repository
public interface AttendeeDao extends JpaRepository<AttendeeEntity, Integer>{

	/*
	List<AttendeeEntity> findAllByStatus(String status);
	
	@Query("SELECt a FROM AttendeeEntity a ")
	List<AttendeeEntity> findAllHavingDOBInRange(@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE)LocalDate end);
	*/
}
