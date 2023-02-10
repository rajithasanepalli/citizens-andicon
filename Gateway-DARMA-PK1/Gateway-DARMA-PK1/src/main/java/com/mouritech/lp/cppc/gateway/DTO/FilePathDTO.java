package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

public class FilePathDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String filePath;

	private Boolean flag;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public Boolean getFlag() {
		return flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "FilePathDTO [filePath=" + filePath + ", flag=" + flag + "]";
	}

	



}
