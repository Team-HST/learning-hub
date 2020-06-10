package com.hst.learninghub.file.model;

import org.springframework.http.MediaType;

/**
 * @author dlgusrb0808@gmail.com
 */
public class FileRawData {
	private MediaType mediaType;
	private byte[] rawData;

	public MediaType getMediaType() {
		return mediaType;
	}

	public byte[] getRawData() {
		return rawData;
	}

	public static FileRawData of(String mediaType, byte[] rawData) {
		FileRawData fileRawData = new FileRawData();
		fileRawData.mediaType = MediaType.parseMediaType(mediaType);
		fileRawData.rawData = rawData;
		return fileRawData;
	}
}
