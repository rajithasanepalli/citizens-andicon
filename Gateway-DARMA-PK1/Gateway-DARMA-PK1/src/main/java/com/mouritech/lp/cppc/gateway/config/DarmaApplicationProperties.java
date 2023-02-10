package com.mouritech.lp.cppc.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Properties specific to DarmaApplication.
 *
 * <p>
 * Properties are configured in the application.properties file.
 * </p>
 */
@Configuration
@ConfigurationProperties(prefix = "darma", ignoreUnknownFields = false)
public class DarmaApplicationProperties {

	private String sourceSearchUri;
	private String revenueSearchUri;
	private String sourceReconcileUri;
	private String sourceNavisionUri;
	private String revenueUri;
	private String sourceUri;
	private String revenueAndsourceUri;
	private String revenueNotesUri;
	private String sourceNotesUri;
	private String apiKey;
	private String dLocationUri;
	private String sourceByRevenueUri;
	private String sourceReconcileUpdateUri;
	private String reconcileSearchUri;
	private String navisionSearchUri;
	private String navisonExport;
	private String navisionNewSearchUri;
	private String navisionNewSearchAmeriUri;
	private String navisionNewSearchpk1Uri;
	private String navisonNewExport;
	private String navisonNewAmeriExport;
	private String navisonNewpk1Export;
	private String reconcileExport;
	private String sourceExport;
	private String navisionpciExport;
	private String navisionpci;
	private String navisionpciExportUpdate;
	private String revenuesbydepid;
	private String markForCorrection;
	private String combineDeposits;
	private String revenueLock;

	public String getSourceSearchUri() {
		return sourceSearchUri;
	}

	public void setSourceSearchUri(String sourceSearchUri) {
		this.sourceSearchUri = sourceSearchUri;
	}

	public String getRevenueSearchUri() {
		return revenueSearchUri;
	}

	public void setRevenueSearchUri(String revenueSearchUri) {
		this.revenueSearchUri = revenueSearchUri;
	}

	public String getSourceReconcileUri() {
		return sourceReconcileUri;
	}

	public void setSourceReconcileUri(String sourceReconcileUri) {
		this.sourceReconcileUri = sourceReconcileUri;
	}

	public String getSourceNavisionUri() {
		return sourceNavisionUri;
	}

	public void setSourceNavisionUri(String sourceNavisionUri) {
		this.sourceNavisionUri = sourceNavisionUri;
	}

	public String getRevenueUri() {
		return revenueUri;
	}

	public void setRevenueUri(String revenueUri) {
		this.revenueUri = revenueUri;
	}

	public String getSourceUri() {
		return sourceUri;
	}

	public void setSourceUri(String sourceUri) {
		this.sourceUri = sourceUri;
	}

	public String getRevenueAndsourceUri() {
		return revenueAndsourceUri;
	}

	public void setRevenueAndsourceUri(String revenueAndsourceUri) {
		this.revenueAndsourceUri = revenueAndsourceUri;
	}

	public String getRevenueNotesUri() {
		return revenueNotesUri;
	}

	public void setRevenueNotesUri(String revenueNotesUri) {
		this.revenueNotesUri = revenueNotesUri;
	}

	public String getSourceNotesUri() {
		return sourceNotesUri;
	}

