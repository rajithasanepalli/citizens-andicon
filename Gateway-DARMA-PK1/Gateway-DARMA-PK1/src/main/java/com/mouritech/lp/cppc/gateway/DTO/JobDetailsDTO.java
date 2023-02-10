package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;

import com.mouritech.lp.cppc.gateway.DTO.enums.StatusEnum;

public class JobDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1124869316564110072L;

	private String id;

	private String jobName;

	private String jobCode;

	private StatusEnum status;

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCode() {
		return jobCode;
	}

	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}

	@Override
	public String toString() {
		return "JobDetailsDTO [id=" + id + ", jobName=" + jobName
				+ ", jobCode=" + jobCode + ", status=" + status + "]";
	}

}
