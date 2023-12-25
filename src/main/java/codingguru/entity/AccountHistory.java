package codingguru.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "account_history")
public class AccountHistory {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private UUID id;
	private UUID referenceNumber;
	@ManyToOne()
	@JoinColumn(name = "bankAccountId")
	private BankAccount bankAccount;
	private TransactionType transactionType;
	private Double transactionAmount;
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime transactionDate;
	
	public AccountHistory() {}

	public AccountHistory(UUID referenceNumber, BankAccount bankAccount, TransactionType transactionType, 
						  Double transactionAmount, LocalDateTime transactionDate) {
		this.referenceNumber = referenceNumber;
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transactionDate = transactionDate;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public UUID getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(UUID referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public TransactionType getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	public Double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public void setTransactionDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}

	public LocalDateTime getTransactionDate() {
		return transactionDate;
	}

	public void setTransferedDate(LocalDateTime transactionDate) {
		this.transactionDate = transactionDate;
	}
}
