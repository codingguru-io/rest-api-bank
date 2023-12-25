package codingguru.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codingguru.adapter.AccountHistoryAdapter;
import codingguru.dto.AccountHistoryDTO;
import codingguru.repository.AccountHistoryRepository;

@Service
public class AccountHistoryServiceImpl implements AccountHistoryService {
	@Autowired
	private AccountHistoryRepository accountHistoryRepository;

	@Override
	public void saveAccountHistory(AccountHistoryDTO accountHistory) {
		accountHistory.setReferenceNumber(UUID.randomUUID());
		accountHistory.setTransferedDate(LocalDateTime.now());
		accountHistoryRepository.save(AccountHistoryAdapter.dtoToEntity(accountHistory));
	}
	
	@Override
	public AccountHistoryDTO getAccountHistoryByReferenceNumber(UUID referenceNumber) {
		return accountHistoryRepository.getAccountHistoryByReferenceNumber(referenceNumber).orElse(null);
	}

	@Override
	public List<AccountHistoryDTO> getAccountHistoryByAccountNumber(UUID accountNumber) {
		return accountHistoryRepository.getAccountHistoryByAccountNumber(accountNumber);
	}
}
