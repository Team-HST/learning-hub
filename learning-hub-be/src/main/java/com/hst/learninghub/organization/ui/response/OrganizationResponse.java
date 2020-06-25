package com.hst.learninghub.organization.ui.response;

import com.hst.learninghub.file.ui.response.FileResponse;
import com.hst.learninghub.organization.entity.Organization;
import lombok.Builder;
import lombok.Getter;

/**
 * @author dlgusrb0808@gmail.com
 */
@Getter
@Builder
public class OrganizationResponse {
	private Long no;
	private String name;
	private String address;
	private String phoneNumber;
	private FileResponse thumbnail;
	private long totalDonations;

	public static OrganizationResponse of(Organization organization, long totalDonations) {
		return builder()
				.no(organization.getNo())
				.name(organization.getName())
				.address(organization.getAddress())
				.phoneNumber(organization.getPhoneNumber())
				.thumbnail(FileResponse.from(organization.getThumbnail()))
				.totalDonations(totalDonations)
				.build();
	}
}
