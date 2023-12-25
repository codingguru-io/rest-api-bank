package codingguru.adapter;

import codingguru.dto.AccountHistoryDTO;
import codingguru.entity.AccountHistory;

public class AccountHistoryAdapter {
	public static AccountHistory dtoToEntity(AccountHistoryDTO transactionHistory) {
		return new AccountHistory(transactionHistory.getReferenceNumber(), transactionHistory.getBankAccount(),
								  transactionHistory.getTransactionType(), transactionHistory.getTransactionAmount(), 
								  transactionHistory.getTransferedDate());
	}
}
