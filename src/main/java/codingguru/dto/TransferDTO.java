package codingguru.dto;

import java.util.UUID;

public class TransferDTO {
	private UUID fromAccountId;
	private UUID toAccountId;
	private Double amount;
	
	public TransferDTO() { }

	public TransferDTO(UUID fromAccountId, UUID toAccountId, Double amount) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public UUID getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(UUID fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public UUID getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(UUID toAccountId) {
		this.toAccountId = toAccountId;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
}
