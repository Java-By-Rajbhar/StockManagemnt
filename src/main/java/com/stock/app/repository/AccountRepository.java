package com.stock.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.app.entity.Account;
/**
 * 
 * @author Sushil
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	public Account findByAccountId(int accountId);

}
