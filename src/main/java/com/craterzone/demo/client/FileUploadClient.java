package com.craterzone.demo.client;

import java.net.URI;

import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadClient {

	public String uploadFile(@RequestPart (value = "file") MultipartFile file);
	public URI uploadMultipartFile(@RequestPart(value = "file") MultipartFile file);
}
