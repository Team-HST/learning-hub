package com.hst.learninghub.file.service;

import com.hst.learninghub.common.exception.NotFoundException;
import com.hst.learninghub.configuration.properties.AppProperties;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.model.FileRawData;
import com.hst.learninghub.file.repository.FileRepository;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FileService implements InitializingBean {
	private final AppProperties appProperties;

	private final FileRepository fileRepository;

	private final ResourceLoader resourceLoader;

	@Transactional
	public FileInfo uploadFile(MultipartFile targetFile, FileType fileType) throws Exception {
		String extension = FileUtils.getExtension(targetFile.getOriginalFilename());
		String saveDirectory = appProperties.getFiles().getBaseDirectory();
		String saveFileName = FileUtils.generateFileName(extension);
		File saveDestination = new File(saveDirectory, saveFileName);

		targetFile.transferTo(saveDestination);

		FileInfo fileInfo = FileInfo.builder()
				.savedName(saveFileName)
				.originalName(targetFile.getOriginalFilename())
				.extention(extension)
				.fileType(fileType)
				.size(saveDestination.length())
				.path(saveDirectory)
				.deleted(false)
				.build();

		return fileRepository.save(fileInfo);
	}

	/***
	 * 파일 raw data 획득
	 * @param fileNo 파일 No
	 * @return 파일 데이터
	 * @throws IOException file 읽기에 실패한 경우
	 */
	public FileRawData getFileRawData(Long fileNo) throws IOException {
		Resource fileResource = resourceLoader.getResource(String.format("file:%s",getFileSavedPath(fileNo)));
		if (!fileResource.exists()) {
			throw new NotFoundException("파일", fileNo);
		}

		Path filePath = Paths.get(fileResource.getURI());
		return FileRawData.of(Files.probeContentType(filePath), Files.readAllBytes(filePath));
	}

	private String getFileSavedPath(Long fileNo) {
		return fileRepository.findById(fileNo).map(FileInfo::getSavedPath)
				.orElseThrow(() -> new NotFoundException("파일", fileNo));
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		File baseDirectory = new File(appProperties.getFiles().getBaseDirectory());
		baseDirectory.mkdirs();
	}
}
