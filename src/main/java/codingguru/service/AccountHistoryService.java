package codingguru.service;

import java.util.List;
import java.util.UUID;

import codingguru.dto.AccountHistoryDTO;

public interface AccountHistoryService {
	public void saveAccountHistory(AccountHistoryDTO transferHistory);
	public AccountHistoryDTO getAccountHistoryByReferenceNumber(UUID referenceNumber);
	public List<AccountHistoryDTO> getAccountHistoryByAccountNumber(UUID accountNumber);
}
