package codingguru.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "bank_account")
public class BankAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private UUID accountNumber;
	private String accountHolder;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime openedDate;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime closedDate;
	private Double balance;
	
	public BankAccount() {}
	
	public BankAccount(UUID accountNumber, String accountHolder, LocalDateTime openedDate, LocalDateTime closedDate, Double balance) {
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
}
