package com.Lynn.demo.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Lynn.demo.dto.ForexData;
import com.Lynn.demo.repository.ForexDataRepository;

@Service
public class ForexDataService {

    private final ForexDataRepository forexDataRepository;

    @Autowired
    public ForexDataService(ForexDataRepository forexDataRepository) {
        this.forexDataRepository = forexDataRepository;
    }

    // 根據日期範圍和貨幣查詢外匯數據的方法
    public List<ForexData> findForexDataByDateRangeAndCurrency(Date startDate, Date endDate, String currency) {
        return forexDataRepository.findByDateBetweenAndCurrency(startDate, endDate, currency);
    }
}
