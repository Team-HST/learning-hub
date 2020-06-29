package com.hst.learninghub.content.type;

import com.hst.learninghub.common.converter.EnumAttributeConverter;
import com.hst.learninghub.common.type.PersistableType;
import com.hst.learninghub.utils.EnumUtils;

import java.util.Map;

/**
 * @author dlgusrb0808@gmail.com
 */
public enum JobCategory implements PersistableType<String> {
	OFFICE("J001", "경영 / 사무", "경영 / 사무 카테고리"),
	MEDIA("J002", "미디어", "미디어 카테고리"),
	SPECIAL("J003", "전문 / 특수직", "전문 / 특수직 카테고리"),
	IT("J004", "IT / 인터넷", "IT / 인터넷 카테고리"),
	RND("J005", "연구개발 / 설계", "연구개발 / 설계 카테고리"),
	ERECTION("J006", "건설", "건설 카테고리"),
	MARKETING("J007", "마케팅 / 광고 / 홍보", "마케팅 / 광고 / 홍보 카테고리"),
	PRODUCT("J008", "생산 / 제조", "생산 / 제조 카테고리"),
	MEDICAL("J009", "의료", "의료 카테고리"),
	TRADE("J010", "무역 / 유통", "무역 / 유통 카테고리"),
	DESIGN("J011", "디자인", "디자인 카테고리"),
	EDUCATION("J012", "교육", "교육 카테고리"),
	SERVICE("J013", "서비스", "서비스 카테고리")
	;

	private static final Map<String, JobCategory> FINDER = EnumUtils.asMap(JobCategory.class);

	private String code;
	private String codeName;
	private String description;

	JobCategory(String code, String codeName, String description) {
		this.code = code;
		this.codeName = codeName;
		this.description = description;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public String getCodeName() {
		return codeName;
	}

	@Override
	public String getDescription() {
		return description;
	}

	public static JobCategory get(String code) {
		return FINDER.get(code);
	}

	public static class Converter extends EnumAttributeConverter<JobCategory, String> {
		public Converter() {
			super(JobCategory.class, false);
		}
	}
}
