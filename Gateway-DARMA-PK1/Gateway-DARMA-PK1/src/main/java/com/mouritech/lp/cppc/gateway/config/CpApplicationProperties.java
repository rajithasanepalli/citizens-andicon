package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to Client portal Application.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "cp", ignoreUnknownFields = false)
public class CpApplicationProperties {

	private String statementsUri;
	private String statementsListUri;
	private String statementsDownloadUri;
	private String statementWithLocationIdUri;
	private String locationWithStatementsUri;
	private String cpIapiKey;
	private String cpEapiKey;
	private String resetPasswordUri;
	private String registerUri;
	private String validateUri;
	private String requestPasswordResetUri;
	private String cpLocationContactsUri;
	private String cpUserUri;
	private String cpRoleUri;
	private String cpLocationsUri;
	private String cpAccessTokenUri;
	private String cpLogout;
	private String dashBordUri;
	private String dashBordCategoryUri;
	private String dashBordDataSourceUri;
	private String dashBordClientUri;
	private String dashBordWidgetUri;
	private String approveStatementsUri;
	private String cpUserLocationLinkUri;
	private String cpUserDashBoardLinkUri;
	private String dashBoardGetUri;
	private String statementSearchUri;
	private String cpFileInfoUri;
	private String statementsExtDownload;
	private String tokenValidator;
	private String glcodesUri;
	private String varianceExplanation;
	private String statementNotesUri;
	private String designationUri;
	private String passwordChange;
	private String varianceExport;
	private String cptenderTypesUri;
	private String locfacilitytype;
	private String locationIconUpoad;
	private String ticketSummary;
	private String executiveSummary;
	private String varianceUri;
	private String dashboardFileDownload;
	private String varianceArchive;
	private String locationDataOnly;

	public String getLocationDataOnly() {
		return locationDataOnly;
	}

	public void setLocationDataOnly(String locationDataOnly) {
		this.locationDataOnly = locationDataOnly;
	}

	public String getStatementsUri() {
		return statementsUri;
	}

	public void setStatementsUri(String statementsUri) {
		this.statementsUri = statementsUri;
	}

	public String getStatementsListUri() {
		return statementsListUri;
	}

	public void setStatementsListUri(String statementsListUri) {
		this.statementsListUri = statementsListUri;
	}

	public String getStatementsDownloadUri() {
		return statementsDownloadUri;
	}

	public void setStatementsDownloadUri(String statementsDownloadUri) {
		this.statementsDownloadUri = statementsDownloadUri;
	}

	public String getStatementWithLocationIdUri() {
		return statementWithLocationIdUri;
	}

	public void setStatementWithLocationIdUri(String statementWithLocationIdUri) {
		this.statementWithLocationIdUri = statementWithLocationIdUri;
	}

	public String getLocationWithStatementsUri() {
		return locationWithStatementsUri;
	}

	public void setLocationWithStatementsUri(String locationWithStatementsUri) {
		this.locationWithStatementsUri = locationWithStatementsUri;
	}

	public String getCpIapiKey() {
		return cpIapiKey;
	}

	public void setCpIapiKey(String cpIapiKey) {
		this.cpIapiKey = cpIapiKey;
	}

	public String getCpEapiKey() {
		return cpEapiKey;
	}

	public void setCpEapiKey(String cpEapiKey) {
		this.cpEapiKey = cpEapiKey;
	}

	public String getResetPasswordUri() {
		return resetPasswordUri;
	}

	public void setResetPasswordUri(String resetPasswordUri) {
		this.resetPasswordUri = resetPasswordUri;
	}

	public String getRegisterUri() {
		return registerUri;
	}

	public void setRegisterUri(String registerUri) {
		this.registerUri = registerUri;
	}

	public String getValidateUri() {
		return validateUri;
	}

	public void setValidateUri(String validateUri) {
		this.validateUri = validateUri;
	}

	public String getRequestPasswordResetUri() {
		return requestPasswordResetUri;
	}

	public void setRequestPasswordResetUri(String requestPasswordResetUri) {
		this.requestPasswordResetUri = requestPasswordResetUri;
	}

	public String getCpLocationContactsUri() {
		return cpLocationContactsUri;
	}

	public void setCpLocationContactsUri(String cpLocationContactsUri) {
		this.cpLocationContactsUri = cpLocationContactsUri;
	}

	public String getCpUserUri() {
		return cpUserUri;
	}

	public void setCpUserUri(String cpUserUri) {
		this.cpUserUri = cpUserUri;
	}

	public String getCpRoleUri() {
		return cpRoleUri;
	}

	public void setCpRoleUri(String cpRoleUri) {
		this.cpRoleUri = cpRoleUri;
	}

	public String getCpLocationsUri() {
		return cpLocationsUri;
	}

	public void setCpLocationsUri(String cpLocationsUri) {
		this.cpLocationsUri = cpLocationsUri;
	}

	public String getCpAccessTokenUri() {
		return cpAccessTokenUri;
	}

	public void setCpAccessTokenUri(String cpAccessTokenUri) {
		this.cpAccessTokenUri = cpAccessTokenUri;
	}

	public String getCpLogout() {
		return cpLogout;
	}

	public void setCpLogout(String cpLogout) {
		this.cpLogout = cpLogout;
	}

	public String getDashBordUri() {
		return dashBordUri;
	}

