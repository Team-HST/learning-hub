package com.hst.learninghub.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.YearMonth;

@Component
public class CalculateScheduler {
    private static final Logger logger = LoggerFactory.getLogger(CalculateScheduler.class);

    /**
     * cron(* * * * * *)    > 초, 분, 시간, 일, 월, 요일
     * ************************************************
     *      초      분     시간     일      월      요일
     *    (0-59)  (0-59) (0-23)  (1-31)  (1-12)  (0-7)
     * ************************************************
     */

    /**
     * 매월 5일 정산(이전 달 기준)
     */
    // @Scheduled(cron = "* * * 5 * *") /* 실제 서비스용 */
    @Scheduled(fixedDelay = 300000) /* 개발용(5분에 1번) */
    public void periodicalCalculate() {
        LocalDateTime now = LocalDateTime.now();        // 현재 일시
        LocalDateTime calcTargetDate = LocalDateTime.now().minusMonths(1);   // 정산 기준 일시(이전 달)
        LocalDateTime calcStartDate = null;             // 정산 시작 일시
        LocalDateTime calcEndDate = null;               // 정산 마감 일시

        YearMonth month = YearMonth.from(calcTargetDate);

        int calcYear = calcTargetDate.getYear();        // 정산 기준년도
        int calcMonth = calcTargetDate.getMonthValue(); // 정산 기준월
        int calcEndDay = month.lengthOfMonth();         // 정산 마감일
        int calcEndHour = 23;                           // 정산 마감 시, 분, 초
        int calcEndMinutes = 59;
        int calcEndSeconds = 59;

        calcStartDate = LocalDateTime.of(calcYear, calcMonth, 1, 0, 0, 0);              // ex: 2020-05-01 00:00:00
        calcEndDate = LocalDateTime.of(calcYear, calcMonth, calcEndDay, calcEndHour, calcEndMinutes, calcEndSeconds); // ex: 2020-05-31 23:59:59

        try {
            // 정산 시작(UPDATE, INSERT)

        } catch (Exception e) {
            // 정산 실패 처리
            logger.error("=================== CALCULATE IS FAILED !!!"); // 임시
        }
    }

    /**
     * 즉시 정산(특정 사용자 기준)
     */
    @Scheduled(cron = "* * * * * * ")
    public void immediateCalculate() {

    }

}
