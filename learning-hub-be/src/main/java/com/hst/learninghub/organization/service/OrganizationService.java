package com.hst.learninghub.organization.service;

import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.service.FileService;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.organization.entity.Organization;
import com.hst.learninghub.organization.repository.OrganizationRepository;
import com.hst.learninghub.organization.ui.request.OrganizationModifyingRequest;
import com.hst.learninghub.organization.ui.response.OrganizationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
public class OrganizationService {

	private final OrganizationRepository organizationRepository;
	private final FileService fileService;


	@Transactional
	public OrganizationResponse createOrganization(OrganizationModifyingRequest request) throws Exception {
		FileInfo uploadedFile = fileService.uploadFile(request.getThumbnail(), FileType.THUMBNAIL);
		Organization organization = organizationRepository.save(Organization.builder()
				.name(request.getName())
				.address(request.getAddress())
				.phoneNumber(request.getPhoneNumber())
				.registrantUserNo(request.getRegistrantNo())
				.thumbnail(uploadedFile)
				.deleted(false)
				.build());
		return OrganizationResponse.from(organization);
	}

	public List<OrganizationResponse> getAll() {
		return organizationRepository.findAll().stream()
				.map(OrganizationResponse::from)
				.collect(Collectors.toList());
	}
}
