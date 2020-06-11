package com.hst.learninghub.calculate.service;

import com.hst.learninghub.calculate.entity.Calculate;
import com.hst.learninghub.calculate.repository.CalculateRepository;
import com.hst.learninghub.calculate.type.CalculateType;
import com.hst.learninghub.donation.entity.ContDonation;
import com.hst.learninghub.donation.entity.OrgDonation;
import com.hst.learninghub.donation.repository.ContentDonRepository;
import com.hst.learninghub.donation.repository.OrgDonationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CalculateService {
    private static final Logger logger = LoggerFactory.getLogger(CalculateService.class);
    private CalculateRepository calculateRepository;
    private ContentDonRepository contentDonRepository;
    private OrgDonationRepository orgDonationRepository;

    public CalculateService(CalculateRepository calculateRepository, ContentDonRepository contentDonRepository
                            , OrgDonationRepository orgDonationRepository) {
        this.calculateRepository = calculateRepository;
        this.contentDonRepository = contentDonRepository;
        this.orgDonationRepository = orgDonationRepository;
    }

    /**
     * 주기 정산(매월 5일)
     * @param calcStartDate
     * @param calcEndDate
     * @return
     */
    @Transactional
    public void periodicalCalculate(LocalDateTime calcStartDate, LocalDateTime calcEndDate, Calculate calculate) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        try {
            // 1. 사용자측 기부금 - 정산되지 않은 내역 조회(전월 1일~말일)
            List<ContDonation> contDonationList = contentDonRepository.findByNullToCalculateNo();

            if (contDonationList != null) {
                for (ContDonation contDonation : contDonationList) {
                    if (!contDonation.isValid()) {
                        logger.debug("======================= CONTDONATION DOES NOT HAVE A REQUIRED VALUE !!! : [{}]", contDonation);
                    } else {
                        contDonation.successCalculate(calculate.getNo());
                        contentDonRepository.save(contDonation);
                    }
                }
            }

            // 2. 기관측 기부금 - 정산되지 않은 내역 조회(전월 1일~말일)
            List<OrgDonation> orgDonationList = orgDonationRepository.findByNullToCalculateNo();

            if (orgDonationList != null) {
                for (OrgDonation orgDonation : orgDonationList) {
                    if (!orgDonation.isValid()) {
                        logger.debug("======================= ORGDONATION DOES NOT HAVE A REQUIRED VALUE !!!: [{}]", orgDonation);
                    } else {
                        orgDonation.successCalculate(calculate.getNo());
                        orgDonationRepository.save(orgDonation);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("========================= PERIODICAL CALCULATE IS FAILED !!!", e);
        }
    };
}
