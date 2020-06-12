package com.hst.learninghub.donation.service;

import com.hst.learninghub.content.entity.Content;
import com.hst.learninghub.donation.entity.ContDonation;
import com.hst.learninghub.donation.entity.ContentDonOrg;
import com.hst.learninghub.donation.entity.ContentDonOrgPK;
import com.hst.learninghub.donation.entity.OrgDonation;
import com.hst.learninghub.donation.repository.ContentDonOrgRepository;
import com.hst.learninghub.donation.repository.ContentDonRepository;
import com.hst.learninghub.donation.repository.OrgDonationRepository;
import com.hst.learninghub.donation.ui.request.DonateContentRequest;
import com.hst.learninghub.organization.entity.Organization;
import com.hst.learninghub.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonationService {

	private final ContentDonRepository contentDonationRepository;
	private final OrgDonationRepository orgDonationRepository;
	private final ContentDonOrgRepository contentDonationOrgRepository;
	private final OrganizationService organizationService;

	/***
	 * 컨텐츠 -> 기관 매핑
	 * @param contentNo 컨텐츠 번호
	 * @param organizationNo 기관 번호
	 * @param registrantNo 등록 사용자 번호
	 */
	public void addContentDonationOrg(Long contentNo, Long organizationNo, Long registrantNo) {
		contentDonationOrgRepository.save(ContentDonOrg.builder()
				.pk(ContentDonOrgPK.of(contentNo, organizationNo))
				.deleted(false)
				.regUserNo(registrantNo)
				.build());
	}

	/***
	 * 컨텐츠에 매핑된 기관 조회
	 * @param contentNo 컨텐츠 No
	 * @return 기관 목록
	 */
	public List<Organization> getContentDonationOrgs(Long contentNo) {
		return contentDonationOrgRepository.findAllContentDonationOrgs(contentNo)
				.stream()
				.map(cdo -> organizationService.getOrganization(cdo.getPk().getOrgNo()))
				.collect(Collectors.toList());
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


		contentDonationRepository.save(ContDonation.builder()
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

}
