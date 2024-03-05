package com.Lynn.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Lynn.demo.dto.ErrorResponse;
import com.Lynn.demo.dto.ForexData;
import com.Lynn.demo.dto.ForexRequest;
import com.Lynn.demo.repository.ForexDataRepository;

@RestController
public class ForexDataController {

	 private final ForexDataRepository forexDataRepository;

	    public ForexDataController(ForexDataRepository forexDataRepository) {
	        this.forexDataRepository = forexDataRepository;
	    }

	    @PostMapping("/forex")
	    public ResponseEntity<?> getForexData(@RequestBody ForexRequest request) {
	        Date startDate = request.getStartDate();
	        Date endDate = request.getEndDate();

	        // 檢查日期區間是否有效
	        if (startDate.after(endDate)) {
	            return ResponseEntity.badRequest().body(new ErrorResponse("E001", "日期區間不符"));
	        }

	        List<ForexData> forexDataList = forexDataRepository.findByDateBetweenAndCurrency(startDate, endDate, request.getCurrency());
	        return ResponseEntity.ok(forexDataList);
	    }
}
