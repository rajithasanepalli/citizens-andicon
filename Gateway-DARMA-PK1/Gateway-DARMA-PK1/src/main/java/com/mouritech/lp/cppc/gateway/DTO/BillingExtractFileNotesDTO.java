package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;



public class BillingExtractFileNotesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String comments;

	private UserDTO postedBy;

	private LocalDateTime postingDate;

	private BillingExtractFileDTO billingExtractFileDTO;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public UserDTO getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(UserDTO postedBy) {
		this.postedBy = postedBy;
	}

	public LocalDateTime getPostingDate() {
		return postingDate;
	}

	public void setPostingDate(LocalDateTime postingDate) {
		this.postingDate = postingDate;
	}

	public BillingExtractFileDTO getBillingExtractFileDTO() {
		return billingExtractFileDTO;
	}

	public void setBillingExtractFileDTO(
			BillingExtractFileDTO billingExtractFileDTO) {
		this.billingExtractFileDTO = billingExtractFileDTO;
	}

	@Override
	public String toString() {
		return "BillingExtractFileNotesDTO [id=" + id + ", comments="
				+ comments + ", postedBy=" + postedBy + ", postingDate="
				+ postingDate + ", billingExtractFileDTO="
				+ billingExtractFileDTO + "]";
	}

}
