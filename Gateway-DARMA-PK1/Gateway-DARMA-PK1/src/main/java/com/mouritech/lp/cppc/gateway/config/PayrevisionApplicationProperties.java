package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to LmrApplication.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "payrevision", ignoreUnknownFields = false)
public class PayrevisionApplicationProperties {

	private String payroll;
	private String payrollGetFiles;
	private String payrollDownload;
	private String glcodesUri;
	private String payrollRevisionsUri;
	private String approvePayRevisionUri;
	private String apiKey;
	private String payrevisionByPidUri;
	private String payRevisionSearchUri;
	private String payrevisionExportUri;

	public String getPayRevisionSearchUri() {
		return payRevisionSearchUri;
	}

	public void setPayRevisionSearchUri(String payRevisionSearchUri) {
		this.payRevisionSearchUri = payRevisionSearchUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getPayroll() {
		return payroll;
	}

	public void setPayroll(String payroll) {
		this.payroll = payroll;
	}

	public String getPayrollGetFiles() {
		return payrollGetFiles;
	}

	public void setPayrollGetFiles(String payrollGetFiles) {
		this.payrollGetFiles = payrollGetFiles;
	}

	public String getPayrollDownload() {
		return payrollDownload;
	}

	public void setPayrollDownload(String payrollDownload) {
		this.payrollDownload = payrollDownload;
	}

	public String getGlcodesUri() {
		return glcodesUri;
	}

	public void setGlcodesUri(String glcodesUri) {
		this.glcodesUri = glcodesUri;
	}

	public String getPayrollRevisionsUri() {
		return payrollRevisionsUri;
	}

	public void setPayrollRevisionsUri(String payrollRevisionsUri) {
		this.payrollRevisionsUri = payrollRevisionsUri;
	}

	public String getApprovePayRevisionUri() {
		return approvePayRevisionUri;
	}

	public void setApprovePayRevisionUri(String approvePayRevisionUri) {
		this.approvePayRevisionUri = approvePayRevisionUri;
	}

	public String getPayrevisionByPidUri() {
		return payrevisionByPidUri;
	}

	public void setPayrevisionByPidUri(String payrevisionByPidUri) {
		this.payrevisionByPidUri = payrevisionByPidUri;
	}

	public String getPayrevisionExportUri() {
		return payrevisionExportUri;
	}

	public void setPayrevisionExportUri(String payrevisionExportUri) {
		this.payrevisionExportUri = payrevisionExportUri;
	}

}
