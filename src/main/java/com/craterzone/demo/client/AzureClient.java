package com.craterzone.demo.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;

@Component
@Qualifier("azureBean")
public class AzureClient implements FileUploadClient {
	
	@Autowired
	private CloudBlobContainer cloudBlobContainer;
	
	private Logger logger = LoggerFactory.getLogger(AzureClient.class);

	public URI uploadMultipartFile(MultipartFile multipartFile) {
		URI uri = null;
		CloudBlockBlob blob = null;
		try {
			blob = cloudBlobContainer.getBlockBlobReference(multipartFile.getOriginalFilename());
			blob.upload(multipartFile.getInputStream(), -1);
			uri = blob.getUri();
		} catch (URISyntaxException e) {
			logger.error(e.getMessage());
            e.printStackTrace();
		} catch (StorageException e) {
			logger.error(e.getMessage());
            e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
            e.printStackTrace();
		}
		return uri;
	}

	@Override
	public String uploadFile(MultipartFile file) {
		// TODO Auto-generated method stub
		return null;
	}

}