	public void setSourceNotesUri(String sourceNotesUri) {
		this.sourceNotesUri = sourceNotesUri;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getdLocationUri() {
		return dLocationUri;
	}

	public void setdLocationUri(String dLocationUri) {
		this.dLocationUri = dLocationUri;
	}

	public String getSourceByRevenueUri() {
		return sourceByRevenueUri;
	}

	public void setSourceByRevenueUri(String sourceByRevenueUri) {
		this.sourceByRevenueUri = sourceByRevenueUri;
	}

	public String getSourceReconcileUpdateUri() {
		return sourceReconcileUpdateUri;
	}

	public void setSourceReconcileUpdateUri(String sourceReconcileUpdateUri) {
		this.sourceReconcileUpdateUri = sourceReconcileUpdateUri;
	}

	public String getReconcileSearchUri() {
		return reconcileSearchUri;
	}

	public void setReconcileSearchUri(String reconcileSearchUri) {
		this.reconcileSearchUri = reconcileSearchUri;
	}

	public String getNavisionSearchUri() {
		return navisionSearchUri;
	}

	public void setNavisionSearchUri(String navisionSearchUri) {
		this.navisionSearchUri = navisionSearchUri;
	}

	public String getNavisonExport() {
		return navisonExport;
	}

	public void setNavisonExport(String navisonExport) {
		this.navisonExport = navisonExport;
	}

	public String getReconcileExport() {
		return reconcileExport;
	}

	public void setReconcileExport(String reconcileExport) {
		this.reconcileExport = reconcileExport;
	}

	public String getSourceExport() {
		return sourceExport;
	}

	public void setSourceExport(String sourceExport) {
		this.sourceExport = sourceExport;
	}

	public String getNavisionpciExport() {
		return navisionpciExport;
	}

	public void setNavisionpciExport(String navisionpciExport) {
		this.navisionpciExport = navisionpciExport;
	}

	public String getNavisionpci() {
		return navisionpci;
	}

	public void setNavisionpci(String navisionpci) {
		this.navisionpci = navisionpci;
	}

	public String getNavisionpciExportUpdate() {
		return navisionpciExportUpdate;
	}

	public void setNavisionpciExportUpdate(String navisionpciExportUpdate) {
		this.navisionpciExportUpdate = navisionpciExportUpdate;
	}

	public String getRevenuesbydepid() {
		return revenuesbydepid;
	}

	public void setRevenuesbydepid(String revenuesbydepid) {
		this.revenuesbydepid = revenuesbydepid;
	}

	public String getNavisionNewSearchUri() {
		return navisionNewSearchUri;
	}

	public void setNavisionNewSearchUri(String navisionNewSearchUri) {
		this.navisionNewSearchUri = navisionNewSearchUri;
	}

	public String getNavisonNewExport() {
		return navisonNewExport;
	}

	public void setNavisonNewExport(String navisonNewExport) {
		this.navisonNewExport = navisonNewExport;
	}

	public String getMarkForCorrection() {
		return markForCorrection;
	}

	public void setMarkForCorrection(String markForCorrection) {
		this.markForCorrection = markForCorrection;
	}

	public String getCombineDeposits() {
		return combineDeposits;
	}

	public void setCombineDeposits(String combineDeposits) {
		this.combineDeposits = combineDeposits;
	}

	public String getRevenueLock() {
		return revenueLock;
	}

	public void setRevenueLock(String revenueLock) {
		this.revenueLock = revenueLock;
	}

	public String getNavisonNewAmeriExport() {
		return navisonNewAmeriExport;
	}

	public void setNavisonNewAmeriExport(String navisonNewAmeriExport) {
		this.navisonNewAmeriExport = navisonNewAmeriExport;
	}

	public String getNavisonNewpk1Export() {
		return navisonNewpk1Export;
	}

	public void setNavisonNewpk1Export(String navisonNewpk1Export) {
		this.navisonNewpk1Export = navisonNewpk1Export;
	}

	public String getNavisionNewSearchAmeriUri() {
		return navisionNewSearchAmeriUri;
	}

	public void setNavisionNewSearchAmeriUri(String navisionNewSearchAmeriUri) {
		this.navisionNewSearchAmeriUri = navisionNewSearchAmeriUri;
	}

	public String getNavisionNewSearchpk1Uri() {
		return navisionNewSearchpk1Uri;
	}

	public void setNavisionNewSearchpk1Uri(String navisionNewSearchpk1Uri) {
		this.navisionNewSearchpk1Uri = navisionNewSearchpk1Uri;
	}

}
