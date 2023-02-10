package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import com.mouritech.lp.cppc.gateway.DTO.enums.ExceptionEnum;

/**
 * @author Akhileshv
 *
 */
public class SftpFileDetailsDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String billingFileId;
	private String billingInboundFileName;
	private String billingInboundFilePath;
	private LocalDate billingDate;
	private LocalDateTime billingFileRecTimeStamp;
	private List<String> billingOutboundFilePath=new ArrayList<String>();;
	private List<String> billingOutboundFileName=new ArrayList<String>();;
	private String glFileId;
	private String glInboundFileName;
	private String glInboundFilePath;
	private LocalDate glDate;
	private LocalDateTime glFileRecTimeStamp;
	private List<String> glOutboundFilePath=new ArrayList<String>();
	private List<String> glOutboundFileName=new ArrayList<String>();
	private ExceptionEnum status;
	private String Exception;

	

	public String getException() {
		return Exception;
	}


	public void setException(String exception) {
		Exception = exception;
	}


	public LocalDateTime getBillingFileRecTimeStamp() {
		return billingFileRecTimeStamp;
	}


	public void setBillingFileRecTimeStamp(LocalDateTime billingFileRecTimeStamp) {
		this.billingFileRecTimeStamp = billingFileRecTimeStamp;
	}


	public LocalDateTime getGlFileRecTimeStamp() {
		return glFileRecTimeStamp;
	}


	public void setGlFileRecTimeStamp(LocalDateTime glFileRecTimeStamp) {
		this.glFileRecTimeStamp = glFileRecTimeStamp;
	}


	public LocalDate getBillingDate() {
		return billingDate;
	}


	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}


	public LocalDate getGlDate() {
		return glDate;
	}


	public void setGlDate(LocalDate glDate) {
		this.glDate = glDate;
	}


	public String getBillingFileId() {
		return billingFileId;
	}


	public void setBillingFileId(String billingFileId) {
		this.billingFileId = billingFileId;
	}


	public String getGlFileId() {
		return glFileId;
	}


	public void setGlFileId(String glFileId) {
		this.glFileId = glFileId;
	}


	public String getBillingInboundFileName() {
		return billingInboundFileName;
	}


	public void setBillingInboundFileName(String billingInboundFileName) {
		this.billingInboundFileName = billingInboundFileName;
	}


	public String getBillingInboundFilePath() {
		return billingInboundFilePath;
	}

	public void setBillingInboundFilePath(String billingInboundFilePath) {
		this.billingInboundFilePath = billingInboundFilePath;
	}

	public List<String> getBillingOutboundFilePath() {
		return billingOutboundFilePath;
	}

	public void setBillingOutboundFilePath(List<String> billingOutboundFilePath) {
		this.billingOutboundFilePath = billingOutboundFilePath;
	}

	public List<String> getBillingOutboundFileName() {
		return billingOutboundFileName;
	}

	public void setBillingOutboundFileName(List<String> billingOutboundFileName) {
		this.billingOutboundFileName = billingOutboundFileName;
	}
	public String getGlInboundFileName() {
		return glInboundFileName;
	}

	public void setGlInboundFileName(String glInboundFileName) {
		this.glInboundFileName = glInboundFileName;
	}
	public String getGlInboundFilePath() {
		return glInboundFilePath;
	}
	public void setGlInboundFilePath(String glInboundFilePath) {
		this.glInboundFilePath = glInboundFilePath;
	}
	public List<String> getGlOutboundFilePath() {
		return glOutboundFilePath;
	}
	public void setGlOutboundFilePath(List<String> glOutboundFilePath) {
		this.glOutboundFilePath = glOutboundFilePath;
	}
	public List<String> getGlOutboundFileName() {
		return glOutboundFileName;
	}
	public void setGlOutboundFileName(List<String> glOutboundFileName) {
		this.glOutboundFileName = glOutboundFileName;
	}


	public ExceptionEnum getStatus() {
		return status;
	}


	public void setStatus(ExceptionEnum status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "SftpFileDetailsDto [billingFileId=" + billingFileId
				+ ", billingInboundFileName=" + billingInboundFileName
				+ ", billingInboundFilePath=" + billingInboundFilePath
				+ ", billingDate=" + billingDate + ", billingOutboundFilePath="
				+ billingOutboundFilePath + ", billingOutboundFileName="
				+ billingOutboundFileName + ", glFileId=" + glFileId
				+ ", glInboundFileName=" + glInboundFileName
				+ ", glInboundFilePath=" + glInboundFilePath + ", glDate="
				+ glDate + ", glOutboundFilePath=" + glOutboundFilePath
				+ ", glOutboundFileName=" + glOutboundFileName + ", status="
				+ status + ", Exception=" + Exception + "]";
	}
	

}
