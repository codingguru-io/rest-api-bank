package codingguru.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import codingguru.entity.BankAccount;
import codingguru.entity.TransactionType;


@JsonPropertyOrder(value = { "referenceNumber", "accountNumber", "transactionType", "transactionAmount", "transferedDate" })
public class AccountHistoryDTO {
	private UUID referenceNumber;
	@JsonIgnore
	private BankAccount bankAccount;
	private TransactionType transactionType;
	private Double transactionAmount;
	private LocalDateTime transferedDate;
	
	public AccountHistoryDTO() { }
	
	public AccountHistoryDTO(UUID referenceNumber, BankAccount bankAccount, TransactionType transactionType, 
			 				 Double transactionAmount, LocalDateTime transferedDate) {
		this.referenceNumber = referenceNumber;
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.transferedDate = transferedDate;
	}

	public AccountHistoryDTO(BankAccount bankAccount, TransactionType transactionType, 
							 Double transactionAmount) {
		this.bankAccount = bankAccount;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}

	public UUID getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(UUID referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public UUID getAccountNumber() {
		return this.bankAccount.getAccountNumber();
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

	public LocalDateTime getTransferedDate() {
		return transferedDate;
	}

	public void setTransferedDate(LocalDateTime transferedDate) {
		this.transferedDate = transferedDate;
	}
}
