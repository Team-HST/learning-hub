package com.hst.learninghub.file.service;

import com.hst.learninghub.configuration.properties.AppProperties;
import com.hst.learninghub.file.entity.FileInfo;
import com.hst.learninghub.file.repository.FileRepository;
import com.hst.learninghub.file.type.FileType;
import com.hst.learninghub.utils.FileUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author dlgusrb0808@gmail.com
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FileService implements InitializingBean {
	private final AppProperties appProperties;

	private final FileRepository fileRepository;

	@Transactional
	public FileInfo uploadFile(MultipartFile targetFile, FileType fileType) throws Exception {
		String savePath = appProperties.getFiles().getBaseDirectory();
		String extension = FileUtils.getExtension(targetFile.getOriginalFilename());
		File saveDestination = new File(savePath, FileUtils.generateFileName());

		targetFile.transferTo(saveDestination);

		FileInfo fileInfo = FileInfo.builder()
				.savedName(String.format("%s.%s", saveDestination.getName(), extension))
				.originalName(targetFile.getOriginalFilename())
				.extention(extension)
				.fileType(fileType)
				.size(saveDestination.length())
				.path(savePath)
				.deleted(false)
				.build();

		return fileRepository.save(fileInfo);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		File baseDirectory = new File(appProperties.getFiles().getBaseDirectory());
		baseDirectory.mkdirs();
	}
}
