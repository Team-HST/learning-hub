package com.hst.learninghub.calculate.service;

import com.hst.learninghub.calculate.entity.Calculate;
import com.hst.learninghub.calculate.repository.CalculateRepository;
import com.hst.learninghub.calculate.type.CalculateType;
import com.hst.learninghub.donation.entity.ContDonation;
import com.hst.learninghub.donation.repository.ContentDonOrgRepository;
import com.hst.learninghub.donation.repository.ContentDonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculateService {
    private static final Logger logger = LoggerFactory.getLogger(CalculateService.class);
    private CalculateRepository calculateRepository;
    private ContentDonRepository contentDonRepository;
    private ContentDonOrgRepository contentDonOrgRepository;

    public CalculateService(CalculateRepository calculateRepository, ContentDonRepository contentDonRepository
                            , ContentDonOrgRepository contentDonOrgRepository) {
        this.calculateRepository = calculateRepository;
        this.contentDonRepository = contentDonRepository;
        this.contentDonOrgRepository = contentDonOrgRepository;
    }

    /**
     * 주기 정산(매월 5일)
     * @param calcStartDate
     * @param calcEndDate
     * @return Map
     */
    public Map<String, Object> periodicalCalculate(LocalDateTime calcStartDate, LocalDateTime calcEndDate) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        // 정산 내역 생성

        Calculate calculate = calculateRepository.findMaxId();
        if (calculate == null) {
            calculate = Calculate.builder()
                    .no(0L)
                    .calcType(CalculateType.PERIODICAL.getCode())
                    .build();
        }
        // 1. 사용자측 기부금 - 정산되지 않은 내역 조회(전월 1일~말일)
        List<ContDonation> contDonationList = contentDonRepository.findByNullToCalculateNo();

        if (contDonationList != null) {
            for (ContDonation contDonation : contDonationList) {
                contDonation = contDonation.builder()
                            .calculateNo(calculate.getNo())
                            .build();
                logger.debug("====================== ContDonation: ", contDonation.toString());
                // 정산 유효성 확인 후 정산번호 세팅 후 SAVE
            }
        }

        return resultMap;
    };
}
