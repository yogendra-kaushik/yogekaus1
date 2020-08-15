package com.dbs.listfile.serviceImpl;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dbs.listfile.model.FileProperties;
import com.dbs.listfile.service.FileService;

import com.dbs.listfile.model.FileProperties;

@Service
public class FileServiceImpl implements FileService {

	List<FileProperties> filesDetails = new ArrayList<FileProperties>();

	@Override
	public List<FileProperties> getFileDetails(File directoryPath) {
		if (!filesDetails.isEmpty()) {
			filesDetails.clear();
		}
		FileFilter textFilefilter = new FileFilter() {
			public boolean accept(File file) {
				boolean isFile = file.isFile();
				if (isFile) {
					return true;
				} else {
					return false;
				}
			}
		};

		File filesList[] = directoryPath.listFiles(textFilefilter);
		System.out.println("List of the files in the specified directory:");
		try {
			for (File file : filesList) {
				populateProperties(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filesDetails;
	}

	private void populateProperties(File file) {
		FileProperties fileProperties = new FileProperties();

		fileProperties.setFileName(file.getName());
		fileProperties.setFilePath(file.getAbsolutePath());
		fileProperties.setFileSize(file.getTotalSpace());
		fileProperties.setFileDirFlag(file.isDirectory() ? "D" : "F");
		filesDetails.add(fileProperties);
	}

	@Override
	public List<FileProperties> getDirectoryDetails(File directoryPath) {
		try {
			File[] files = directoryPath.listFiles();
			for (File file : files) {
				if (file.isDirectory()) {
					populateProperties(file);
					getDirectoryDetails(file);
				} else {
					populateProperties(file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filesDetails;
	}
}
