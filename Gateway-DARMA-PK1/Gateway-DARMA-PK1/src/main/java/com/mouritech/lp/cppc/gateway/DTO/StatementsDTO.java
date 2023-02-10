package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonView;
import com.mouritech.lp.cppc.gateway.DTO.enums.CpStatementsStatus;
import com.mouritech.lp.cppc.gateway.DTO.enums.ExportExcelEnum;
import com.mouritech.lp.cppc.gateway.DTO.enums.VarianceStatusEnum;
import com.mouritech.lp.cppc.gateway.views.View;

public class StatementsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	@JsonView(View.Statement.class)
	private String id;
	// @JsonIgnore

	private String title;
	@JsonView(View.Statement.class)
	private Integer month;
	@JsonView(View.Statement.class)
	private Integer year;
	// @JsonIgnore
	private String fileName;
	@JsonView(View.Statement.class)
	private CpStatementsStatus statementStatus;
	// @JsonIgnore
	private String type;
	// @JsonIgnore
	private String filePath;
	@JsonView(View.Statement.class)
	private CpLocationDTO location;
	@JsonView(View.Statement.class)
	private List<FileInfoDTO> fileInfoDTO = new ArrayList<FileInfoDTO>();

	private List<StatementsNotesDTO> statementsNotesDTO = new ArrayList<StatementsNotesDTO>();

	private String notes;
	@JsonView(View.Statement.class)
	private LocalDateTime statementViewDate;
	@JsonView(View.Statement.class)
	private String statementViewedBy;

	@JsonView(View.Statement.class)
	private Boolean level1;
	@JsonView(View.Statement.class)
	private Boolean level2;
	@JsonView(View.Statement.class)
	private Boolean level3;
	@JsonView(View.Statement.class)
	private Boolean level4;
	@JsonView(View.Statement.class)
	private LocalDateTime finalDate = null;
	@JsonView(View.Statement.class)
	private String finalBy;
	@JsonView(View.Statement.class)
	private LocalDateTime deliveredDate = null;
	@JsonView(View.Statement.class)
	private String deliveredBy;
	@JsonView(View.Statement.class)
	private LocalDateTime approvedDate = null;
	@JsonView(View.Statement.class)
	private String approvedBy;
	@JsonView(View.Statement.class)
	private String unapprovedBy;

	private ExportExcelEnum exportExcelEnum;
	@JsonView(View.Statement.class)
	private VarianceStatusEnum varainceStatus;
	@JsonView(View.Statement.class)
	private LocalDateTime varianceApprovedDate = null;
	@JsonView(View.Statement.class)
	private LocalDateTime varianceRejectedDate = null;
	@JsonView(View.Statement.class)
	private String varianceApprovedBy;
	@JsonView(View.Statement.class)
	private String varianceRejectedBy;

	public LocalDateTime getStatementViewDate() {
		return statementViewDate;
	}

	public void setStatementViewDate(LocalDateTime statementViewDate) {
		this.statementViewDate = statementViewDate;
	}

	public CpLocationDTO getLocation() {
		return location;
	}

	public List<FileInfoDTO> getFileInfoDTO() {
		return fileInfoDTO;
	}

	public void setFileInfoDTO(List<FileInfoDTO> fileInfoDTO) {
		this.fileInfoDTO = fileInfoDTO;
	}

	public void setLocation(CpLocationDTO location) {
		this.location = location;
	}

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

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CpStatementsStatus getStatementStatus() {
		return statementStatus;
	}

	public void setStatementStatus(CpStatementsStatus statementStatus) {
		this.statementStatus = statementStatus;
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

	public List<StatementsNotesDTO> getStatementsNotesDTO() {
		return statementsNotesDTO;
	}

	public void setStatementsNotesDTO(List<StatementsNotesDTO> statementsNotesDTO) {
		this.statementsNotesDTO = statementsNotesDTO;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatementViewedBy() {
		return statementViewedBy;
	}

	public void setStatementViewedBy(String statementViewedBy) {
		this.statementViewedBy = statementViewedBy;
	}

	public Boolean getLevel1() {
		return level1;
	}

	public void setLevel1(Boolean level1) {
		this.level1 = level1;
	}

	public Boolean getLevel2() {
		return level2;
	}

	public void setLevel2(Boolean level2) {
		this.level2 = level2;
	}

	public Boolean getLevel3() {
		return level3;
	}

	public void setLevel3(Boolean level3) {
		this.level3 = level3;
	}

	public Boolean getLevel4() {
		return level4;
	}

	public void setLevel4(Boolean level4) {
		this.level4 = level4;
	}

	public LocalDateTime getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(LocalDateTime finalDate) {
		this.finalDate = finalDate;
	}

	public String getFinalBy() {
		return finalBy;
	}

	public void setFinalBy(String finalBy) {
		this.finalBy = finalBy;
	}

	public LocalDateTime getDeliveredDate() {
		return deliveredDate;
	}

	public void setDeliveredDate(LocalDateTime deliveredDate) {
		this.deliveredDate = deliveredDate;
	}

	public String getDeliveredBy() {
		return deliveredBy;
	}

	public void setDeliveredBy(String deliveredBy) {
		this.deliveredBy = deliveredBy;
	}

	public LocalDateTime getApprovedDate() {
		return approvedDate;
	}

	public void setApprovedDate(LocalDateTime approvedDate) {
		this.approvedDate = approvedDate;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getUnapprovedBy() {
		return unapprovedBy;
	}

	public void setUnapprovedBy(String unapprovedBy) {
		this.unapprovedBy = unapprovedBy;
	}

	public ExportExcelEnum getExportExcelEnum() {
		return exportExcelEnum;
	}

	public void setExportExcelEnum(ExportExcelEnum exportExcelEnum) {
		this.exportExcelEnum = exportExcelEnum;
	}

	public VarianceStatusEnum getVarainceStatus() {
		return varainceStatus;
	}

	public void setVarainceStatus(VarianceStatusEnum varainceStatus) {
		this.varainceStatus = varainceStatus;
	}

	public LocalDateTime getVarianceApprovedDate() {
		return varianceApprovedDate;
	}

	public void setVarianceApprovedDate(LocalDateTime varianceApprovedDate) {
		this.varianceApprovedDate = varianceApprovedDate;
	}

	public LocalDateTime getVarianceRejectedDate() {
		return varianceRejectedDate;
	}

	public void setVarianceRejectedDate(LocalDateTime varianceRejectedDate) {
		this.varianceRejectedDate = varianceRejectedDate;
	}

	public String getVarianceApprovedBy() {
		return varianceApprovedBy;
	}

	public void setVarianceApprovedBy(String varianceApprovedBy) {
		this.varianceApprovedBy = varianceApprovedBy;
	}

	public String getVarianceRejectedBy() {
		return varianceRejectedBy;
	}

	public void setVarianceRejectedBy(String varianceRejectedBy) {
		this.varianceRejectedBy = varianceRejectedBy;
	}

	@Override
	public String toString() {
		return "StatementsDTO [id=" + id + ", title=" + title + ", month=" + month + ", year=" + year + ", fileName="
				+ fileName + ", statementStatus=" + statementStatus + ", type=" + type + ", filePath=" + filePath
				+ ", location=" + location + ", fileInfoDTO=" + fileInfoDTO + ", statementsNotesDTO="
				+ statementsNotesDTO + ", notes=" + notes + ", statementViewDate=" + statementViewDate
				+ ", statementViewedBy=" + statementViewedBy + ", level1=" + level1 + ", level2=" + level2 + ", level3="
				+ level3 + ", level4=" + level4 + ", finalDate=" + finalDate + ", finalBy=" + finalBy
				+ ", deliveredDate=" + deliveredDate + ", deliveredBy=" + deliveredBy + ", approvedDate=" + approvedDate
				+ ", approvedBy=" + approvedBy + ", unapprovedBy=" + unapprovedBy + ", exportExcelEnum="
				+ exportExcelEnum + ", varainceStatus=" + varainceStatus + ", varianceApprovedDate="
				+ varianceApprovedDate + ", varianceRejectedDate=" + varianceRejectedDate + ", varianceApprovedBy="
				+ varianceApprovedBy + ", varianceRejectedBy=" + varianceRejectedBy + "]";
	}

}
