package codingguru.dto;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DepositDTO {
	@JsonProperty(value = "account_number")
	private UUID accountNumber;
	@JsonProperty(value = "amount")
	private Double amount;
	
	public DepositDTO(UUID accountNumber, Double amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public UUID getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(UUID accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
