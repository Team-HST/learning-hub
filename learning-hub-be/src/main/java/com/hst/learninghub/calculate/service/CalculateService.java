package com.hst.learninghub.calculate.service;

import com.hst.learninghub.calculate.repository.CalculateRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculateService {
    private CalculateRepository calculateRepository;

    public CalculateService(CalculateRepository calculateRepository) {
        this.calculateRepository = calculateRepository;
    }

    /**
     * 주기 정산(매월 5일)
     * @param calcStartDate
     * @param calcEndDate
     * @return Map
     */
    public Map<String, Object> periodicalCalculate(LocalDateTime calcStartDate, LocalDateTime calcEndDate) {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        return resultMap;
    };
}
