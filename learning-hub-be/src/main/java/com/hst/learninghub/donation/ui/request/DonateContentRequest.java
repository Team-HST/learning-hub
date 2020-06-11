package com.hst.learninghub.donation.ui.request;

import com.hst.learninghub.content.entity.Content;
import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Builder
@Getter
public class DonateContentRequest {
	private Content content;
	private Long orgNo;
	private Integer donationAmount;
	private Long donateUserNo;
}
