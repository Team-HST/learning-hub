package com.hst.learninghub.calculate.service;

import com.hst.learninghub.calculate.entity.Calculate;
import com.hst.learninghub.donation.entity.ContentDonation;
import com.hst.learninghub.donation.entity.Donation;
import com.hst.learninghub.donation.entity.OrgDonation;
import com.hst.learninghub.donation.repository.ContentDonationRepository;
import com.hst.learninghub.donation.repository.OrgDonationRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CalculateService {
	private static final Logger logger = LoggerFactory.getLogger(CalculateService.class);

	private final ContentDonationRepository contentDonationRepository;
	private final OrgDonationRepository orgDonationRepository;

	/**
	 * 정산
	 * @param startAt 정산 시작일
	 * @param endAt 정산 종료일
	 */
	@Transactional
	public void processCalculate(LocalDateTime startAt, LocalDateTime endAt, Calculate calculate) throws Exception {
		List<ContentDonation> contentDonations = contentDonationRepository.findByNotCalculatedDonations(startAt, endAt);
		calculateDonation(contentDonations, calculate, ContentDonation.class);

		List<OrgDonation> orgDonations = orgDonationRepository.findByNotCalculatedDonations(startAt, endAt);
		calculateDonation(orgDonations, calculate, OrgDonation.class);
	}

	private <T extends Donation> void calculateDonation(List<T> donations, Calculate calculate, Class<T> clazz) {
		for (T donation : donations) {
			if (donation.isValid()) {
				donation.markCalculateNo(calculate.getNo());
				if (clazz.isAssignableFrom(ContentDonation.class)) {
					contentDonationRepository.save((ContentDonation) donation);
				} else {
					orgDonationRepository.save((OrgDonation) donation);
				}
			} else {
				logger.warn("비정상 데이터 발견. 정산에서 제외합니다. donation: {}", donation);
			}
		}
	}
}
