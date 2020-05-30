package com.hst.learninghub.configuration;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dlgusrb0808@gmail.com
 */
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	public static final String DEV_TOOLS_API_TAG = "0. Dev Tools APIs";
	public static final String CODE_API_TAG = "1. Code APIs";
	public static final String USER_API_TAG = "2. Member APIs";

	@Bean
	public Docket api() {
		List<Parameter> params = createGlobalParameters();

		return new Docket(DocumentationType.SWAGGER_2)
				.globalOperationParameters(params)
				.select()
				.apis(Predicates.not(RequestHandlerSelectors.
						basePackage("org.springframework.boot")))
				.paths(PathSelectors.any())
				.build()
				.tags(
					new Tag(DEV_TOOLS_API_TAG, "개발자 편의 기능 제공 API", 1),
					new Tag(CODE_API_TAG, "전체 시스템에서 사용하는 코드 관련 API", 2),
					new Tag(USER_API_TAG, "회원(사용자) 관련 API", 3)
				)
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	private List<Parameter> createGlobalParameters() {
		List<Parameter> params = new ArrayList<>();
		params.add(new ParameterBuilder()
				.name("Authorization")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.defaultValue("Bearer ")
				.description("인증토큰 (Bearer 타입)")
				.required(false)
				.build());
		return params;
	}

	private ApiInfo apiInfo() {
		return new ApiInfo(
				"LearningHub Service API",
				"이 문서는 LearningHub 개발을 위한 Service API 명세서입니다.",
				"1.0.0",
				"",
				new Contact("Team HST", "", "dl_hst@gmail.com"),
				"",
				"", Collections.emptyList());
	}
}
