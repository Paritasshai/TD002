package com.tamdai.model.payment.repository;

import com.tamdai.model.payment.entity.BankStatement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankStatementRepository extends JpaRepository<BankStatement, Long> {

}
