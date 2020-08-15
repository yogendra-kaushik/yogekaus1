package com.dbs.listfile.FileDirectoryProperties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan (basePackages = { "com.dbs.listfile.*"})
@SpringBootApplication
@EntityScan("com.dbs.listfile.model.*")
public class FileDirectoryPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileDirectoryPropertiesApplication.class, args);
	}
}
