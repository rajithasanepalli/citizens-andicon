package com.mouritech.lp.cppc.gateway.DTO;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A TT_TNA_META DTO.
 */

public class TtTnaEmpDTO implements Serializable {

	private static final long serialVersionUID = 4607225545093486275L;
	@JsonIgnore
	private String id;	
	@JsonIgnore
	private String sessionId;
	
	
	@Size(max = 36)  @NotNull(message = "employeeId is required") @NotBlank(message = "employeeId should not be Blank or Null")
	private String employeeId;
	
	@Valid @NotNull(message = "totalHrs is required")
	private Double totalHrs;
	
	@Valid
	private Double tips;	
	@JsonIgnore
	private String ttTnameta;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Double getTotalHrs() {
		return totalHrs;
	}

	public void setTotalHrs(Double totalHrs) {
		this.totalHrs = totalHrs;
	}

	public Double getTips() {
		return tips;
	}

	public void setTips(Double tips) {
		this.tips = tips;
	}

	public String getTtTnameta() {
		return ttTnameta;
	}

	public void setTtTnameta(String ttTnameta) {
		this.ttTnameta = ttTnameta;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		TtTnaEmpDTO tttnameta = (TtTnaEmpDTO) o;

		if (!Objects.equals(id, tttnameta.id))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public String toString() {
		return "TtTnaEmp [id=" + id + ", sessionId=" + sessionId + ", employeeId=" + employeeId + ", totalHrs="
				+ totalHrs + ", tips=" + tips + ", ttTnameta=" + ttTnameta + "]";
	}

}
