package com.craterzone.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.craterzone.demo.service.FileUploadService;

@RestController
@RequestMapping("api/v1/upload")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping
	public ResponseEntity<String> uploadFile(@RequestParam(value = "client") String client,
			@RequestPart(value = "file") MultipartFile file) {
		String url = this.fileUploadService.uploadFile(file, client);

		if (url != null) {
			return ResponseEntity.status(HttpStatus.OK).body(url);
		}
		return ResponseEntity.badRequest().build();
	}
}
