package codingguru.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import codingguru.entity.BankAccount;

public interface BankAccountRepository extends JpaRepository<BankAccount, UUID> {

	@Query(value = "SELECT b from bank_account b where b.accountNumber = :accountNumber AND b.closedDate IS NULL")
	public Optional<BankAccount> findByAccountNumber(@Param("accountNumber") UUID accountNumber);
	
	@Modifying
	@Query(value = "UPDATE bank_account b SET b.balance = b.balance + :amount WHERE b.accountNumber = :accountNumber AND b.closedDate IS NULL")
	public void deposit(@Param("accountNumber") UUID accountNumber, @Param("amount") Double amount);
	
	@Modifying
	@Query(value = "UPDATE bank_account b SET b.balance = b.balance - :amount WHERE b.accountNumber = :accountNumber AND b.closedDate IS NULL")
	public void withdraw(@Param("accountNumber") UUID accountNumber, @Param("amount") Double amount);
	
	@Modifying
	@Query(value = "UPDATE bank_account b SET b.closedDate = CURRENT_TIMESTAMP() WHERE b.accountNumber = :accountNumber AND b.closedDate IS NULL")
	public void closeAccount(@Param("accountNumber") UUID accountNumber);
}
