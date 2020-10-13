package com.wellsfargo.fsd.its.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Repository;

import com.wellsfargo.fsd.its.entity.InterviewEntity;
import com.wellsfargo.fsd.its.entity.UserEntity;


@Repository
public interface InterviewDao extends JpaRepository<InterviewEntity, Integer>{

	List<InterviewEntity> findAllByinterviewStatus(String interviewStatus);
	
	/*
	@Query("SELECt i FROM InterviewEntity i ")
	List<InterviewEntity> findAllHavingDOBInRange(@DateTimeFormat(iso=ISO.DATE) LocalDate start,@DateTimeFormat(iso=ISO.DATE)LocalDate end);
	*/
}
