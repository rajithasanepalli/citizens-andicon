package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

public class PayrollSftpFileDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;
	private String filePath;
	private LocalDateTime fileDate;
	
	
	public LocalDateTime getFileDate() {
		return fileDate;
	}
	public void setFileDate(LocalDateTime fileDate) {
		this.fileDate = fileDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	@Override
	public String toString() {
		return "PayrollSftpFileDetailsDTO [fileName=" + fileName
				+ ", filePath=" + filePath + ", fileDate=" + fileDate + "]";
	}

	

}
