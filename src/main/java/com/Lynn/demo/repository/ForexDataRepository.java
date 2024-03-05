package com.Lynn.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Lynn.demo.dto.ForexData;

public interface ForexDataRepository extends JpaRepository<ForexData, Long> {

	List<ForexData> findByDateBetweenAndCurrency(Date startDate, Date endDate, String currency);
}
