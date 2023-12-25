package codingguru.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import codingguru.dto.AccountHistoryDTO;
import codingguru.entity.AccountHistory;

public interface AccountHistoryRepository extends JpaRepository<AccountHistory, UUID> {
	@Query(value = "SELECT new codingguru.dto.AccountHistoryDTO(ah.referenceNumber, ah.bankAccount, ah.transactionType, ah.transactionAmount, ah.transactionDate) "
				 + "FROM account_history ah WHERE ah.referenceNumber = :referenceNumber")
	public Optional<AccountHistoryDTO> getAccountHistoryByReferenceNumber(@Param("referenceNumber") UUID referenceNumber);
	
	@Query(value = "SELECT new codingguru.dto.AccountHistoryDTO(ah.referenceNumber, ah.bankAccount, ah.transactionType, ah.transactionAmount, ah.transactionDate) "
				 + "FROM account_history ah WHERE ah.bankAccount.accountNumber = :accountNumber")
	public List<AccountHistoryDTO> getAccountHistoryByAccountNumber(@Param("accountNumber") UUID accountNumber);
	
	@Query(value = "SELECT new codingguru.dto.AccountHistoryDTO(ah.referenceNumber, ah.bankAccount, ah.transactionType, ah.transactionAmount, ah.transactionDate) "
				 + "FROM account_history ah")
	public List<AccountHistoryDTO> getAllAccountHistory();
}
