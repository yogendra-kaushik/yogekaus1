package com.dbs.listfile.model;

/**
 * @author Yogendra Kaushik
 *
 */
public class FileProperties {

	private String fileName;
	private String filePath;
	private Long fileSize;
	private String fileDirFlag;
	private static final long MB = 1024L * 1024L;

	public static long KBToMB(long KB) {
		return KB / MB;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName
	 *            the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @param filePath
	 *            the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @return the fileSize
	 */
	public Long getFileSize() {
		return KBToMB(fileSize);
	}

	/**
	 * @param fileSize
	 *            the fileSize to set
	 */
	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	/**
	 * @return the fileDirFlag
	 */
	public String getFileDirFlag() {
		return fileDirFlag;
	}

	/**
	 * @param fileDirFlag the fileDirFlag to set
	 */
	public void setFileDirFlag(String fileDirFlag) {
		this.fileDirFlag = fileDirFlag;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileProperties [fileName=" + fileName + ", filePath=" + filePath + ", fileSize=" + fileSize
				+ ", fileDirFlag=" + fileDirFlag + "]";
	}


}
