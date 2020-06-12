package com.hst.learninghub.user.ui.response;

import com.hst.learninghub.donation.entity.ContDonation;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class UserDonationResponse {
    private Long totalDonAmount;    // 총 기부금액

    public static UserDonationResponse userDonationStatus(Long totalDonAmount) {
        UserDonationResponse userDonationResponse = new UserDonationResponse();
        userDonationResponse.totalDonAmount = totalDonAmount;
        return userDonationResponse;
    }
}