	public void setDashBordUri(String dashBordUri) {
		this.dashBordUri = dashBordUri;
	}

	public String getDashBordCategoryUri() {
		return dashBordCategoryUri;
	}

	public void setDashBordCategoryUri(String dashBordCategoryUri) {
		this.dashBordCategoryUri = dashBordCategoryUri;
	}

	public String getDashBordDataSourceUri() {
		return dashBordDataSourceUri;
	}

	public void setDashBordDataSourceUri(String dashBordDataSourceUri) {
		this.dashBordDataSourceUri = dashBordDataSourceUri;
	}

	public String getDashBordClientUri() {
		return dashBordClientUri;
	}

	public void setDashBordClientUri(String dashBordClientUri) {
		this.dashBordClientUri = dashBordClientUri;
	}

	public String getDashBordWidgetUri() {
		return dashBordWidgetUri;
	}

	public void setDashBordWidgetUri(String dashBordWidgetUri) {
		this.dashBordWidgetUri = dashBordWidgetUri;
	}

	public String getApproveStatementsUri() {
		return approveStatementsUri;
	}

	public void setApproveStatementsUri(String approveStatementsUri) {
		this.approveStatementsUri = approveStatementsUri;
	}

	public String getCpUserLocationLinkUri() {
		return cpUserLocationLinkUri;
	}

	public void setCpUserLocationLinkUri(String cpUserLocationLinkUri) {
		this.cpUserLocationLinkUri = cpUserLocationLinkUri;
	}

	public String getCpUserDashBoardLinkUri() {
		return cpUserDashBoardLinkUri;
	}

	public void setCpUserDashBoardLinkUri(String cpUserDashBoardLinkUri) {
		this.cpUserDashBoardLinkUri = cpUserDashBoardLinkUri;
	}

	public String getDashBoardGetUri() {
		return dashBoardGetUri;
	}

	public void setDashBoardGetUri(String dashBoardGetUri) {
		this.dashBoardGetUri = dashBoardGetUri;
	}

	public String getStatementSearchUri() {
		return statementSearchUri;
	}

	public void setStatementSearchUri(String statementSearchUri) {
		this.statementSearchUri = statementSearchUri;
	}

	public String getCpFileInfoUri() {
		return cpFileInfoUri;
	}

	public void setCpFileInfoUri(String cpFileInfoUri) {
		this.cpFileInfoUri = cpFileInfoUri;
	}

	public String getStatementsExtDownload() {
		return statementsExtDownload;
	}

	public void setStatementsExtDownload(String statementsExtDownload) {
		this.statementsExtDownload = statementsExtDownload;
	}

	public String getTokenValidator() {
		return tokenValidator;
	}

	public void setTokenValidator(String tokenValidator) {
		this.tokenValidator = tokenValidator;
	}

	public String getGlcodesUri() {
		return glcodesUri;
	}

	public void setGlcodesUri(String glcodesUri) {
		this.glcodesUri = glcodesUri;
	}

	public String getVarianceExplanation() {
		return varianceExplanation;
	}

	public void setVarianceExplanation(String varianceExplanation) {
		this.varianceExplanation = varianceExplanation;
	}

	public String getStatementNotesUri() {
		return statementNotesUri;
	}

	public void setStatementNotesUri(String statementNotesUri) {
		this.statementNotesUri = statementNotesUri;
	}

	public String getDesignationUri() {
		return designationUri;
	}

	public void setDesignationUri(String designationUri) {
		this.designationUri = designationUri;
	}

	public String getPasswordChange() {
		return passwordChange;
	}

	public void setPasswordChange(String passwordChange) {
		this.passwordChange = passwordChange;
	}

	public String getVarianceExport() {
		return varianceExport;
	}

	public void setVarianceExport(String varianceExport) {
		this.varianceExport = varianceExport;
	}

	public String getCptenderTypesUri() {
		return cptenderTypesUri;
	}

	public void setCptenderTypesUri(String cptenderTypesUri) {
		this.cptenderTypesUri = cptenderTypesUri;
	}

	public String getLocfacilitytype() {
		return locfacilitytype;
	}

	public void setLocfacilitytype(String locfacilitytype) {
		this.locfacilitytype = locfacilitytype;
	}

	public String getLocationIconUpoad() {
		return locationIconUpoad;
	}

	public void setLocationIconUpoad(String locationIconUpoad) {
		this.locationIconUpoad = locationIconUpoad;
	}

	public String getTicketSummary() {
		return ticketSummary;
	}

	public void setTicketSummary(String ticketSummary) {
		this.ticketSummary = ticketSummary;
	}

	public String getExecutiveSummary() {
		return executiveSummary;
	}

	public void setExecutiveSummary(String executiveSummary) {
		this.executiveSummary = executiveSummary;
	}

	public String getVarianceUri() {
		return varianceUri;
	}

	public void setVarianceUri(String varianceUri) {
		this.varianceUri = varianceUri;
	}

	public String getDashboardFileDownload() {
		return dashboardFileDownload;
	}

	public void setDashboardFileDownload(String dashboardFileDownload) {
		this.dashboardFileDownload = dashboardFileDownload;
	}

	public String getVarianceArchive() {
		return varianceArchive;
	}

	public void setVarianceArchive(String varianceArchive) {
		this.varianceArchive = varianceArchive;
	}

}
