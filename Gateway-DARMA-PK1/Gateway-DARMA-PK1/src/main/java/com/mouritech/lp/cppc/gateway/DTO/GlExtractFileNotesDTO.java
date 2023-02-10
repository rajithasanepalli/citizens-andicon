package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import org.joda.time.LocalDateTime;

public class GlExtractFileNotesDTO implements Serializable {

	private String id;

	private String comments;

	private UserDTO postedBy;

	private LocalDateTime postingDate;

	private GlExtractFileDTO glExtractFileDTO;

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

	public GlExtractFileDTO getGlExtractFileDTO() {
		return glExtractFileDTO;
	}

	public void setGlExtractFileDTO(GlExtractFileDTO glExtractFileDTO) {
		this.glExtractFileDTO = glExtractFileDTO;
	}

	@Override
	public String toString() {
		return "GlExtractFileNotesDTO [id=" + id + ", comments=" + comments
				+ ", postedBy=" + postedBy + ", postingDate=" + postingDate
				+ ", glExtractFileDTO=" + glExtractFileDTO + "]";
	}

}
