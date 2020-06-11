package com.hst.learninghub.donation.service;

import com.hst.learninghub.donation.entity.ContentDonOrg;
import com.hst.learninghub.donation.entity.ContentDonOrgPK;
import com.hst.learninghub.donation.repository.ContentDonOrgRepository;
import com.hst.learninghub.organization.entity.Organization;
import com.hst.learninghub.organization.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DonationService {

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
}
