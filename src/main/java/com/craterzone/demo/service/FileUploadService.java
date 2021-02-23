package com.craterzone.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.craterzone.demo.client.FileUploadClient;
import com.microsoft.azure.storage.core.Logger;

@Service
public class FileUploadService {

	@Autowired
	@Qualifier("awsBean")
	FileUploadClient AWSClient;
	
	@Autowired
	@Qualifier("azureBean")
	FileUploadClient AzureClient;
	
	public String uploadFile(MultipartFile file,String client){
		
		if(client.equals("AWS")) {
			return AWSClient.uploadFile(file);
		}
		
		else if(client.equals("Azure")) {
			return AzureClient.uploadMultipartFile(file).toString();
		}
		return "";
	}
}
