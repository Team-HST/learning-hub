package com.hst.learninghub.donation.service;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.donation.entity.ContentDonation;
import com.hst.learninghub.donation.entity.ContentDonationOrg;
import com.hst.learninghub.donation.entity.ContentDonationOrgId;
import com.hst.learninghub.donation.entity.OrgDonation;
import com.hst.learninghub.donation.repository.ContentDonOrgRepository;
import com.hst.learninghub.donation.repository.ContentDonRepository;
import com.hst.learninghub.donation.repository.OrgDonationRepository;
import com.hst.learninghub.donation.ui.request.DonateContentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DonationService {

	private final ContentDonRepository contentDonationRepository;
	private final OrgDonationRepository orgDonationRepository;
	private final ContentDonOrgRepository contentDonationOrgRepository;

	/***
	 * 컨텐츠 -> 기관 매핑
	 * @param contentNo 컨텐츠 번호
	 * @param organizationNo 기관 번호
	 * @param registrantNo 등록 사용자 번호
	 */
	public void addContentDonationOrg(Long contentNo, Long organizationNo, Long registrantNo) {
		contentDonationOrgRepository.save(ContentDonationOrg.builder()
				.id(ContentDonationOrgId.of(contentNo, organizationNo))
				.deleted(false)
				.registrantNo(registrantNo)
				.build());
	}

	/***
	 * 후원하기
	 * @param request 후원 요청
	 */
	@Transactional
	public void donate(DonateContentRequest request) {
		Content content = request.getContent();
		long contentProceeds = Math.round(request.getDonationAmount() * content.getDonationRatio() * 0.01);
		long orgProceeds = request.getDonationAmount() - contentProceeds;


		contentDonationRepository.save(ContentDonation.builder()
				.contentNo(content.getNo())
				.amount(contentProceeds)
				.donUserNo(request.getDonateUserNo())
				.build());

		orgDonationRepository.save(OrgDonation.builder()
				.contentNo(content.getNo())
				.amount(orgProceeds)
				.regUserNo(request.getDonateUserNo())
				.orgNo(request.getOrgNo())
				.build());
	}

	/***
	 * 기관이 획득한 총 기부금 조회
	 * @param no
	 * @return
	 */
	public long getTotalDonations(Long no) {
		List<OrgDonation> list = orgDonationRepository.findAllByOrgNo(no);
		return list.stream().mapToLong(OrgDonation::getAmount).sum();
	}
}
