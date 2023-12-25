package codingguru.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankAccountDTO {
	@JsonProperty(value = "id")
	private UUID id;
	@JsonProperty(value = "account_number")
	private UUID accountNumber;
	@JsonProperty(value = "account_holder")
	private String accountHolder;
	@JsonProperty(value = "opened_date")
	private LocalDateTime openedDate;
	@JsonProperty(value = "closed_date")
	private LocalDateTime closedDate;
	@JsonProperty(value = "account_balance")
	private Double balance;
	
	public BankAccountDTO() {}
	
	public BankAccountDTO(UUID id) {
		this.id = id;
	}
	
	public BankAccountDTO(UUID id, UUID accountNumber, String accountHolder, LocalDateTime openedDate, LocalDateTime closedDate,
			Double balance) {
		this.id = id;
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.openedDate = openedDate;
		this.closedDate = closedDate;
		this.balance = balance;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(UUID accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public LocalDateTime getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(LocalDateTime openedDate) {
		this.openedDate = openedDate;
	}

	public LocalDateTime getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(LocalDateTime closedDate) {
		this.closedDate = closedDate;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "BankAccountDTO [id=" + id + ", accountNumber=" + accountNumber + ", accountHolder=" + accountHolder
				+ ", openedDate=" + openedDate + ", closedDate=" + closedDate + ", balance=" + balance + "]";
	}
}
