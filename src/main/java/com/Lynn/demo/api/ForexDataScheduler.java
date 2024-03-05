package com.Lynn.demo.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.Lynn.demo.dto.ForexApiResponse;
import com.Lynn.demo.dto.ForexData;
import com.Lynn.demo.dto.ForexDataResponse;
import com.Lynn.demo.repository.ForexDataRepository;

import jakarta.transaction.Transactional;

@Component
public class ForexDataScheduler {

	private final RestTemplate restTemplate;
    private final ForexDataRepository forexDataRepository;

    @Value("https://openapi.taifex.com.tw/v1/DailyForeignExchangeRates")
    private String forexApiUrl;

    public ForexDataScheduler(RestTemplate restTemplate, ForexDataRepository forexDataRepository) {
        this.restTemplate = restTemplate;
        this.forexDataRepository = forexDataRepository;
    }

    @Transactional
    @Scheduled(cron = "0 0 18 * * *") // 每日18:00執行
    public void fetchAndSaveForexData() {
        ResponseEntity<ForexApiResponse> response = restTemplate.getForEntity(forexApiUrl, ForexApiResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            ForexApiResponse forexApiResponse = response.getBody();
            if (forexApiResponse != null && forexApiResponse.getCurrency() != null) {
                for (ForexDataResponse dataResponse : forexApiResponse.getCurrency()) {
                    ForexData forexData = new ForexData();
                    forexData.setDate(dataResponse.getDate());
                    forexData.setUsdToNtd(Double.valueOf(dataResponse.getUsd()));
                    forexDataRepository.save(forexData);
                }
            }
        }
    }
}
