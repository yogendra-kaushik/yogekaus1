package com.dbs.listfile.service;

import java.io.File;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dbs.listfile.model.FileProperties;

public interface FileService {

	List<FileProperties> getFileDetails(File file);
	
	List<FileProperties> getDirectoryDetails(File file);	
}
