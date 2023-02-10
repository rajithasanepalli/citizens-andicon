package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.views.View;

public class FileInfoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(View.Statement.class)
	private String id;
	@JsonView(View.Statement.class)
	private String title;
	@JsonView(View.Statement.class)
	private String fileName;
	@JsonView(View.Statement.class)
	private String type;
	//@JsonIgnore
	private String filePath;
	@JsonView(View.Statement.class)
	private StatementsDTO statementsDTO;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public StatementsDTO getStatementsDTO() {
		return statementsDTO;
	}

	public void setStatementsDTO(StatementsDTO statementsDTO) {
		this.statementsDTO = statementsDTO;
	}

	@Override
	public String toString() {
		return "FileInfoDTO [id=" + id + ", title=" + title + ", fileName="
				+ fileName + ", type=" + type + ", filePath=" + filePath
				+ ", statementsDTO=" + statementsDTO + "]";
	}

}
