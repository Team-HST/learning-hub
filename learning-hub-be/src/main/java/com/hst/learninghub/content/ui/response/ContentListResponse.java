package com.hst.learninghub.content.ui.response;

import com.hst.learninghub.content.entity.Content;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
public class ContentListResponse {
	private int page;
	private int size;
	private int totalPage;
	private List<ContentResponse> contents;

	private ContentListResponse(Page<Content> contentPage) {
		this.page = contentPage.getNumber();
		this.size = contentPage.getSize();
		this.totalPage = contentPage.getTotalPages();
		this.contents = contentPage.map(ContentResponse::from).getContent();
	}

	public static ContentListResponse from(Page<Content> page) {
		return new ContentListResponse(page);
	}

	public int getPage() {
		return page;
	}

	public int getSize() {
		return size;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public List<ContentResponse> getContents() {
		return contents;
	}
}
