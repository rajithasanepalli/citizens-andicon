package com.mouritech.lp.cppc.gateway.tallysheet.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class CardPaymentsAndTotal implements Serializable {

	private static final long serialVersionUID = 1L;
	private String cardType;
	private BigDecimal total;

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "CardPaymentsAndTotal [cardType=" + cardType + ", total="
				+ total + "]";
	}

}
