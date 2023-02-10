package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.View;

public class FileDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonView(View.Statement.class)
	private String fileName;
	private String filePath;

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
		return "FileDetails [fileName=" + fileName + ", filePath=" + filePath
				+ "]";
	}

}
