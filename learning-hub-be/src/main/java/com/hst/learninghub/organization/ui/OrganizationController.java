package com.hst.learninghub.organization.ui;

import com.hst.learninghub.configuration.SwaggerConfiguration;
import com.hst.learninghub.organization.service.OrganizationService;
import com.hst.learninghub.organization.ui.request.OrganizationModifyingRequest;
import com.hst.learninghub.organization.ui.response.OrganizationResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@RestController
@RequestMapping("organizations")
@Api(tags = SwaggerConfiguration.ORGANIZATION_TAG)
@RequiredArgsConstructor
@Slf4j
public class OrganizationController {

	private final OrganizationService organizationService;

	@ApiOperation(value = "기관 목록 조회", notes = "기부가능한 모든 기관을 등록합니다.")
	@GetMapping
	public ResponseEntity<List<OrganizationResponse>> getAll() {
		return ResponseEntity.ok(organizationService.getAll());
	}

	@ApiOperation(value = "기관 등록", notes = "기관을 등록합니다.")
	@PostMapping
	public ResponseEntity<OrganizationResponse> createContent(
			OrganizationModifyingRequest request,
			@RequestParam(name = "thumbnail") MultipartFile thumbnail) throws Exception {
		request.setThumbnail(thumbnail);
		OrganizationResponse response = organizationService.createOrganization(request);
		return ResponseEntity.ok(response);
	}
}
