/**
 * 
 */
package com.dbs.listfile.controller;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.listfile.model.FileProperties;
import com.dbs.listfile.service.FileService;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * @author Yogendra
 *
 */
@CrossOrigin
@RestController
@RequestMapping("/property/v1")
public class FilePropertiesControler {

	// @Value("${local.directoryPath}")
	String path;

	@Autowired
	private FileService fileService;

	List<FileProperties> filesDirDetails;
	File directoryPath = new File("C:\\EricssonDocs\\Test");

	@GetMapping("/file")
	public List<FileProperties> getFileProperties() {
		if (directoryPath.exists()) {
			filesDirDetails = fileService.getFileDetails(directoryPath);
		} else {
			System.out.println("Unable to read location");
		}
		if (!filesDirDetails.isEmpty()) {
			return filesDirDetails;
		} else {
			return new ArrayList<>();
		}
	}

	@GetMapping("/directory")
	public List<FileProperties>  getDirectoryProperties() {
		if (directoryPath.exists()) {
			filesDirDetails = fileService.getDirectoryDetails(directoryPath);
		} else {
			System.out.println("Unable to read location");
		}
		if (!filesDirDetails.isEmpty()) {
			return filesDirDetails;
		} else {
			return new ArrayList<>();
		}
	}

}
