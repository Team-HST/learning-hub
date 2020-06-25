package com.hst.learninghub.schedule;

import com.hst.learninghub.calculate.entity.Calculate;
import com.hst.learninghub.calculate.repository.CalculateRepository;
import com.hst.learninghub.calculate.service.CalculateService;
import com.hst.learninghub.calculate.type.CalculateType;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class CalculateScheduler {
    private static final Logger logger = LoggerFactory.getLogger(CalculateScheduler.class);

    private final CalculateService calculateService;
    private final CalculateRepository calculateRepository;

    /**
     * 매월 5일 정산(이전 달 기준)
     */
    @Scheduled(fixedDelay = 300000)
    @Transactional
    public void periodicalCalcSchedule() {
        logger.info("[정산 서비스] 주기 정산 시작");

        LocalDate calculateTargetDate = LocalDate.now().minusMonths(1);
        LocalDateTime calcStartDate = calculateTargetDate.atTime(LocalTime.MIN);
        LocalDateTime calcEndDate = calculateTargetDate.atTime(LocalTime.MAX);

        // 정산 내역 생성
        Calculate calculateInfo = Calculate.builder()
                .calcSuccess(true)
                .calcType(CalculateType.PERIODICAL)
                .build();
        calculateRepository.save(calculateInfo);

        try {
            calculateService.processCalculate(calcStartDate, calcEndDate, calculateInfo);
        } catch (Exception e) {
            logger.error("[정산 서비스] 주기 정산 실패", e);
            calculateInfo.markFailed();
        }

        logger.info("[정산 서비스] 주기 정산 종료. 성공 여부: {}", calculateInfo.getCalcSuccess());

        calculateRepository.save(calculateInfo);
    }

//    /**
//     * 즉시 정산(특정 사용자 기준)
//     */
//    @Scheduled(cron = "* * * * * * ")
//    public void immediateCalcSchedule() {
//
//    }
}
