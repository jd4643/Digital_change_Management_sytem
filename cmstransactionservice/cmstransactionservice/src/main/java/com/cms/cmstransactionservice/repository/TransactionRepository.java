package com.cms.cmstransactionservice.repository;

import com.cms.cmstransactionservice.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Long> {
}
