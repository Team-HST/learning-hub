package com.hst.learninghub.user.ui.response;

import com.hst.learninghub.donation.entity.ContDonation;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserRevenueResponse {
    /*
        총 수익금: CONT_DONATION 에서 조회 가능(내가 작성한 컨텐츠번호로 조회)
        당월 누적 수익금: CONT_DONATION 에서 정산일시가 없는 ROW 로 조회 가능
        현재 수익금(잔액): 총 수익금 - 수령 금액
        인출 가능한 수익금: CONT_DONATION 에서 조회한 정산된 총 수익금 - 수령 금액
        총 수령금
     */

    private Long totalRevAmount = 0L;    // 총 수익금
    private Long monthRevAmount = 0L;    // 당월 누적 수익금
    private Long currentRevAmount;  // 현재 수익금
    private Long withdrawRevAmount; // 인출 가능한 수익금
    private Long totReceiptAmount;  // 총 수령금

    public static UserRevenueResponse userRevenueStatus(List<ContDonation> contDonationList, Long totReceiptAmount) {
        UserRevenueResponse userRevResponse = new UserRevenueResponse();
        if (contDonationList != null && totReceiptAmount != null) {
            long totCalcAmount = 0;    // 총 정산금

            /** 총 수익금, 당월 누적 수익금 계산 */
            for (ContDonation contDonation : contDonationList) {
                userRevResponse.totalRevAmount += contDonation.getAmount(); // 총 수익금

                // 정산된 금액인 경우
                if (contDonation.getCalculateNo() != null) {
                    totCalcAmount += contDonation.getAmount();

                // 정산 되지 않은 금액인 경우
                } else {
                    userRevResponse.monthRevAmount += contDonation.getAmount(); // 당월 누적 수익금(미정산금)
                }
            }
            /** 현재 수익금(총 수익금 - 총 수령금) */
            userRevResponse.currentRevAmount = userRevResponse.totalRevAmount - totReceiptAmount;
            /** 인출 가능한 수익금(총 정산금 - 총 수령금) */
            userRevResponse.withdrawRevAmount = totCalcAmount - totReceiptAmount;
            userRevResponse.totReceiptAmount = totReceiptAmount;
        }
        return userRevResponse;
    }
}
